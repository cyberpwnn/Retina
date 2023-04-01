package com.volmit.retina.content.mutators.noise;

import art.arcane.source.NoisePlane;
import art.arcane.source.interpolator.Interpolator;
import art.arcane.source.util.NoisePreset;
import com.volmit.retina.content.tags.TagEroded;
import com.volmit.retina.content.tags.TagHilly;
import com.volmit.retina.generator.RetinaBiome;
import com.volmit.retina.generator.RetinaWorld;
import com.volmit.retina.generator.mutator.RetinaHeightMutator;

public class ErodingMutator implements RetinaHeightMutator {
    public ErodingMutator(RetinaWorld world) {

    }

    @Override
    public String getKey() {
        return "eroding-mutator";
    }

    @Override
    public double mutateHeight(RetinaBiome biome, double height) {
        return 0.53;
    }

    @Override
    public double getWeight(RetinaBiome biome) {
        return biome.get(TagEroded.class) * 0.65;
    }
}
