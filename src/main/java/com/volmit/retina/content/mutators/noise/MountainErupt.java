package com.volmit.retina.content.mutators.noise;

import com.volmit.retina.content.tags.Altitude;
import com.volmit.retina.content.tags.Mountain;
import com.volmit.retina.generator.RetinaBiome;
import com.volmit.retina.generator.RetinaWorld;
import com.volmit.retina.generator.mutator.RetinaHeightMutator;

public class MountainErupt implements RetinaHeightMutator {
    public MountainErupt(RetinaWorld world)
    {

    }

    @Override
    public String getKey() {
        return "mountain-erupt";
    }

    @Override
    public double mutateHeight(RetinaBiome biome, double height) {
        double v = (biome.get(Mountain.class) - 0.5) * 2;

        if(v > 0)
        {
            return (v * biome.get(Altitude.class) * 0.4) + height;
        }

        return height;
    }

    @Override
    public double getWeight(RetinaBiome biome) {
        return biome.get(Mountain.class);
    }
}
