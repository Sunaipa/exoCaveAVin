package fr.formation.controller.api;

import fr.formation.entity.Bouteille;
import fr.formation.exception.EntityException;
import fr.formation.service.BouteilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bouteilles")
public class BouteilleApi {

    @Autowired
    BouteilleService bServ;

    @GetMapping("/all")
    public List<Bouteille> getBouteilles(){
        return bServ.getAllBouteille();
    }

    @GetMapping("/search/{term}")
    public List<Bouteille> getSearchedBouteilles(@PathVariable("term") String term){ return bServ.getSearchedBouteilles(term);}

    @PostMapping("/add")
    public ResponseEntity<Void> addBouteille(@RequestBody Bouteille b) {
        try {
            bServ.addBouteille(b);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (EntityException e) {
            HttpHeaders headers = new HttpHeaders();
            headers.add("message", e.getMessage());
            return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/modify/{id}")
    public ResponseEntity<Void> modifyBouteille(@PathVariable("id") int id, @RequestBody Bouteille b){
        try {
            b.setId(id);
            bServ.modifyBouteille(b);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (EntityException e) {
            HttpHeaders headers = new HttpHeaders();
            headers.add("message", e.getMessage());
            return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBouteille(@PathVariable("id") int id){
        bServ.deleteBouteille(id);
    }


    @GetMapping("/getOne/{id}")
    public Optional<Bouteille> getOneBouteille(@PathVariable("id") int id){
        return bServ.getOneBouteille(id);
    }


    @GetMapping("/triNomAlpha")
    public List<Bouteille>  triNomAlpha(){
        return bServ.triParNomOrdreAlpha();
    }
    @GetMapping("/triNomAntiAlpha")
    public List<Bouteille>  triNomAntiAlpha(){return bServ.triParNomOrdreAntiAlpha();}

    @GetMapping("/triMillesimeAlpha")
    public List<Bouteille>  triMillesimeAlpha(){
        return bServ.triParMillesimeOrdreAlpha();
    }
    @GetMapping("/triMillesimeAntiAlpha")
    public List<Bouteille>  triMillesimeAntiAlpha(){return bServ.triparMillesimeOrdreAntiAlpha();}

    @GetMapping("/triPetillantAsc")
    public List<Bouteille>  triPetillantAlpha(){return bServ.triParPetillantAsc();}
    @GetMapping("/triPetillantDesc")
    public List<Bouteille>  triPetillantAntiAlpha(){return bServ.triParPetillantDesc();}

    @GetMapping("/triQuantiteAsc")
    public List<Bouteille>  triQuantiteAsc(){return bServ.triParQuantiteAsc();}
    @GetMapping("/triQuantiteDesc")
    public List<Bouteille>  triQuantiteAntiDesc(){return bServ.triParQuantiteDesc();}

    @GetMapping("/triNomRegionAlpha")
    public List<Bouteille>  triNomRegionAlpha(){return bServ.triParRegionOrdreAlpha();}
    @GetMapping("/triNomRegionAntiAlpha")
    public List<Bouteille>  triNomRegionAntiAlpha(){return bServ.triParRegionOrdreAntiAlpha();}

    @GetMapping("/triNomCouleurAlpha")
    public List<Bouteille>  triNomCouleurAlpha(){return bServ.triParCouleurOrdreAlpha();}
    @GetMapping("/triNomCouleurAntiAlpha")
    public List<Bouteille>  triNomCouleurAntiAlpha(){return bServ.triParCouleurOrdreAntiAlpha();}


}
