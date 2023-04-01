package com.volmit.retina.content.tags;

import art.arcane.source.NoisePlane;
import art.arcane.source.util.NoisePreset;
import com.volmit.retina.generator.RetinaWorld;
import com.volmit.retina.generator.Seeder;
import com.volmit.retina.generator.tag.RetinaTag;

public class TagTemperature implements RetinaTag {
    private final NoisePlane noise;

    public TagTemperature(RetinaWorld world) {
        this.noise = NoisePreset.SIMPLEX.create(world.getSeeder().next())
            .scale(0.01)
            .fit(0, 1);
    }//

    @Override
    public String getKey() {
        return "temperature";
    }

    @Override
    public double get(int x, int z) {
        return noise.noise(x, z);
    }

    @Override
    public double maxValue() {
        return 120;
    }

    @Override
    public double minValue() {
        return -40;
    }
}
