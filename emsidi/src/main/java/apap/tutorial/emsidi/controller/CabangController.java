package apap.tutorial.emsidi.controller;

import apap.tutorial.emsidi.model.CabangModel;
import apap.tutorial.emsidi.model.PegawaiModel;
import apap.tutorial.emsidi.service.CabangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

@Controller
public class CabangController {

    @Qualifier("cabangServiceImpl")
    @Autowired
    private CabangService cabangService;

    @GetMapping("/cabang/add")
    public String addCabangForm(Model model){
        model.addAttribute("cabang", new CabangModel());
        return "form-add-cabang";
    }

    @PostMapping("/cabang/add")
    public String addCabangSubmit(
            @ModelAttribute CabangModel cabang,
            Model model
    ){
        cabangService.addCabang(cabang);
        model.addAttribute("noCabang", cabang.getNoCabang());
        return "add-cabang";
    }

    @GetMapping("/cabang/viewall")
    public String listCabang(Model model){
        List<CabangModel> listCabang = cabangService.getCabangList();
        model.addAttribute("listCabang", listCabang);
        return "viewall-cabang";
    }

    @GetMapping("/cabang/view")
    public String viewDetailCabang(
            @RequestParam(value = "noCabang") Long noCabang,
            Model model
    ){
        CabangModel cabang = cabangService.getCabangByNoCabang(noCabang);
        List<PegawaiModel> listPegawai = cabang.getListPegawai();

        model.addAttribute("cabang", cabang);
        model.addAttribute("listPegawai", listPegawai);

        return "view-cabang";
    }

    @GetMapping("/cabang/update/{noCabang}")
    public String updateCabangForm(
            @PathVariable Long noCabang,
            Model model
    ){
        CabangModel cabang = cabangService.getCabangByNoCabang(noCabang);
        model.addAttribute("cabang",cabang);
        return "form-update-cabang";
    }

    @PostMapping("/cabang/update")
    public String updateCabangSubmit(
            @ModelAttribute CabangModel cabang,
            Model model
    ){
        for(int i=0;i<cabangService.getCabangList().size();i++){
            if(cabang.getNamaCabang().equalsIgnoreCase(cabangService.getCabangList().get(i).getNamaCabang())){
                model.addAttribute("msg", "Nama Cabang sudah ada");
            }else{
                cabangService.updateCabang(cabang);
                model.addAttribute("noCabang", cabang.getNoCabang());
            }
        }
        return "update-cabang";
    }

    @GetMapping("/cabang/viewallAsc")
    public String listCabangByNamaAsc(Model model){
        List<CabangModel> listCabangAsc = cabangService.getCabangByOrderByNamaCabangAsc();
        model.addAttribute("listCabangAsc", listCabangAsc);
        return "viewall-cabangAsc";
    }

    @GetMapping("cabang/delete/{noCabang}")
    public String deleteCabang(
            @PathVariable Long noCabang,
            @ModelAttribute CabangModel Objcabang,
            Model model
    ){
        CabangModel cabang = cabangService.getCabangByNoCabang(noCabang);
        String deleteCabang = cabangService.deleteCabang(cabang);

        if(deleteCabang.equalsIgnoreCase("berhasil")){
            model.addAttribute("msg","Berhasil delete Cabang");
        }else{
            model.addAttribute("msg", "Tidak berhasil delete Cabang pada saat ini");
        }

        return "delete-cabang";

    }
}