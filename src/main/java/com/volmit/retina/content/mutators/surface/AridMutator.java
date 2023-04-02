package com.volmit.retina.content.mutators.surface;

import com.volmit.retina.content.tags.TagHumidity;
import com.volmit.retina.content.tags.TagTemperature;
import com.volmit.retina.generator.RetinaBiome;
import com.volmit.retina.generator.RetinaWorld;
import com.volmit.retina.generator.block.B;
import com.volmit.retina.generator.block.BlockList;
import com.volmit.retina.generator.mutator.RetinaBlockPaletteMutator;
import com.volmit.retina.generator.tag.TagTarget;
import org.bukkit.block.data.BlockData;

public class AridMutator implements RetinaBlockPaletteMutator {
    private static final TagTarget TARGET_ARID = new TagTarget()
        .realValues()
        .exponent(8)
        .target(TagHumidity.class, 0)
        .target(TagTemperature.class, 1);
    private static final BlockData SAND = B.block("sand");
    private static final BlockData SANDSTONE = B.block("sandstone");

    public AridMutator(RetinaWorld world) {

    }

    @Override
    public String getKey() {
        return "arid-mutator";
    }


    @Override
    public double getWeight(RetinaBiome biome) {
        return TARGET_ARID.getWeight(biome);
    }

    @Override
    public BlockList generateSurface(RetinaBiome biome) {
        return new BlockList(SAND);
    }

    @Override
    public BlockList generateDirt(RetinaBiome biome) {
        return new BlockList(SANDSTONE);
    }

    @Override
    public double getDirtHeightMultiplier(RetinaBiome biome) {
        return 1;
    }

    @Override
    public double getSurfaceHeightMultiplier(RetinaBiome biome) {
        return 1;
    }
}
