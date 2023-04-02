package com.volmit.retina.content.properties;

import com.volmit.retina.content.tags.TagAge;
import com.volmit.retina.content.tags.TagAltitude;
import com.volmit.retina.content.tags.TagHumidity;
import com.volmit.retina.content.tags.TagTemperature;
import com.volmit.retina.generator.RetinaWorld;
import com.volmit.retina.generator.property.TargetProperty;
import com.volmit.retina.generator.tag.TagTarget;

public class Arid extends TargetProperty {
    public Arid(RetinaWorld world) {
        super(world, "arid", new TagTarget()
                .target(TagTemperature.class, 1, 0.8)
                .target(TagHumidity.class, 0, 0.6)
                .target(TagAltitude.class, 0.3, 0.15)
                .target(TagAge.class, 1, 0.05)
        );
    }
}
