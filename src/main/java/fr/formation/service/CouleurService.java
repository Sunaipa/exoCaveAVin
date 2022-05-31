package fr.formation.service;

import fr.formation.entity.Couleur;
import fr.formation.exception.EntityException;
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
    public void addCouleur(Couleur c) throws EntityException{
        verif(c);
        cDao.save(c);
    }
    public void modifyCouleur(Couleur c) throws EntityException{
        verif(c);
        cDao.save(c);
    }
    public void deleteCouleur(int id) { cDao.deleteById(id);}


    public List<Couleur> triParNomOrdreAlpha(){ return cDao.findByOrderByNomAsc();}
    public List<Couleur> triParNomOrdreAntiAlpha(){ return cDao.findByOrderByNomDesc();}

    public List<Couleur> triParIdAsc(){ return cDao.findByOrderByIdAsc();}
    public List<Couleur> triParIdDesc(){ return cDao.findByOrderByIdDesc();}

    private void verif(Couleur c) throws EntityException{
        if (null == c.getNom() || c.getNom().trim().equals(""))
            throw new EntityException("Nom non renseigné");
    }

}
