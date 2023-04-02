package com.volmit.retina.content.mutators.noise;

import com.volmit.retina.content.tags.TagAltitude;
import com.volmit.retina.generator.RetinaBiome;
import com.volmit.retina.generator.RetinaWorld;
import com.volmit.retina.generator.mutator.RetinaHeightMutator;

public class AltitudeMutator implements RetinaHeightMutator {
    public AltitudeMutator(RetinaWorld world) {

    }

    @Override
    public String getKey() {
        return "altitude-mutator";
    }

    @Override
    public double mutateHeight(RetinaBiome biome, double height) {
        return height + 0.5;
    }

    @Override
    public double getWeight(RetinaBiome biome) {
        return biome.get(TagAltitude.class);
    }
}
