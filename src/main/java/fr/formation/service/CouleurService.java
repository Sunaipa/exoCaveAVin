package fr.formation.service;

import fr.formation.entity.Couleur;
import fr.formation.repository.CouleurDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouleurService {

    @Autowired
    CouleurDao cDao;

    public List<Couleur> getAllCouleur() {
        return cDao.findAll();
    }
    public void addCouleur(Couleur c) {cDao.save(c);}
    public void modifyCouleur(Couleur c) {cDao.save(c);}
    public void deleteCouleur(Couleur c) { cDao.delete(c);}


    public List<Couleur> triParNomOrdreAlpha(){ return cDao.findByOrderByNomAsc();}
    public List<Couleur> triParNomOrdreAntiAlpha(){ return cDao.findByOrderByNomDesc();}

    public List<Couleur> triParIdAsc(){ return cDao.findByOrderByIdAsc();}
    public List<Couleur> triParIdDesc(){ return cDao.findByOrderByIdDesc();}

}
