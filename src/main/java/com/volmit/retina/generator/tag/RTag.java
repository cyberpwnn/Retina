package com.volmit.retina.generator.tag;

import com.volmit.retina.generator.RetinaWorld;

public class RTag implements RetinaTagTarget {
    private final TagTarget target;
    private final String key;
    private final RetinaWorld world;

    public RTag(RetinaWorld world, String key, TagTarget target) {
        this.key = key;
        this.world = world;
        this.target = target;
    }
//
    @Override
    public String getKey() {
        return key;
    }

    @Override
    public TagTarget getTarget() {
        return target;
    }

    @Override
    public RetinaWorld getWorld() {
        return world;
    }
}
