package apap.tutorial.kebunsafari.controller;

import apap.tutorial.kebunsafari.model.KebunSafariModel;
import org.springframework.ui.Model;
import apap.tutorial.kebunsafari.service.KebunSafariService;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class KebunSafariController {
    @Autowired
    private KebunSafariService kebunSafariService;

    @RequestMapping("/kebun-safari/add")
    public String addKebunSafari(
            @RequestParam (value="id", required = true) String idKebunSafari,
            @RequestParam (value="nama", required = true) String namaKebunSafari,
            @RequestParam (value="alamat",required = true) String alamat,
            @RequestParam (value = "noTelepon", required = true) String noTelepon,
            Model model
    ){
        //Membuat Objek Kebun Safari Baru
        KebunSafariModel kebunSafari = new KebunSafariModel(idKebunSafari, namaKebunSafari, alamat, noTelepon);

        //Memanggil Service addKebunSafari
        kebunSafariService.addKebunSafari(kebunSafari);

        //Menambahkan variabel kebunSafari untuk dirender di thymeleaf
        model.addAttribute("kebunSafari",kebunSafari);

        //Mereturn template html yang dipakai
        return "add-kebun-safari";
    }

    @RequestMapping("/")
    public String listKebunSafari(Model model){
        //Mendapatkan list seluruh objek Kebun Safari
        List<KebunSafariModel> listKebunSafari = kebunSafariService.getKebunSafariList();

        //Menambahkan list untuk dirender di Thymeleaf
        model.addAttribute("listKebunSafari",listKebunSafari);

        //Mereturn template html yang dipakai
        return "get-all-kebun-safari";
    }

    @RequestMapping("/kebun-safari")
    public String getKebunSafariById(@RequestParam( value="id",required = true) String idKebunSafari, Model model){
        //Mendapatkan objek Kebun Safari sesuai dengan ID
        KebunSafariModel kebunSafari = kebunSafariService.getKebunSafariByIdKebunSafari(idKebunSafari);
        if(Objects.isNull(kebunSafari)){
            model.addAttribute("msg","Id Kebun Safari tidak dapat ditemukan");
        }else{
            //Menambahkan objek untuk dirender di Thymeleaf
            model.addAttribute("kebunSafari", kebunSafari);
        }
        //Mereturn template html yang dipakai
        return "detail-kebun-safari";
    }

    @RequestMapping("/kebun-safari/view/{idKebunSafari}")
    public String getKebunSafariByIdWithPathVariable(
            @PathVariable(value="idKebunSafari", required = true)String idKebunSafari,Model model){
        //Mendapatkan objek Kebun Safari sesuai dengan ID
        KebunSafariModel kebunSafari = kebunSafariService.getKebunSafariByIdKebunSafari(idKebunSafari);
        if(Objects.isNull(kebunSafari)){
            model.addAttribute("msg","Id Kebun Safari tidak dapat ditemukan");
        }else{
            //Menambahkan objek untuk dirender di Thymeleaf
            model.addAttribute("kebunSafari", kebunSafari);
        }
        //Mereturn template html yang dipakai
        return "detail-kebun-safari";
    }

    @RequestMapping("/kebun-safari/update/{idKebunSafari}")
    public String updatenoTelponByIdKebunSafari(
            @PathVariable(value="idKebunSafari", required = true)String idKebunSafari,
            @RequestParam (value = "noTelepon", required = true) String noTelepon,
            Model model){
        //Mendapatkan objek Kebun Safari sesuai dengan ID
        KebunSafariModel kebunSafari = kebunSafariService.getKebunSafariByIdKebunSafari(idKebunSafari);
        if(Objects.isNull(kebunSafari)){
            model.addAttribute("msg","Id Kebun Safari tidak dapat ditemukan");
        }else{
            kebunSafari.setNoTelepon(noTelepon);
            //Menambahkan objek untuk dirender di Thymeleaf
            model.addAttribute("kebunSafari", kebunSafari);
        }
        //Mereturn template html yang dipakai
        return "update-notelp-safari";
    }

    @RequestMapping("/kebun-safari/delete/{idKebunSafari}")
    public String deleteKebunSafari(
            @PathVariable(value = "idKebunSafari", required = true) String idKebunSafari,
            Model model){
        //Mendapatkan objek Kebun Safari sesuai dengan ID
        KebunSafariModel kebunSafari = kebunSafariService.getKebunSafariByIdKebunSafari(idKebunSafari);
        if(Objects.isNull(kebunSafari)){
            model.addAttribute("msg","Id Kebun Safari tidak dapat ditemukan");
        }else{
            //Menambahkan objek untuk dirender di Thymeleaf
            model.addAttribute("kebunSafari", kebunSafari);
            kebunSafariService.getKebunSafariList().remove(kebunSafari);
        }

        return "delete-kebun-safari";
    }

}
