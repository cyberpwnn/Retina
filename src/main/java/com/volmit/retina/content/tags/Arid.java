package com.volmit.retina.content.tags;

import com.volmit.retina.generator.RetinaWorld;
import com.volmit.retina.generator.tag.RTag;
import com.volmit.retina.generator.tag.TagTarget;

public class Arid extends RTag {
    public Arid(RetinaWorld world) {
        super(world, "arid", new TagTarget()
            .target(Temperature.class, 1,0.65)
            .target(Humidity.class, 0,0.35)
            .exponent(7)
            .compile()
        );
    }
}
