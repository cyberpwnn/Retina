package com.volmit.retina.content.mutators.noise;

import art.arcane.source.NoisePlane;
import art.arcane.source.util.NoisePreset;
import com.volmit.retina.content.tags.TagAltitude;
import com.volmit.retina.content.tags.TagHilly;
import com.volmit.retina.generator.RetinaBiome;
import com.volmit.retina.generator.RetinaWorld;
import com.volmit.retina.generator.mutator.RetinaHeightMutator;

public class HillMutator implements RetinaHeightMutator {
    private final NoisePlane plane;

    public HillMutator(RetinaWorld world) {
        plane = NoisePreset.DROOPY.create(world.getSeeder().next())
            .octave(3, 1.25)
            .scale(0.1)
            .fit(0, 0.15);
    }

    @Override
    public String getKey() {
        return "hill-mutator";
    }

    @Override
    public double mutateHeight(RetinaBiome biome, double height) {
        return height + plane.noise(biome.getX(), biome.getZ());
    }

    @Override
    public double getWeight(RetinaBiome biome) {
        return biome.get(TagHilly.class);
    }
}
