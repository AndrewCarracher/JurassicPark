package com.dino_world.repositories.parks;

import com.dino_world.models.Park;
import com.dino_world.projections.ParkProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(excerptProjection = ParkProjection.class)
public interface ParkRepository extends JpaRepository<Park, Long>, ParkRepositoryCustom {


}
