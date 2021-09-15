package apap.tutorial.kebunsafari.service;

import apap.tutorial.kebunsafari.model.KebunSafariModel;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class KebunSafariInMemoryService implements KebunSafariService{
    private List<KebunSafariModel> listKebunSafari;

    // Constructor
    private KebunSafariInMemoryService(){
        listKebunSafari = new ArrayList<>();
    }

    @Override
    public void addKebunSafari(KebunSafariModel kebunSafari){
        listKebunSafari.add(kebunSafari);
    }
    @Override
    public List<KebunSafariModel> getKebunSafariList(){
        return listKebunSafari;
    }

    @Override
    public KebunSafariModel getKebunSafariByIdKebunSafari(String idKebunSafari){
        for(int i=0; i<this.getKebunSafariList().size();i++){
            if(this.getKebunSafariList().get(i).getIdKebunSafari().equalsIgnoreCase(idKebunSafari)){
                return this.getKebunSafariList().get(i);
            }
        }
        return null;
    }

//    @Override
//    public void updatenoTelponByIdKebunSafari(String idKebunSafari, String noTelepon){
//        for(int i=0; i<this.getKebunSafariList().size();i++){
//            if(this.getKebunSafariList().get(i).getIdKebunSafari().equalsIgnoreCase(idKebunSafari)){
//                this.getKebunSafariList().get(i).setNoTelepon(noTelepon);
//            }
//        }
//    }

}
