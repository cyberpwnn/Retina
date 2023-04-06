package com.volmit.retina.content.tags;

import com.volmit.retina.generator.RetinaWorld;
import com.volmit.retina.generator.tag.RTag;
import com.volmit.retina.generator.tag.TagTarget;

public class Tundra extends RTag {
    public Tundra(RetinaWorld world) {
        super(world, "tundra", new TagTarget()
            .target(Temperature.class, 0,0.65)
            .target(Humidity.class, 0,0.35)
            .exponent(2.5)
            .compile()
        );
    }
}
