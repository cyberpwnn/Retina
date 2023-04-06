package com.volmit.retina.generator.tag;

import art.arcane.source.NoisePlane;
import com.volmit.retina.generator.RetinaBiome;
import com.volmit.retina.generator.RetinaWorld;
import com.volmit.retina.generator.RetinaWorldObject;

public interface RetinaTag extends RetinaWorldObject {
    double get(RetinaBiome biome);

    RetinaWorld getWorld();

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

           public double getMaxOutput() {
               return 1.0;
           }

           public double getMinOutput() {
               return 0;
           }
        };
    }
}
