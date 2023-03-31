package com.volmit.retina.generator;

import art.arcane.curse.Curse;
import art.arcane.multiburst.BurstExecutor;
import art.arcane.multiburst.MultiBurst;
import com.volmit.retina.generator.object.RetinaObject;
import com.volmit.retina.generator.tag.RetinaTag;
import com.volmit.retina.noise.CompilableNoisePlane;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class RetinaWorld {
    private final MultiBurst burst;
    private final Seeder seeder;
    private final double scale;
    private List<RetinaTag> properties;
    private List<RetinaObject> objects;

    public RetinaWorld(long seed, double scale) {
        seeder = new Seeder(seed);
        this.scale = scale;
        burst = new MultiBurst("Retina", Thread.MAX_PRIORITY);
        Class<?> t = getClass();
        String c = "com.volmit.retina.content.";
        properties = Curse.implementedInPackage(t, RetinaTag.class, c + "property")
                .map(i -> (RetinaTag)i.construct(seeder.next()).instance()).toList();
        objects = Curse.implementedInPackage(t, RetinaObject.class, c + "object")
                .map(i -> (RetinaObject)i.construct(seeder.next()).instance()).toList();

        List<RetinaWorldObject> worldObjects = new ArrayList<>();
        worldObjects.addAll(properties);
        worldObjects.addAll(objects);
        List<CompilableNoisePlane> noisePlanes = new ArrayList<>();

        for(RetinaWorldObject i : worldObjects) {
            noisePlanes.addAll(i.getCompilableNoisePlanes());
        }

        BurstExecutor e = burst.burst(noisePlanes.size());

        for(CompilableNoisePlane i : noisePlanes) {
            e.queue(i::compile);
        }
    }
}
