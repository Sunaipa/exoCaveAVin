package fr.formation.repository;

import fr.formation.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegionDao extends JpaRepository<Region, Integer> {
    List<Region> findByOrderByNomDesc();
    List<Region> findByOrderByNomAsc();

    List<Region> findByOrderByIdAsc();
    List<Region> findByOrderByIdDesc();
}
