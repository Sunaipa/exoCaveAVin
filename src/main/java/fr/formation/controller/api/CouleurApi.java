package fr.formation.controller.api;

import fr.formation.entity.Couleur;
import fr.formation.service.CouleurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CouleurApi {

    @Autowired
    CouleurService cServ;

    @GetMapping("/all")
    public List<Couleur> getCouleurs(){
        return cServ.getAllCouleur();
    }
    @PostMapping("/add")
    public void addCouleur(Couleur c){cServ.addCouleur(c);}
    @PutMapping("/modify")
    public void modifyCouleur(Couleur c){cServ.modifyCouleur(c);}
    @DeleteMapping("/delete")
    public void deleteCouleur(Couleur c){
        cServ.deleteCouleur(c);
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
