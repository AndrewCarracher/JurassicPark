package com.dino_world.repositories.paddocks;

import com.dino_world.models.Paddock;
import com.dino_world.projections.PaddockProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(excerptProjection = PaddockProjection.class)
public interface PaddockRepository extends JpaRepository<Paddock, Long>, PaddockRepositoryCustom{
}
