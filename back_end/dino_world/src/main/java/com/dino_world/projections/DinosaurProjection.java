package com.dino_world.projections;

import com.dino_world.models.Dinosaur;
import org.springframework.data.rest.core.config.Projection;

@Projection(name= "embedDinosaur", types = Dinosaur.class)
public interface DinosaurProjection {
}
