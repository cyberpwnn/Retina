package com.volmit.retina.content.properties;

import com.volmit.retina.content.tags.TagAge;
import com.volmit.retina.content.tags.TagAltitude;
import com.volmit.retina.content.tags.TagTemperature;
import com.volmit.retina.generator.RetinaWorld;
import com.volmit.retina.generator.property.TargetProperty;
import com.volmit.retina.generator.tag.TagTarget;

public class Valley extends TargetProperty {
    public Valley(RetinaWorld world) {
        super(world, "valley", new TagTarget()
                .target(TagAltitude.class, 0.5, 0.8)
                .target(TagAge.class, 1, 0.2)
        );
    }
}
