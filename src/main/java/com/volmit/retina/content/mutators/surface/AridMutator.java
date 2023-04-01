package com.volmit.retina.content.mutators.surface;

import com.volmit.retina.content.tags.TagEroded;
import com.volmit.retina.content.tags.TagHumidity;
import com.volmit.retina.content.tags.TagTemperature;
import com.volmit.retina.generator.RetinaBiome;
import com.volmit.retina.generator.RetinaWorld;
import com.volmit.retina.generator.block.B;
import com.volmit.retina.generator.block.BlockList;
import com.volmit.retina.generator.mutator.RetinaBlockPaletteMutator;
import com.volmit.retina.generator.mutator.RetinaHeightMutator;
import org.bukkit.block.data.BlockData;

public class AridMutator implements RetinaBlockPaletteMutator {
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
        double h = biome.get(TagHumidity.class)/2;
        double t = biome.get(TagTemperature.class);
        double v = Math.pow(t * (1 - h), 8);
        return v * 100;
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
