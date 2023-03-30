package com.volmit.retina.compiler;

import com.volmit.retina.generator.RetinaWorld;

import java.io.File;

public class RetinaCompiler {
    private final File output;
    private final RetinaWorld world;

    public RetinaCompiler(File output, RetinaWorld world) {
        this.output = output;
        this.world = world;
    }

    public void compileNoiseGenerators()
    {

    }
}
