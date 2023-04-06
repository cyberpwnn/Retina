package com.volmit.retina.content.mutators.noise;

import com.volmit.retina.content.tags.Altitude;
import com.volmit.retina.content.tags.Arid;
import com.volmit.retina.content.tags.Dune;
import com.volmit.retina.content.tags.Mountain;
import com.volmit.retina.generator.RetinaBiome;
import com.volmit.retina.generator.RetinaWorld;
import com.volmit.retina.generator.mutator.RetinaHeightMutator;

public class Dunes implements RetinaHeightMutator {
    public Dunes(RetinaWorld world)
    {

    }

    @Override
    public String getKey() {
        return "dunes-generator";
    }

    @Override
    public double mutateHeight(RetinaBiome biome, double height) {
        return height + (biome.get(Dune.class) * biome.get(Altitude.class));
    }

    @Override
    public double getWeight(RetinaBiome biome) {
        return biome.get(Arid.class);
    }
}
