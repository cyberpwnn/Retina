package com.volmit.retina.generator.mutator;

import com.volmit.retina.generator.RetinaBiome;
import com.volmit.retina.generator.RetinaWorldObject;
import com.volmit.retina.generator.block.BlockList;

public interface RetinaBlockPaletteMutator extends RetinaMutator {
    BlockList generateSurface(RetinaBiome biome);

    BlockList generateDirt(RetinaBiome biome);

    double getDirtHeightMultiplier(RetinaBiome biome);

    double getSurfaceHeightMultiplier(RetinaBiome biome);
}
