package fr.formation.controller.api;

import fr.formation.entity.Couleur;
import fr.formation.exception.EntityException;
import fr.formation.service.CouleurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/couleurs")
public class CouleurApi {

    @Autowired
    CouleurService cServ;

    @GetMapping("/all")
    public List<Couleur> getCouleurs(){
        return cServ.getAllCouleur();
    }
    @PostMapping("/add")
    public ResponseEntity<Void> addCouleur(@RequestBody Couleur c){
        try {
            cServ.addCouleur(c);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (EntityException e) {
            HttpHeaders headers = new HttpHeaders();
            headers.add("message", e.getMessage());
            return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/modify/{id}")
    public ResponseEntity<Void> modifyCouleur(@PathVariable("id") int id, @RequestBody Couleur c){
        System.out.println("id = " + id);
        System.out.println("couleur = " +  c);
        c.setId(id);
        try {
            cServ.modifyCouleur(c);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (EntityException e) {
            HttpHeaders headers = new HttpHeaders();
            headers.add("message", e.getMessage());
            return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/delete/{id}")
    public void deleteCouleur(@PathVariable("id") int id){
        cServ.deleteCouleur(id);
    }



    @GetMapping("/triIdAsc")
    public List<Couleur>  triIdAsc(){
        return cServ.triParIdAsc();
    }
    @GetMapping("/triIdDesc")
    public List<Couleur>  triIdDesc(){return cServ.triParIdDesc();}

    @GetMapping("/triNomAlpha")
    public List<Couleur>  triNomAlpha(){
        return cServ.triParNomOrdreAlpha();
    }
    @GetMapping("/triNomAntiAlpha")
    public List<Couleur>  triNomAntiAlpha(){return cServ.triParNomOrdreAntiAlpha();}

}
