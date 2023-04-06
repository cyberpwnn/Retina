package com.volmit.retina.content.mutators.surface;

import com.volmit.retina.content.tags.Arid;
import com.volmit.retina.content.tags.Lush;
import com.volmit.retina.generator.RetinaBiome;
import com.volmit.retina.generator.RetinaWorld;
import com.volmit.retina.generator.block.B;
import com.volmit.retina.generator.block.BlockList;
import com.volmit.retina.generator.block.WeightedBlock;
import com.volmit.retina.generator.mutator.RetinaBlockPaletteMutator;

public class LushSurface implements RetinaBlockPaletteMutator {
    private static final BlockList GRASS = new BlockList(new WeightedBlock(B.block("grass_block"), 10));
    private static final BlockList DIRT = new BlockList(new WeightedBlock(B.block("dirt"), 10));

    public LushSurface(RetinaWorld world)
    {

    }

    @Override
    public String getKey() {
        return "lush-surface";
    }

    @Override
    public BlockList generateSurface(RetinaBiome biome) {
        return GRASS;
    }

    @Override
    public BlockList generateDirt(RetinaBiome biome) {
        return DIRT;
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
        return biome.get(Lush.class);
    }
}
