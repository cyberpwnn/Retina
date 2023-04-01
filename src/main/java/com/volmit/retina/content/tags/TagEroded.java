package com.volmit.retina.content.tags;

import art.arcane.source.NoisePlane;
import art.arcane.source.util.NoisePreset;
import com.volmit.retina.generator.RetinaWorld;
import com.volmit.retina.generator.tag.RetinaTag;

public class TagEroded implements RetinaTag {
    private final NoisePlane noise;

    public TagEroded(RetinaWorld world) {
        this.noise = NoisePreset.SIMPLEX.create(world.getSeeder().next())
            .fit(0, 1)
            .exponent(4.5)
            .scale(0.007);
    }

    @Override
    public String getKey() { //
        return "eroded";
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
