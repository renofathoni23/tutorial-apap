package apap.tutorial.emsidi.service;

import apap.tutorial.emsidi.model.CabangModel;
import apap.tutorial.emsidi.model.PegawaiModel;

public interface PegawaiService {
    void addPegawai(PegawaiModel pegawai);
    PegawaiModel getPegawaiByNoPegawai(Long noPegawai);
    String updatePegawai(PegawaiModel pegawai);
    String deletePegawai(PegawaiModel pegawai);

}
