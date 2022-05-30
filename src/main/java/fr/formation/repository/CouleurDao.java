package fr.formation.repository;

import fr.formation.entity.Couleur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CouleurDao extends JpaRepository<Couleur, Integer> {

    List<Couleur> findByOrderByNomAsc();
    List<Couleur> findByOrderByNomDesc();
    List<Couleur> findByOrderByIdAsc();
    List<Couleur> findByOrderByIdDesc();
}
