package com.volmit.retina.content.tags;

import art.arcane.source.NoisePlane;
import art.arcane.source.util.NoisePreset;
import com.volmit.retina.generator.RetinaBiome;
import com.volmit.retina.generator.RetinaWorld;
import com.volmit.retina.generator.tag.RPureTag;

public class Altitude extends RPureTag {
    private final NoisePlane noise;

    public Altitude(RetinaWorld world) {
        super(world, "altitude");
        this.noise = NoisePreset.NATURAL.create(world.getSeeder().next())
            .scale(0.01).fit(0, 1).exponent(3.5);
    }

    @Override
    public double get(RetinaBiome biome) {
        return noise.noise(biome.getX(), biome.getZ());
    }
}
