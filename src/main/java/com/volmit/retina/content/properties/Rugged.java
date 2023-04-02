package com.volmit.retina.content.properties;

import com.volmit.retina.content.tags.TagAge;
import com.volmit.retina.content.tags.TagAltitude;
import com.volmit.retina.content.tags.TagTemperature;
import com.volmit.retina.generator.RetinaWorld;
import com.volmit.retina.generator.property.TargetProperty;
import com.volmit.retina.generator.tag.TagTarget;

public class Rugged extends TargetProperty {
    public Rugged(RetinaWorld world) {
        super(world, "rugged", new TagTarget()
                .targetExtremes(TagTemperature.class, 0.1)
                .target(TagAge.class, 0, 0.75)
                .targetExtremes(TagAltitude.class,0.35)
        );
    }
}
