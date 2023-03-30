package com.volmit.retina.generator.block;

import art.arcane.source.NoisePlane;
import org.bukkit.block.data.BlockData;

import java.util.Random;

public class SimpleBlockList {
    private BlockData[] blocks;

    public SimpleBlockList(BlockData... blocks) {
        this.blocks = blocks;
    }

    public BlockData get(int i) {
        if(i < 0 || i >= blocks.length) {
            return blocks[i%blocks.length];
        }

        return blocks[i];
    }

    public BlockData get(NoisePlane d, int x, int z) {
        return d.pickArray(x, z, blocks);
    }

    public BlockData get(Random random) {
        return get(random.nextInt(blocks.length));
    }
}
