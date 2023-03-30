package com.volmit.retina.generator;

import art.arcane.curse.Curse;
import com.volmit.retina.noise.CompilableNoisePlane;

import java.util.List;
import java.util.stream.Collectors;

public interface RetinaWorldObject {
    public String getKey();

    default List<CompilableNoisePlane> getCompilableNoisePlanes() {
        return Curse.on(this).fields()
                .filter(i -> i.field().getType().equals(CompilableNoisePlane.class))
                .map(i -> (CompilableNoisePlane) i.get()).collect(Collectors.toList());
    }
}
