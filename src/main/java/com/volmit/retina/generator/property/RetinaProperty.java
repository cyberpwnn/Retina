package com.volmit.retina.generator.property;

import com.volmit.retina.generator.RetinaBiome;
import com.volmit.retina.generator.RetinaWorldObject;
import com.volmit.retina.generator.tag.TagTarget;

public interface RetinaProperty extends RetinaWorldObject {
    TagTarget getTarget();

    default double get(RetinaBiome biome) {
        return getTarget().getWeightPercent(biome);
    }
}
