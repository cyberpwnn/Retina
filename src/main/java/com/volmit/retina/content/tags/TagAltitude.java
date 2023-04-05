package com.volmit.retina.content.tags;

import art.arcane.source.NoisePlane;
import art.arcane.source.util.NoisePreset;
import com.volmit.retina.generator.RetinaWorld;
import com.volmit.retina.generator.tag.RetinaTag;

public class TagAltitude implements RetinaTag {
    private final NoisePlane noise;

    public TagAltitude(RetinaWorld world) {
        this.noise = NoisePreset.NATURAL.create(world.getSeeder().next())
            .octave(4, 1.15)
            .scale(0.02)
            .cachedMirror(1024)
            .fit(0, 1)
            .stretch(0.55, 0.8)
            .fit(0, 1);
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
