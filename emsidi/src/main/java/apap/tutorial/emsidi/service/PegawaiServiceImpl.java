package apap.tutorial.emsidi.service;

import apap.tutorial.emsidi.model.CabangModel;
import apap.tutorial.emsidi.model.PegawaiModel;
import apap.tutorial.emsidi.repository.PegawaiDb;
import apap.tutorial.emsidi.repository.CabangDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalTime;
import java.util.Optional;

@Service
@Transactional

public class PegawaiServiceImpl implements PegawaiService{

    @Autowired
    PegawaiDb pegawaiDb;

    @Autowired
    CabangDb cabangDb;

    @Override
    public void addPegawai(PegawaiModel pegawai){
        pegawaiDb.save(pegawai);
    }

    @Override
    public PegawaiModel getPegawaiByNoPegawai(Long noPegawai){
        PegawaiModel pegawai = pegawaiDb.findByNoPegawai(noPegawai);
        return pegawai;
    }

    @Override
    public String updatePegawai(PegawaiModel pegawai){
        PegawaiModel pegawaiCabang = pegawaiDb.findByNoPegawai(pegawai.getNoPegawai());
        CabangModel cabang = cabangDb.findByNoCabang(pegawaiCabang.getCabang().getNoCabang()).get();

        LocalTime waktuSekarang = LocalTime.now();
        LocalTime jamBuka = cabang.getWaktuBuka();
        LocalTime jamTutup = cabang.getWaktuTutup();

        if(waktuSekarang.isBefore(jamBuka) || waktuSekarang.isAfter(jamTutup)){
            pegawaiCabang.setNamaPegawai(pegawai.getNamaPegawai());
            pegawaiCabang.setJenisKelamin(pegawai.getJenisKelamin());
            pegawaiDb.save(pegawaiCabang);
            return "berhasil";
        }else{
            return "tidak berhasil";
        }
    }

    @Override
        public String deletePegawai(PegawaiModel pegawai){
        PegawaiModel pegawaiCabang = pegawaiDb.findByNoPegawai(pegawai.getNoPegawai());
        CabangModel cabang = cabangDb.findByNoCabang(pegawaiCabang.getCabang().getNoCabang()).get();

        LocalTime waktuSekarang = LocalTime.now();
        LocalTime jamBuka = cabang.getWaktuBuka();
        LocalTime jamTutup = cabang.getWaktuTutup();

        if(waktuSekarang.isBefore(jamBuka) || waktuSekarang.isAfter(jamTutup)){
            pegawaiDb.delete(pegawaiCabang);
            return "berhasil";
        }else{
            return "tidak berhasil";
        }
    }

}
