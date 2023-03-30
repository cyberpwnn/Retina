package com.volmit.retina.generator.block;

public class CachedBlockList extends SimpleBlockList
{
    public CachedBlockList(SimpleBlockList blockList)
    {
        super(blockList.get());
    }
}
