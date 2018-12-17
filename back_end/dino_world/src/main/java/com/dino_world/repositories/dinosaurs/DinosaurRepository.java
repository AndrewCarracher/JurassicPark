package com.dino_world.repositories.dinosaurs;

import com.dino_world.models.Dinosaur;
import com.dino_world.projections.DinosaurProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(excerptProjection = DinosaurProjection.class)
public interface DinosaurRepository extends JpaRepository<Dinosaur, Long>, DinosaurRepositoryCustom {

}
