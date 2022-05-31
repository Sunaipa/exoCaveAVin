package fr.formation.service;

import fr.formation.entity.Couleur;
import fr.formation.entity.Region;
import fr.formation.exception.EntityException;
import fr.formation.repository.RegionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionService {

    @Autowired
    RegionDao rDao;

    public List<Region> getAllRegion() {
        return rDao.findAll();
    }
    public void addRegion(Region r) throws EntityException {
        verif(r);
        rDao.save(r);}
    public void modifyRegion(Region r) throws EntityException {
        verif(r);
        rDao.save(r);}
    public void deleteRegion(int id) { rDao.deleteById(id);}


    public List<Region> triParNomOrdreAlpha(){ return rDao.findByOrderByNomAsc();}
    public List<Region> triParNomOrdreAntiAlpha(){ return rDao.findByOrderByNomDesc();}

    public List<Region> triParIdAsc(){ return rDao.findByOrderByIdAsc();}
    public List<Region> triParIdDesc(){ return rDao.findByOrderByIdDesc();}

    private void verif(Region r) throws EntityException {
        if (null == r.getNom() || r.getNom().trim().equals(""))
            throw new EntityException("Nom non renseigné");
    }

}
