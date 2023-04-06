package com.volmit.retina.content.tags;

import art.arcane.source.NoisePlane;
import art.arcane.source.util.NoisePreset;
import com.volmit.retina.generator.RetinaBiome;
import com.volmit.retina.generator.RetinaWorld;
import com.volmit.retina.generator.tag.RPureTag;

public class Dune extends RPureTag {
    private final NoisePlane noise;

    public Dune(RetinaWorld world) {
        super(world, "dunes");
        this.noise = NoisePreset.BENDPLEX.create(world.getSeeder().next())
            .scale(0.08).fit(0, 1).exponent(1.8);
    }

    @Override
    public double get(RetinaBiome biome) {
        return Math.abs(noise.noise(biome.getX(), biome.getZ()));
    }
}
