package com.volmit.retina.content.properties;

import com.volmit.retina.content.tags.TagAge;
import com.volmit.retina.content.tags.TagAltitude;
import com.volmit.retina.content.tags.TagTemperature;
import com.volmit.retina.generator.RetinaWorld;
import com.volmit.retina.generator.property.TargetProperty;
import com.volmit.retina.generator.tag.TagTarget;

public class Wind extends TargetProperty {
    public Wind(RetinaWorld world) {
        super(world, "wind", new TagTarget()
                .target(TagTemperature.class, 1, 0.15)
                .target(TagAge.class, 1, 0.66)
                .target(TagAltitude.class, 1, 0.65)
                .target(TagAltitude.class, 0.5, 0.25)
        );
    }
}
