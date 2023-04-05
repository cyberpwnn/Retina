package com.volmit.retina.generator;

import art.arcane.curse.Curse;
import art.arcane.multiburst.BurstExecutor;
import art.arcane.multiburst.MultiBurst;
import art.arcane.source.NoisePlane;
import art.arcane.source.util.NoisePreset;
import com.volmit.retina.generator.block.B;
import com.volmit.retina.generator.mutator.RetinaBlockPaletteMutator;
import com.volmit.retina.generator.mutator.RetinaHeightMutator;
import com.volmit.retina.generator.object.RetinaObject;
import com.volmit.retina.generator.property.RetinaProperty;
import com.volmit.retina.generator.tag.RetinaTag;
import com.volmit.retina.noise.CompilableNoisePlane;
import com.volmit.retina.util.RetinaRegistry;
import lombok.Data;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.ThrownExpBottle;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.generator.WorldInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class RetinaWorld {
    public static RetinaWorld debugLast;
    private static final BlockData STONE = B.block("stone");
    private static final BlockData ERROR = B.block("lava");
    private final MultiBurst burst;
    private final Seeder seeder;
    private final double scale;
    private RetinaRegistry<RetinaTag> tags;
    private RetinaRegistry<RetinaObject> objects;
    private RetinaRegistry<RetinaProperty> properties;
    private RetinaRegistry<RetinaHeightMutator> heightMutators;
    private RetinaRegistry<RetinaBlockPaletteMutator> blockPaletteMutators;
    private NoisePlane noise;
    private NoisePlane white;
    private WorldInfo worldInfo;

    public RetinaWorld(WorldInfo info, double scale) {
        this.worldInfo = info;
        debugLast = this;
        long seed = info.getSeed();
        seeder = new Seeder(seed);
        this.scale = scale;
        burst = new MultiBurst("Retina", Thread.MAX_PRIORITY);
        tags = new RetinaRegistry<>(this, RetinaTag.class, "tags");
        objects = new RetinaRegistry<>(this, RetinaObject.class, "objects");
        properties = new RetinaRegistry<>(this, RetinaProperty.class, "properties");
        heightMutators = new RetinaRegistry<>(this, RetinaHeightMutator.class, "mutators");
        blockPaletteMutators = new RetinaRegistry<>(this, RetinaBlockPaletteMutator.class, "mutators");
        white = NoisePreset.NATURAL.create(getSeeder().next()).scale(1.5);
        noise = new NoisePlane() {
            @Override
            public double noise(double v, double v1, double v2) {
                return 0.5;
            }

            @Override
            public double noise(double v, double v1) {
                return 0.5;
            }

            @Override
            public double noise(double v) {
                return 0.5;
            }

            @Override
            public double getMaxOutput() {
                return 1;
            }

            @Override
            public double getMinOutput() {
                return 0;
            }
        };
    }

    public RetinaBiome getBiome(int x, int z) {
        List<RetinaTag> t = tags.getValues();
        double[] values = new double[t.size()];

        for(int i = 0; i < t.size(); i++) {
            values[i] = t.get(i).get(x, z);
        }

        return new RetinaBiome(x, z, this, noise.noise(x, z), values);
    }

    public void generateChunk(int cx, int cz, ChunkGenerator.ChunkData c) {
        int j,k,x,z,h,s;

        RetinaBiome biome;
        List<BlockData> blockSpike;

        try {
            for(int i = 0; i < 16; i++) {
                x = (cx * 16) + i;
                for(j = 0; j < 16; j++) {
                    z = (cz * 16) + j;
                    biome = getBiome(x, z);
                    h = biome.getHeight();
                    blockSpike = biome.getBlockSpike();

                    for(k = h; k > getWorldInfo().getMinHeight(); k--) {
                        s = h - k;
                        if(s < blockSpike.size()) {
                            c.setBlock(i, k, j, blockSpike.get(s));
                        }

                        else {
                            c.setBlock(i, k, j, STONE);
                        }
                    }
                }
            }
        }

        catch(Throwable e) {
            for(int i = 0; i < 16; i++) {
                x = (cx * 16) + i;
                for(j = 0; j < 16; j++) {
                    z = (cz * 16) + j;
                    c.setBlock(i, 0, j, ERROR);
                }
            }

            e.printStackTrace();
        }
    }
}
