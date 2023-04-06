package com.volmit.retina.content.tags;

import com.volmit.retina.generator.RetinaWorld;
import com.volmit.retina.generator.tag.RTag;
import com.volmit.retina.generator.tag.TagTarget;

public class Temperature extends RTag {
    public Temperature(RetinaWorld world) {
        super(world, "temperature", new TagTarget()
            .target(BaseTemperature.class, 1,0.75)
            .target(Altitude.class, 0,1)
            .targetExtremes(Humidity.class, 0.08)
            .compile()
        );
    }
}
