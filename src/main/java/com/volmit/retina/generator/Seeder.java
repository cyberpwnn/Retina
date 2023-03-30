package com.volmit.retina.generator;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public class Seeder {
    private long seed;

    public Seeder(long baseSeed)
    {
        seed = baseSeed;
        next();
    }

    public long next()
    {
        seed = (long) (new Random(seed).nextDouble() * Long.MAX_VALUE);
        return seed;
    }
}
