package com.dino_world.projections;

import com.dino_world.models.Park;
import org.springframework.data.rest.core.config.Projection;

@Projection(name= "embedPark", types = Park.class)
public interface ParkProjection {
}
