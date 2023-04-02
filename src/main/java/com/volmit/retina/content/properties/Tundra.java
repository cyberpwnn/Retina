package com.volmit.retina.content.properties;

import com.volmit.retina.content.tags.TagAge;
import com.volmit.retina.content.tags.TagAltitude;
import com.volmit.retina.content.tags.TagHumidity;
import com.volmit.retina.content.tags.TagTemperature;
import com.volmit.retina.generator.RetinaWorld;
import com.volmit.retina.generator.property.TargetProperty;
import com.volmit.retina.generator.tag.TagTarget;

public class Tundra extends TargetProperty {
    public Tundra(RetinaWorld world) {
        super(world, "tundra", new TagTarget()
                .target(TagTemperature.class, 0.25, 0.35)
                .target(TagHumidity.class, 0, 0.3)
                .target(TagAltitude.class, 0.6, 0.2)
                .target(TagAge.class, 0.7, 0.1)
        );
    }
}
