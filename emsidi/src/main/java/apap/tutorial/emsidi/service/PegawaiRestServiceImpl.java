package apap.tutorial.emsidi.service;

import apap.tutorial.emsidi.model.CabangModel;
import apap.tutorial.emsidi.model.PegawaiModel;
import apap.tutorial.emsidi.repository.CabangDb;
import apap.tutorial.emsidi.repository.PegawaiDb;
//import apap.tutorial.emsidi.rest.PegawaiDetail;
import apap.tutorial.emsidi.rest.DetailPegawai;
import apap.tutorial.emsidi.rest.Setting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PegawaiRestServiceImpl implements PegawaiRestService {

    private final WebClient webClient;

    @Autowired
    private PegawaiDb pegawaiDb;

    @Autowired
    private CabangDb cabangDb;

    @Override
    public PegawaiModel createPegawai(PegawaiModel pegawai) {
        return pegawaiDb.save(pegawai);
    }

    @Override
    public List<PegawaiModel> retrieveListPegawai() {
        return pegawaiDb.findAll();
    }

    @Override
    public PegawaiModel getPegawaiByNoPegawai(Long noPegawai) {
        PegawaiModel pegawai = pegawaiDb.findByNoPegawai(noPegawai);
        return pegawai;
    }

    @Override
    public PegawaiModel updatePegawai(Long noPegawai, PegawaiModel pegawaiUpdate) {
        PegawaiModel pegawai = getPegawaiByNoPegawai(noPegawai);
        CabangModel cabang = cabangDb.findByNoCabang(pegawai.getCabang().getNoCabang()).get();

        LocalTime waktuSekarang = LocalTime.now();
        LocalTime jamBuka = cabang.getWaktuBuka();
        LocalTime jamTutup = cabang.getWaktuTutup();

        if(waktuSekarang.isBefore(jamBuka) || waktuSekarang.isAfter(jamTutup)){
            pegawai.setNamaPegawai(pegawaiUpdate.getNamaPegawai());
            pegawai.setJenisKelamin(pegawaiUpdate.getJenisKelamin());
            pegawai.setCabang(pegawaiUpdate.getCabang());
            return pegawaiDb.save(pegawai);
        }else{
            return null;
        }
    }

    @Override
    public void deletePegawai(Long noPegawai) {
        PegawaiModel pegawai= getPegawaiByNoPegawai(noPegawai);
        CabangModel cabang = cabangDb.findByNoCabang(pegawai.getCabang().getNoCabang()).get();

        LocalTime waktuSekarang = LocalTime.now();
        LocalTime jamBuka = cabang.getWaktuBuka();
        LocalTime jamTutup = cabang.getWaktuTutup();

        if(waktuSekarang.isBefore(jamBuka) || waktuSekarang.isAfter(jamTutup)){
            pegawaiDb.delete(pegawai);
        }else{

        }
    }
    public PegawaiRestServiceImpl(WebClient.Builder webClientBuilder){
        this.webClient = webClientBuilder.baseUrl("https://agify.io/").build();
    }

    @Override
    public Mono<DetailPegawai> getUmur(Long noPegawai){
        String pegawainama = pegawaiDb.findByNoPegawai(noPegawai).getNamaPegawai();
        return this.webClient.get().uri("https://api.agify.io?name="+ pegawainama.split(" ")[0])
                .retrieve()
                .bodyToMono(DetailPegawai.class);
    }

    @Override
    public HashMap<String,Object> simpanPegawaiUmur(Long noPegawai, String umur){
        PegawaiModel pegawai = pegawaiDb.findByNoPegawai(noPegawai);
        pegawai.setUmur(umur);
        pegawaiDb.save(pegawai);

        HashMap<String,Object> map = new HashMap<>();
        map.put("noPegawai",pegawai.getNoPegawai());
        map.put("namaPegawai",pegawai.getNamaPegawai().split(" ")[0]);
        map.put("jenisKelamin",pegawai.getJenisKelamin());
        map.put("umur",pegawai.getUmur());

        return map;
    }


}
