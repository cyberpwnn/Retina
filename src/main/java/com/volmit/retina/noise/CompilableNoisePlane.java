package com.volmit.retina.noise;

import art.arcane.source.NoisePlane;

public interface CompilableNoisePlane
{
    public String getKey();

    public NoisePlane getNoisePlane();

    public NoisePlane getRealNoisePlane();

    void compile();
}
