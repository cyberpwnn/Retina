package com.volmit.retina.generator.property;

import art.arcane.source.NoisePlane;
import com.volmit.retina.generator.RetinaBiome;
import com.volmit.retina.generator.RetinaWorld;
import com.volmit.retina.generator.RetinaWorldObject;
import com.volmit.retina.generator.tag.TagTarget;

public interface RetinaProperty extends RetinaWorldObject {
    TagTarget getTarget();

    default double get(RetinaBiome biome) {
        return getTarget().getWeightPercent(biome);
    }

    default NoisePlane toPlane(RetinaWorld world) {
        return new NoisePlane() {
            @Override
            public double noise(double v, double v1, double v2) {
                return 0;
            }

            @Override
            public double noise(double x, double z) {
                return get(world.getBiome((int)x, (int)z));
            }
        };
    }
}
