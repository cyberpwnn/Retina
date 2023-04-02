package com.volmit.retina.content.properties;

import com.volmit.retina.content.tags.TagAltitude;
import com.volmit.retina.content.tags.TagHumidity;
import com.volmit.retina.content.tags.TagTemperature;
import com.volmit.retina.generator.RetinaWorld;
import com.volmit.retina.generator.property.TargetProperty;
import com.volmit.retina.generator.tag.TagTarget;

public class Temperature extends TargetProperty {
    public Temperature(RetinaWorld world) {
        super(world, "temperature", new TagTarget()
                .target(TagTemperature.class, 1, 1)
                .target(TagHumidity.class, 1, 0.05)
                .target(TagHumidity.class, 0, 0.05)
                .target(TagAltitude.class, 0, 0.5)
        );
    }
}
