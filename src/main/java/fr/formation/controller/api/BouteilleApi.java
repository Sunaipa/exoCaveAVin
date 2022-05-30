package fr.formation.controller.api;

import fr.formation.entity.Bouteille;
import fr.formation.service.BouteilleService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @PostMapping("/add")
    public void addBouteille(Bouteille b){
        bServ.addBouteille(b);
    }
    @PutMapping("/modify")
    public void modifyBouteille(Bouteille b){ bServ.modifyBouteille(b);}
    @DeleteMapping("/delete")
    public void deleteBouteille(Bouteille b){
        bServ.deleteBouteille(b);
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
