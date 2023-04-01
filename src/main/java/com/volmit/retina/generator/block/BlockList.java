package com.volmit.retina.generator.block;

import art.arcane.source.NoisePlane;
import lombok.Getter;
import org.bukkit.block.data.BlockData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BlockList
{
    @Getter
    private List<WeightedBlock> blocks;

    public BlockList(List<WeightedBlock> blocks) {
        this.blocks = new ArrayList<>(blocks);
    }

    public BlockList(WeightedBlock... blocks) {
        this.blocks = Arrays.asList(blocks);
    }

    public BlockList(BlockData... blocks) {
        this();
        for(BlockData i : blocks) {
            add(i);
        }
    }

    public BlockList() {
        blocks = new ArrayList<>();
    }

    public BlockList(BlockList... lists) {
        blocks = new ArrayList<>();

        for(BlockList i : lists) {
            blocks.addAll(i.getBlocks());
        }
    }

    public void add(BlockList list, double weightMultiplier) {
        for(WeightedBlock i : list.getBlocks()) {
            blocks.add(new WeightedBlock(i.getBlock(), i.getWeight() * weightMultiplier));
        }
    }

    public void add(BlockData data, double weight) {
        blocks.add(new WeightedBlock(data, weight));
    }

    public void add(BlockData data) {
        blocks.add(new WeightedBlock(data));
    }

    public void add(WeightedBlock block) {
        blocks.add(block);
    }

    public void add(BlockList list) {
        blocks.addAll(list.getBlocks());
    }
}
