package com.volmit.retina.content.properties;

import com.volmit.retina.content.tags.TagAge;
import com.volmit.retina.content.tags.TagAltitude;
import com.volmit.retina.content.tags.TagHumidity;
import com.volmit.retina.content.tags.TagTemperature;
import com.volmit.retina.generator.RetinaWorld;
import com.volmit.retina.generator.property.TargetProperty;
import com.volmit.retina.generator.tag.TagTarget;

public class Wetland extends TargetProperty {
    public Wetland(RetinaWorld world) {
        super(world, "wetland", new TagTarget()
                .target(TagHumidity.class, 1, 0.8)
                .target(TagTemperature.class, 0.7, 0.5)
                .target(TagAltitude.class, 0.5, 0.15)
        );
    }
}
