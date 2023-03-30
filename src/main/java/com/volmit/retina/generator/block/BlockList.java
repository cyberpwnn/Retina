package com.volmit.retina.generator.block;

import art.arcane.source.NoisePlane;
import org.bukkit.block.data.BlockData;

import java.util.Random;

public interface BlockList {
    BlockData get(int i);

    BlockData[] get();

    int length();

    default BlockData get(NoisePlane d, int x, int z) {
        return d.pickArray(x, z, get());
    }

    default BlockData get(Random random) {
        return get(random.nextInt(length()));
    }
}
