package org.papaja.adminfly.module.psy.tests.mmpi2.support;

import java.util.HashMap;

public class RangeGenerator {

    private static final HashMap<String, Ranges> RATE_RANGES;

    static {

        RATE_RANGES = new HashMap<String, Ranges>() {{

            put("SCALE_A_F", new Ranges() {{
                add(0f, 49f, 29);
                add(50f, 80f, 131);
            }});

            put("SCALE_1_F", new Ranges() {{
                add(24f, 35f, 6);
                add(37f, 53f, 9);
                add(55f, 56f, 1);
                add(58f, 88f, 18);
                add(91f, 92f, 1);
                add(94f, 105f, 6);
                add(106f, 111f, 6);
                add(112f, 120f, 9);
            }});

            put("SCALE_2_F", new Ranges() {{
                add(0f, 33f, 11);
                add(35f, 58f, 12);
                add(59f, 71f, 7);
                add(72f, 104f, 17);
                add(105f, 120f, 8);
            }});

            put("SCALE_3_F", new Ranges() {{
                add(0f, 24f, 4);
                add(26f, 35f, 6);
                add(37f, 54f, 13);
//                add(25f, 28f, 1);
            }});

            put("SCALE_4_F", new Ranges() {{

            }});

            put("SCALE_4_F", new Ranges() {{

            }});

            put("SCALE_4_F", new Ranges() {{

            }});

            put("SCALE_4_F", new Ranges() {{

            }});

            put("SCALE_4_F", new Ranges() {{

            }});

            put("SCALE_4_F", new Ranges() {{

            }});

            put("SCALE_0_F", new Ranges() {{
                add(0f, 24f, 1);
                add(25f, 96f, 70);
            }});

            // both similar
            put("SCALE_0_M", get("SCALE_0_F"));

        }};

    }

    public static void main(String... arguments) {
        RATE_RANGES.forEach((key, ranges) -> {
            System.out.println(key);
            for (float rate : ranges.getRates()) {
                System.out.println(rate);
            }
        });

        for (float scale_3_f : RATE_RANGES.get("SCALE_3_F").getRates()) {
            System.out.println(scale_3_f);
        }
    }

}
