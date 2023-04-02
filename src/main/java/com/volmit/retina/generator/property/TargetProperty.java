package com.volmit.retina.generator.property;

import com.volmit.retina.generator.RetinaWorld;
import com.volmit.retina.generator.RetinaWorldObject;
import com.volmit.retina.generator.tag.TagTarget;
import lombok.Data;

@Data
public class TargetProperty implements RetinaProperty{
    private final RetinaWorld world;
    private final String key;
    private final TagTarget target;

    public TargetProperty(RetinaWorld world, String key, TagTarget target) {
        this.key = key;
        this.target = target;
        this.world = world;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public TagTarget getTarget() {
        return target;
    }
}
