package com.volmit.retina.content.properties;

import com.volmit.retina.content.tags.TagAge;
import com.volmit.retina.content.tags.TagAltitude;
import com.volmit.retina.content.tags.TagTemperature;
import com.volmit.retina.generator.RetinaWorld;
import com.volmit.retina.generator.property.TargetProperty;
import com.volmit.retina.generator.tag.TagTarget;

public class Mountain extends TargetProperty {
    public Mountain(RetinaWorld world) {
        super(world, "mountain", new TagTarget()
                .target(TagAltitude.class, 1, 0.8)
                .target(TagAge.class, 0.25, 0.2)
                .target(TagTemperature.class, 0, 0.05)
        );
    }
}
