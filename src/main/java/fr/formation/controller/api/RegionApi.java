package fr.formation.controller.api;

import fr.formation.entity.Region;
import fr.formation.exception.EntityException;
import fr.formation.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Void> addRegion(@RequestBody Region r){
        try {
            rServ.addRegion(r);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (EntityException e) {
            HttpHeaders headers = new HttpHeaders();
            headers.add("message", e.getMessage());
            return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/modify/{id}")
    public ResponseEntity<Void> modifyRegion(@PathVariable("id") int id, @RequestBody Region r){

        try {
            rServ.modifyRegion(r);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (EntityException e) {
            HttpHeaders headers = new HttpHeaders();
            headers.add("message", e.getMessage());
            return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/delete/{id}")
    public void deleteRegion(@PathVariable("id") int id){
        rServ.deleteRegion(id);
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
