package apap.tutorial.emsidi.service;

import apap.tutorial.emsidi.model.PegawaiModel;
//import apap.tutorial.emsidi.rest.PegawaiDetail;
import apap.tutorial.emsidi.rest.DetailPegawai;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.List;

public interface PegawaiRestService {
    PegawaiModel createPegawai(PegawaiModel pegawai);
    List<PegawaiModel> retrieveListPegawai();
    PegawaiModel getPegawaiByNoPegawai(Long noPegawai);
    PegawaiModel updatePegawai(Long noPegawai, PegawaiModel pegawaiUpdate);
    void deletePegawai(Long noPegawai);
    Mono<DetailPegawai> getUmur(Long noPegawai);
    HashMap<String,Object> simpanPegawaiUmur(Long noPegawai, String umur);
//    Mono<PegawaiDetail> postStatus();
}