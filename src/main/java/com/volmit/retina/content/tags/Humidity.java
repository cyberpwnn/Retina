package com.volmit.retina.content.tags;

import art.arcane.source.NoisePlane;
import art.arcane.source.util.NoisePreset;
import com.volmit.retina.generator.RetinaBiome;
import com.volmit.retina.generator.RetinaWorld;
import com.volmit.retina.generator.tag.RPureTag;

public class Humidity extends RPureTag {
    private final NoisePlane noise;

    public Humidity(RetinaWorld world) {
        super(world, "humidity");
        this.noise = NoisePreset.SIMPLEX.create(world.getSeeder().next())
            .scale(0.02).fit(0, 1);
    }

    @Override
    public double get(RetinaBiome biome) {
        return noise.noise(biome.getX(), biome.getZ());
    }
}
