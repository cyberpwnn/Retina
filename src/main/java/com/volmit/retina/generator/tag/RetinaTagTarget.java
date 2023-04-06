package com.volmit.retina.generator.tag;

import com.volmit.retina.generator.RetinaBiome;

public interface RetinaTagTarget extends RetinaTag {
    TagTarget getTarget();

    default double get(RetinaBiome biome) {
        return getTarget().get(biome);
    }
}
