package com.volmit.retina.generator.tag;

import art.arcane.source.NoisePlane;
import art.arcane.source.interpolator.Interpolator;
import com.volmit.retina.generator.RetinaBiome;
import com.volmit.retina.generator.RetinaWorldObject;

public interface RetinaTag extends RetinaWorldObject {
    double get(int x, int z);

    default double real(int x, int z) {
        return real(get(x, z));
    }

    double maxValue();

    double minValue();

    default double get(double realValue) {
        return Interpolator.rangeScale(0, 1, minValue(), maxValue(), realValue);
    }

    default double real(double percent) {
        return Interpolator.lerp(minValue(), maxValue(), percent);
    }

    default NoisePlane toPlane() {
       return new NoisePlane() {
            @Override
            public double noise(double v, double v1, double v2) {
                return 0;
            }

            @Override
            public double noise(double x, double z) {
                return get((int)x, (int)z);
            }
        };
    }
}
