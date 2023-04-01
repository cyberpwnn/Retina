package com.volmit.retina.generator;

import art.arcane.source.interpolator.Interpolator;
import com.volmit.retina.generator.block.B;
import com.volmit.retina.generator.block.BlockList;
import com.volmit.retina.generator.mutator.RetinaBlockPaletteMutator;
import com.volmit.retina.generator.mutator.RetinaHeightMutator;
import com.volmit.retina.generator.tag.RetinaTag;
import lombok.Data;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class RetinaBiome {
    private final int x;
    private final int z;
    private final RetinaWorld world;
    private final double noise;
    private final int height;
    private final double[] values;
    private final double meter;
    private final List<BlockData> blockSpike;
    private static final BlockData DIRT = B.block("dirt");
    private static final BlockData GRASS = B.block("grass_block");

    public RetinaBiome(int x, int z, RetinaWorld world, double noise, double[] values) {
        this.x = x;
        this.z = z;
        this.world = world;
        this.values = values;
        this.noise = noise;
        this.height = calcHeight();
        this.meter = 1D / (double)(world.getWorldInfo().getMaxHeight() - world.getWorldInfo().getMinHeight());
        this.blockSpike = calcBlockSpike();
    }

    private List<BlockData> calcBlockSpike() {
        double sh = 1;
        double dh = (noise * 3) + world.getWhite().noise(x, z);
        double w;
        List<BlockData> blocks = new ArrayList<>();

        for(RetinaBlockPaletteMutator i : world.getBlockPaletteMutators().getValues()) {
            w = i.getWeight(this);

            if(w < meter) {
                continue;
            }

            sh = Interpolator.lerp(sh, i.getSurfaceHeightMultiplier(this), w);
            dh = Interpolator.lerp(dh, i.getDirtHeightMultiplier(this), w);
        }

        sh = Math.max(0, Math.min(sh, ((double) height /2) + 1));
        dh = Math.max(0, Math.min(dh, ((double) height /2) + 1));
        BlockList surface = new BlockList();
        BlockList dirt = new BlockList();
        surface.add(GRASS, 1);
        dirt.add(DIRT, 1);

        for(RetinaBlockPaletteMutator i : world.getBlockPaletteMutators().getValues()) {
            w = i.getWeight(this);

            if(w < meter) {
                continue;
            }

            surface.add(i.generateSurface(this), w);
            dirt.add(i.generateDirt(this), w);
        }

        for(int i = 0; i < sh; i++) {
            blocks.add(world.getWhite().pickWeighted(x, z, surface.getBlocks()).getBlock());
        }

        for(int i = 0; i < dh; i++) {
            blocks.add(world.getWhite().pickWeighted(x, z, dirt.getBlocks()).getBlock());
        }

        return blocks;
    }

    private int calcHeight() {
        double h = noise;
        double w;

        for(RetinaHeightMutator i : world.getHeightMutators().getValues()) {
            w = i.getWeight(this);

            if(w < meter) {
                continue;
            }

            h = Interpolator.lerp(h, i.mutateHeight(this, h), w);
        }

        h = Interpolator.lerp(world.getWorldInfo().getMinHeight(), world.getWorldInfo().getMaxHeight(), h);
        return Math.max(world.getWorldInfo().getMinHeight(), Math.min((int) Math.round(h), world.getWorldInfo().getMaxHeight()));
    }

    public <T extends RetinaTag> T getTag(Class<? extends T> tag) {
        return world.getTags().get(tag);
    }

    public double get(Class<? extends RetinaTag> tag) {
        return values[world.getTags().getIndex(tag)];
    }

    public double getReal(Class<? extends RetinaTag> tag) {
        return getTag(tag).real(get(tag));
    }
}
