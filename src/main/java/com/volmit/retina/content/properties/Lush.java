package com.volmit.retina.content.properties;

import com.volmit.retina.content.tags.TagAge;
import com.volmit.retina.content.tags.TagAltitude;
import com.volmit.retina.content.tags.TagHumidity;
import com.volmit.retina.content.tags.TagTemperature;
import com.volmit.retina.generator.RetinaWorld;
import com.volmit.retina.generator.property.TargetProperty;
import com.volmit.retina.generator.tag.TagTarget;

public class Lush extends TargetProperty {
    public Lush(RetinaWorld world) {
        super(world, "lush", new TagTarget()
                .target(TagTemperature.class, 0.5, 0.35)
                .target(TagHumidity.class, 1, 0.5)
                .target(TagAltitude.class, 0.5, 0.2)
                .target(TagAge.class, 0.5, 0.1)
        );
    }
}
