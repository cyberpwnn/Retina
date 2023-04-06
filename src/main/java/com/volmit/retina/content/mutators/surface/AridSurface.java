package com.volmit.retina.content.mutators.surface;

import com.volmit.retina.content.tags.Arid;
import com.volmit.retina.generator.RetinaBiome;
import com.volmit.retina.generator.RetinaWorld;
import com.volmit.retina.generator.block.B;
import com.volmit.retina.generator.block.BlockList;
import com.volmit.retina.generator.block.WeightedBlock;
import com.volmit.retina.generator.mutator.RetinaBlockPaletteMutator;

public class AridSurface implements RetinaBlockPaletteMutator {
    private static final BlockList SAND = new BlockList(new WeightedBlock(B.block("sand"), 10));
    private static final BlockList SANDSTONE = new BlockList(new WeightedBlock(B.block("sandstone"), 10));

    public AridSurface(RetinaWorld world)
    {

    }

    @Override
    public String getKey() {
        return "arid-surface";
    }

    @Override
    public BlockList generateSurface(RetinaBiome biome) {
        return SAND;
    }

    @Override
    public BlockList generateDirt(RetinaBiome biome) {
        return SANDSTONE;
    }

    @Override
    public double getDirtHeightMultiplier(RetinaBiome biome) {
        return 1;
    }

    @Override
    public double getSurfaceHeightMultiplier(RetinaBiome biome) {
        return 1;
    }

    @Override
    public double getWeight(RetinaBiome biome) {
        return biome.get(Arid.class);
    }
}
