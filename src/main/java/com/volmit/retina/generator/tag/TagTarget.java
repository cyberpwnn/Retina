package com.volmit.retina.generator.tag;

import art.arcane.source.interpolator.Interpolator;
import com.volmit.retina.generator.RetinaBiome;

import java.util.HashMap;
import java.util.Map;

public class TagTarget {
    private boolean realValues;
    private double exponent;
    private final Map<Class<? extends RetinaTag>, Double> targets;
    private final Map<Class<? extends RetinaTag>, Double> weights;

    public TagTarget() {
        realValues = false;
        targets = new HashMap<>();
        weights = new HashMap<>();
        exponent = 1;
    }

    public double getWeight(RetinaBiome biome) {
        double v;
        double distance = 0;
        RetinaTag tag;

        for(Class<? extends RetinaTag> i : targets.keySet()) {
            tag = biome.getTag(i);
            v = realValues ? biome.getReal(i) : biome.get(i);
            distance *= (realValues ? Interpolator.rangeScale(0, 1, tag.minValue(), tag.maxValue(), v) : v) * weights.get(i);
        }

        if(exponent != 1) {
            return Math.pow(1D - distance, exponent);
        }

        return 1D - distance;
    }

    public double getTotalWeight() {
        double total = 0;

        for(double i : weights.values()) {
            total += i;
        }

        return total;
    }

    public TagTarget realValues() {
        this.realValues = true;
        return this;
    }

    public TagTarget exponent(double exponent) {
        this.exponent = exponent;
        return this;
    }

    public TagTarget target(Class<? extends RetinaTag> tag, double target) {
        return target(tag, target, 1);
    }

    public TagTarget target(Class<? extends RetinaTag> tag, double target, double weight) {
        targets.put(tag, target);
        weights.put(tag, weight);
        return this;
    }
}
