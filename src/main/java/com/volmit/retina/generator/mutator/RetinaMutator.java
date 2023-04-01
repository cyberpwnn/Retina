package com.volmit.retina.generator.mutator;

import com.volmit.retina.generator.RetinaBiome;
import com.volmit.retina.generator.RetinaWorldObject;

public interface RetinaMutator extends RetinaWorldObject {
    double getWeight(RetinaBiome biome);
}
