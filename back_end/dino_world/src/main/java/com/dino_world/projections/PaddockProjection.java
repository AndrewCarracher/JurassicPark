package com.dino_world.projections;

import com.dino_world.models.Paddock;
import org.springframework.data.rest.core.config.Projection;

@Projection(name= "embedPaddock", types = Paddock.class)
public interface PaddockProjection {
}
