package fr.formation.service;

import fr.formation.entity.Bouteille;
import fr.formation.exception.EntityException;
import fr.formation.repository.BouteilleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BouteilleService {

    @Autowired
    BouteilleDao bDao;

    public List<Bouteille> getAllBouteille(){ return bDao.findAll();}
    public void addBouteille(Bouteille b) throws EntityException {
        verif(b);
        bDao.save(b);
    }
    public void modifyBouteille(Bouteille b) throws EntityException{
        verif(b);
        bDao.save(b);
    }
    public void deleteBouteille(int id) {
        bDao.deleteById(id);
    }


    public Optional<Bouteille> getOneBouteille(int id) {


        return bDao.findById(id);
    }


    public List<Bouteille> triParNomOrdreAlpha(){ return bDao.findByOrderByNomAsc();}
    public List<Bouteille> triParNomOrdreAntiAlpha(){ return bDao.findByOrderByNomDesc();}

    public List<Bouteille> triParMillesimeOrdreAlpha(){ return bDao.findByOrderByMillesimeAsc();}
    public List<Bouteille> triparMillesimeOrdreAntiAlpha(){ return bDao.findByOrderByMillesimeDesc();}

    public List<Bouteille> triParPetillantAsc(){ return bDao.findByOrderByPetillantAsc();}
    public List<Bouteille> triParPetillantDesc(){ return bDao.findByOrderByPetillantDesc();}

    public List<Bouteille> triParQuantiteAsc(){ return bDao.findByOrderByQuantiteAsc();}
    public List<Bouteille> triParQuantiteDesc(){ return bDao.findByOrderByQuantiteDesc();}

    public List<Bouteille> triParCouleurOrdreAlpha(){ return bDao.findByOrderByCouleurNomAsc();}
    public List<Bouteille> triParCouleurOrdreAntiAlpha(){ return bDao.findByOrderByCouleurNomDesc();}

    public List<Bouteille> triParRegionOrdreAlpha(){ return bDao.findByOrderByRegionNomAsc();}
    public List<Bouteille> triParRegionOrdreAntiAlpha(){ return bDao.findByOrderByRegionNomDesc() ;}

    public List<Bouteille> getSearchedBouteilles(String term) {

        return bDao.findDistinctByNomContainingOrRegionNomContainingOrCouleurNomContaining(term, term, term) ;
    }


    private void verif(Bouteille b) throws EntityException{
        if (null == b.getCouleur())
            throw new EntityException("Choisissez une couleur valide");
        if (null == b.getRegion())
            throw new EntityException("Choisissez une region valide");
        if (null == b.getMillesime() || b.getMillesime().trim().equals(""))
            throw new EntityException("Millesime non renseigné");
        if ( null == b.getMillesime() || b.getNom().trim().equals(""))
            throw new EntityException("Nom non renseigné");
        if ( b.getQuantite() == 0)
            throw new EntityException("Quantité ne peux pas etre 0");
    }
}
