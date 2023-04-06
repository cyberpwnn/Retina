package com.volmit.retina.content.tags;

import art.arcane.source.NoisePlane;
import art.arcane.source.util.NoisePreset;
import com.volmit.retina.generator.RetinaBiome;
import com.volmit.retina.generator.RetinaWorld;
import com.volmit.retina.generator.tag.RPureTag;

public class BaseTemperature extends RPureTag {
    private final NoisePlane noise;

    public BaseTemperature(RetinaWorld world) {
        super(world, "base_temperature");
        this.noise = NoisePreset.SIMPLEX.create(world.getSeeder().next())
            .scale(0.01).fit(0, 1);
    }

    @Override
    public double get(RetinaBiome biome) {
        return noise.noise(biome.getX(), biome.getZ());
    }
}
