package com.volmit.retina.content.mutators.noise;

import art.arcane.source.NoisePlane;
import art.arcane.source.util.NoisePreset;
import com.volmit.retina.content.tags.Altitude;
import com.volmit.retina.generator.RetinaBiome;
import com.volmit.retina.generator.RetinaWorld;
import com.volmit.retina.generator.mutator.RetinaHeightMutator;

public class AltitudeModulator implements RetinaHeightMutator {
    private final NoisePlane height;

    public AltitudeModulator(RetinaWorld world)
    {
        height = NoisePreset.NATURAL.create(world.getSeeder().next())
            .scale(0.08).fit(0, 1);
    }

    @Override
    public String getKey() {
        return "altitude-modulator";
    }

    @Override
    public double mutateHeight(RetinaBiome biome, double height) {
        return (height * 0.5) + (this.height.noise(biome.getX(), biome.getZ()) * 0.5);
    }

    @Override
    public double getWeight(RetinaBiome biome) {
        return biome.get(Altitude.class);
    }
}
