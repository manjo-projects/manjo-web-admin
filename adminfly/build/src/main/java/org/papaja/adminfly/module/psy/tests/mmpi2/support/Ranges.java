package org.papaja.adminfly.module.psy.tests.mmpi2.support;

import org.papaja.tuple.Triplet;

import java.util.ArrayList;
import java.util.List;

public class Ranges {

    private List<Range> ranges = new ArrayList<>();

    public void add(float a, float b, int count) {
        ranges.add(new Range(a, b, count));
    }

    public float[] getRates() {
        float[] rates   = new float[ranges.stream().mapToInt(Range::getC).sum()];
        int[]   counter = new int[]{0};

        ranges.forEach(range -> {
            float min = range.getA(), max = (range.getB() - min) / (range.getC() - 1);
            int   i   = 0, j = range.getC();

            do {
                rates[counter[0]++] = round(min);
                min += max;
            } while (++i < j);
        });

        return rates;
    }

    private float round(float value) {
        return Math.round(value * 100f) / 100f;
    }

    class Range extends Triplet<Float, Float, Integer> {
        public Range(Float a, Float b, Integer count) {
            super(a, b, count);
        }
    }

}
