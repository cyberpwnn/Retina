package com.volmit.retina.generator;

import art.arcane.curse.Curse;
import art.arcane.multiburst.BurstExecutor;
import art.arcane.multiburst.MultiBurst;
import com.volmit.retina.generator.biome.RetinaBiome;
import com.volmit.retina.generator.object.RetinaObject;
import com.volmit.retina.generator.property.RetinaProperty;
import com.volmit.retina.noise.CompilableNoisePlane;

import java.util.ArrayList;
import java.util.List;

public class RetinaWorld {
    private final MultiBurst burst;
    private List<RetinaProperty> properties;
    private List<RetinaBiome> biomes;
    private List<RetinaObject> objects;

    public RetinaWorld(long seed) {
        Seeder s = new Seeder(seed);
        burst = new MultiBurst("Retina", Thread.MAX_PRIORITY);
        Class<?> t = getClass();
        String c = "com.volmit.retina.content.";
        properties = Curse.implementedInPackage(t, RetinaProperty.class, c + "property")
                .map(i -> (RetinaProperty)i.construct(s.next()).instance()).toList();
        biomes = Curse.implementedInPackage(t, RetinaBiome.class, c + "biome")
                .map(i -> (RetinaBiome)i.construct(s.next()).instance()).toList();
        objects = Curse.implementedInPackage(t, RetinaObject.class, c + "object")
                .map(i -> (RetinaObject)i.construct(s.next()).instance()).toList();

        List<RetinaWorldObject> worldObjects = new ArrayList<>();
        worldObjects.addAll(properties);
        worldObjects.addAll(biomes);
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
