package com.volmit.retina.content.tags;

import com.volmit.retina.generator.RetinaWorld;
import com.volmit.retina.generator.tag.RTag;
import com.volmit.retina.generator.tag.TagTarget;

public class Lush extends RTag {
    public Lush(RetinaWorld world) {
        super(world, "lush", new TagTarget()
            .target(Temperature.class, 1,0.6)
            .target(Humidity.class, 1,0.4)
            .exponent(2.5)
            .compile()
        );
    }
}
