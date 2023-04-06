package com.volmit.retina.generator.tag;

import com.volmit.retina.generator.RetinaBiome;

import java.util.HashMap;
import java.util.Map;

public class TagTarget {
    private double totalWeight;
    private double d1totalWeight;
    private double exponent;
    private double min;
    private double max;
    private final Map<Class<? extends RetinaTag>, Double> targets;
    private final Map<Class<? extends RetinaTag>, Double> weights;

    public TagTarget() {
        min = 0;
        max = 1;
        targets = new HashMap<>();
        weights = new HashMap<>();
        exponent = 1;
    }

    public double get(RetinaBiome biome) {
        double value = 0;

        for(Map.Entry<Class<? extends RetinaTag>, Double> i : targets.entrySet()) {
            value += (1D - Math.abs(i.getValue() - biome.get(i.getKey()))) * weights.getOrDefault(i.getKey(), 1D);
        }

        value = Math.pow(value * d1totalWeight, exponent);

        if(value <= min) {
            return 0;
        }

        if(value >= max) {
            return 1;
        }

        return value;
    }

    public TagTarget compile() {
        totalWeight = getTotalWeight();
        d1totalWeight = 1D / totalWeight;
        return this;
    }

    public TagTarget min(double min) {
        this.min = min;
        return this;
    }

    public TagTarget max(double max) {
        this.max = max;
        return this;
    }

    public TagTarget clip(double min, double max)
    {
        this.min = min;
        this.max = max;
        return this;
    }

    public double getTotalWeight() {
        double total = 0;

        for(double i : weights.values()) {
            total += i;
        }

        return total;
    }

    public TagTarget exponent(double exponent) {
        this.exponent = exponent;
        return this;
    }

    public TagTarget target(Class<? extends RetinaTag> tag, double target) {
        return target(tag, target, 1);
    }

    public TagTarget targetExtremes(Class<? extends RetinaTag> tag, double weight) {
        return target(tag, 1, weight).target(tag, 0, weight);
    }

    public TagTarget target(Class<? extends RetinaTag> tag, double target, double weight) {
        targets.put(tag, target);
        weights.put(tag, weight);
        return this;
    }
}
