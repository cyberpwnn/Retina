package com.volmit.retina.util;

import art.arcane.curse.Curse;
import com.strobel.collections.ImmutableList;
import com.volmit.retina.Retina;
import com.volmit.retina.generator.RetinaWorld;
import com.volmit.retina.generator.RetinaWorldObject;
import com.volmit.retina.generator.tag.RetinaTag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RetinaRegistry<T extends RetinaWorldObject> {
    private final List<T> values;
    private final Map<Class<? extends T>, T> classLookup;
    private final Map<Class<? extends T>, Integer> indexLookup;

    public RetinaRegistry(RetinaWorld world, Class<T> type, String key) {
        this.values = Curse.implementedInPackage(getClass(), type, "com.volmit.retina.content." + key)
            .map(i -> (T)i.construct(world).instance()).toList();

        Map<Class<? extends T>, T> classLookup = new HashMap<>();
        for(T i : values) {
            classLookup.put((Class<? extends T>) i.getClass(), i);
        }

        this.classLookup = Map.copyOf(classLookup);

        Map<Class<? extends T>, Integer> indexLookup = new HashMap<>();
        for(int i = 0; i < values.size(); i++) {
            indexLookup.put((Class<? extends T>) values.get(i).getClass(), i);
        }

        this.indexLookup = Map.copyOf(indexLookup);
    }

    public int getIndex(Class<? extends T> clazz) {
        return indexLookup.get(clazz);
    }

    public List<T> getValues() {
        return values;
    }

    public <X extends T> X get(Class<X> clazz) {
        return (X) classLookup.get(clazz);
    }
}
