package fr.formation.repository;

import fr.formation.entity.Bouteille;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BouteilleDao extends JpaRepository<Bouteille, Integer> {
    List<Bouteille> findByOrderByNomAsc();
    List<Bouteille> findByOrderByNomDesc();

    List<Bouteille> findByOrderByMillesimeAsc();
    List<Bouteille> findByOrderByMillesimeDesc();

    List<Bouteille> findByOrderByPetillantAsc();
    List<Bouteille> findByOrderByPetillantDesc();

    List<Bouteille> findByOrderByQuantiteAsc();
    List<Bouteille> findByOrderByQuantiteDesc();

    List<Bouteille> findByOrderByCouleurNomAsc();
    List<Bouteille> findByOrderByCouleurNomDesc();

    List<Bouteille> findByOrderByRegionNomAsc();
    List<Bouteille> findByOrderByRegionNomDesc();

    List<Bouteille> findDistinctByNomContainingOrRegionNomContainingOrCouleurNomContaining(String term, String term2, String term3);

}
