package apap.tutorial.emsidi.restcontroller;
import apap.tutorial.emsidi.model.PegawaiModel;
import apap.tutorial.emsidi.rest.CabangDetail;
import apap.tutorial.emsidi.service.PegawaiRestService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1")
public class PegawaiRestController {

    @Autowired
    private PegawaiRestService pegawaiRestService;

    @PostMapping(value = "/pegawai")
    private ResponseEntity createPegawai(@Valid @RequestBody PegawaiModel pegawai, BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Request body has invalid type or missing field."
            );
        } else {
            pegawaiRestService.createPegawai(pegawai);
            return ResponseEntity.ok("Create pegawai success");
        }
    }

    @GetMapping(value = "/pegawai/{noPegawai}")
    private PegawaiModel retrievePegawai(@PathVariable("noPegawai") Long noPegawai){
        try{
            return pegawaiRestService.getPegawaiByNoPegawai(noPegawai);
        } catch (NoSuchElementException e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "ID Pegawai " + String.valueOf(noPegawai) + " Not Found."
            );
        }
    }

    @DeleteMapping(value = "/pegawai/{noPegawai}")
    private ResponseEntity deletePegawai(@PathVariable("noPegawai") Long noPegawai){
        try{
            pegawaiRestService.deletePegawai(noPegawai);
            return ResponseEntity.ok("Pegawai with ID " + String.valueOf(noPegawai) + " has been Deleted!");
        } catch (NoSuchElementException e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "ID Pegawai " + String.valueOf(noPegawai) + " Not Found."
            );
        }catch (UnsupportedOperationException e){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Cabang is still open or has pegawai!"
            );
        }
    }

    @PutMapping(value="/pegawai/{noPegawai}")
    private ResponseEntity updatePegawai(@PathVariable("noPegawai") Long noPegawai, @RequestBody PegawaiModel pegawai) {
        try {
            pegawaiRestService.updatePegawai(noPegawai, pegawai);
            return ResponseEntity.ok("Update pegawai success");
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Pegawai with ID " + String.valueOf(noPegawai) + " Not Found!"
            );
        }
    }

    @GetMapping(value = "/list-pegawai")
    private List<PegawaiModel> retrieveListPegawai() {
        return pegawaiRestService.retrieveListPegawai();
    }

    @GetMapping(value="/pegawai/umur/{noPegawai}")
    private HashMap<String,Object> pegawaiMap(@PathVariable("noPegawai")Long noPegawai){
        return pegawaiRestService.simpanPegawaiUmur(noPegawai,pegawaiRestService.getUmur(noPegawai).block().getAge());
    }

//    @GetMapping(value = "/cabang/{noCabang}/status")
//    private Mono<String> getStatus(@PathVariable("noCabang") Long noCabang){
//        return cabangRestService.getStatus(noCabang);
//    }
//
//    @GetMapping(value = "/full")
//    private Mono<CabangDetail> postStatus(){
//        return cabangRestService.postStatus();
//    }
}
