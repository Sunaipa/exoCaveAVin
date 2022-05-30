package fr.formation.controller.api;

import fr.formation.entity.Region;
import fr.formation.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/regions")
public class RegionApi {

    @Autowired
    RegionService rServ;

    @GetMapping("/all")
    public List<Region> getRegions(){
        return rServ.getAllRegion();
    }
    @PostMapping("/add")
    public void addRegion(Region r){
        rServ.addRegion(r);
    }
    @PutMapping("/modify")
    public void modifyRegion(Region r){
        rServ.modifyRegion(r);
    }
    @GetMapping("/delete")
    public void deleteRegion(Region r){
        rServ.deleteRegion(r);
    }



    @GetMapping("/triIdAsc")
    public List<Region>  triIdAsc(){
        return rServ.triParIdAsc();
    }
    @GetMapping("/triIdDesc")
    public List<Region>  triIdDesc(){return rServ.triParIdDesc();}

    @GetMapping("/triNomAlpha")
    public List<Region>  triNomAlpha(){
        return rServ.triParNomOrdreAlpha();
    }
    @GetMapping("/triNomAntiAlpha")
    public List<Region>  triNomAntiAlpha(){return rServ.triParNomOrdreAntiAlpha();}

}
