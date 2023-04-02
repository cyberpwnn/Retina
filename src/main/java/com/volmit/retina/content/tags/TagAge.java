package com.volmit.retina.content.tags;

import art.arcane.source.NoisePlane;
import art.arcane.source.util.NoisePreset;
import com.volmit.retina.generator.RetinaWorld;
import com.volmit.retina.generator.tag.RetinaTag;

public class TagAge implements RetinaTag {
    private final NoisePlane noise;

    public TagAge(RetinaWorld world) {
        this.noise = NoisePreset.SIMPLEX.create(world.getSeeder().next())
            .fit(0, 1)
            .exponent(1.35)
            .scale(0.02);
    }

    @Override
    public String getKey() {
        return "age";
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
