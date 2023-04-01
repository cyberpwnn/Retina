package com.volmit.retina.generator.block;

import art.arcane.source.util.Weighted;
import lombok.Data;
import org.bukkit.block.data.BlockData;

@Data
public class WeightedBlock implements Weighted {
    private final BlockData block;
    private final double weight;

    public WeightedBlock(BlockData block, double weight) {
        this.block = block;
        this.weight = weight;
    }

    public WeightedBlock(BlockData block) {
        this.block = block;
        this.weight = 1;
    }
}
