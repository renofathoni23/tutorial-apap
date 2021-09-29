package apap.tutorial.emsidi.service;

import apap.tutorial.emsidi.model.CabangModel;
import apap.tutorial.emsidi.model.PegawaiModel;
import apap.tutorial.emsidi.repository.CabangDb;
import apap.tutorial.emsidi.repository.PegawaiDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class CabangServiceImpl implements CabangService {

    @Autowired
    CabangDb cabangDb;

    @Autowired
    PegawaiDb pegawaiDb;

    @Override
    public void addCabang(CabangModel cabang){
        cabangDb.save(cabang);
    }

    @Override
    public void updateCabang(CabangModel cabang){
        cabangDb.save(cabang);
    }

    @Override
    public List<CabangModel> getCabangList(){
        return cabangDb.findAll();
    }

    @Override
    public CabangModel getCabangByNoCabang(Long noCabang){
        Optional <CabangModel> cabang = cabangDb.findByNoCabang(noCabang);
        if(cabang.isPresent()){
            return cabang.get();
        }
        return null;
    }

    @Override
    public List<CabangModel> getCabangByOrderByNamaCabangAsc(){
        return cabangDb.findByOrderByNamaCabangAsc();
    }

    @Override
    public String deleteCabang (CabangModel cabang){
        CabangModel cabangObj = cabangDb.findByNoCabang(cabang.getNoCabang()).get();

        LocalTime waktuSekarang = LocalTime.now();
        LocalTime jamBuka = cabang.getWaktuBuka();
        LocalTime jamTutup = cabang.getWaktuTutup();
        int jumlahPegawai = cabangObj.getListPegawai().size();

        if(jumlahPegawai == 0 && (waktuSekarang.isBefore(jamBuka) || waktuSekarang.isAfter(jamTutup))){
            cabangDb.delete(cabangObj);
            return "berhasil";
        }else{
            return "tidak berhasil";
        }
    }



}
