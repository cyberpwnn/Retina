package com.volmit.retina.generator.mutator;

import com.volmit.retina.generator.RetinaBiome;
import com.volmit.retina.generator.RetinaWorldObject;

public interface RetinaHeightMutator extends RetinaMutator {
    double mutateHeight(RetinaBiome biome, double height);
}
