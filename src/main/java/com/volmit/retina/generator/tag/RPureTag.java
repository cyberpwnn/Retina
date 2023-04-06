package com.volmit.retina.generator.tag;

import com.volmit.retina.generator.RetinaWorld;

public abstract class RPureTag implements RetinaTag {
    private final String key;
    private final RetinaWorld world;

    public RPureTag(RetinaWorld world, String key) {
        this.key = key;
        this.world = world;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public RetinaWorld getWorld() {
        return world;
    }
}
