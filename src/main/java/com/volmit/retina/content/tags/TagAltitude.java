package com.volmit.retina.content.tags;

import art.arcane.source.NoisePlane;
import art.arcane.source.util.NoisePreset;
import com.volmit.retina.generator.RetinaWorld;
import com.volmit.retina.generator.tag.RetinaTag;

public class TagAltitude implements RetinaTag {
    private final NoisePlane noise;

    public TagAltitude(RetinaWorld world) {
        this.noise = NoisePreset.NATURAL.create(world.getSeeder().next())
            .octave(5, 1.25)
            .scale(0.002)
            .fit(0, 1); //
    }

    @Override
    public String getKey() {
        return "altitude";
    }

    @Override
    public double get(int x, int z) {
        return noise.noise(x, z);
    }

    @Override
    public double maxValue() {
        return 1;
    }

    @Override
    public double minValue() {
        return 0;
    }
}
