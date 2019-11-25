package org.papaja.adminfly.module.psy.tests.mmpi2.model;

import java.util.EnumMap;
import java.util.Map;

import static org.papaja.adminfly.module.psy.tests.mmpi2.model.Sex.F;
import static org.papaja.adminfly.module.psy.tests.mmpi2.model.Sex.M;

public enum Rates {
    INSTANCE;

    /*
     * RATES[MALE|FEMALE][SCALE][RAW_POINTS] = T_POINTS_WITHOUT_K
     */
    private static final Map<Sex, EnumMap<Scale, Ranges>> SEX_RATES;

    static {
        SEX_RATES = new EnumMap<>(Sex.class);

        EnumMap<Scale, Ranges> M_RATES = new EnumMap<>(Scale.class);
        EnumMap<Scale, Ranges> F_RATES = new EnumMap<>(Scale.class);

        SEX_RATES.put(M, M_RATES);
        SEX_RATES.put(F, F_RATES);

        // female rates
        F_RATES.put(Scale.SCALE_0, new Ranges() {{
            add(0f, 24f, 1); add(25f, 96f, 70);
        }});

        F_RATES.put(Scale.SCALE_A, new Ranges() {{
            add(0f, 49f, 29); add(50f, 80f, 131);
        }});

        F_RATES.put(Scale.SCALE_1, new Ranges() {{
            add(24f, 35f, 6);
            add(37f, 53f, 9);
            add(55f, 56f, 1);
            add(58f, 88f, 18);
            add(91f, 92f, 1);
            add(94f, 105f, 6);
            add(106f, 111f, 6);
            add(112f, 120f, 9);
        }});

        F_RATES.put(Scale.SCALE_2, new Ranges() {{
            add(0f, 33f, 11);
            add(35f, 58f, 12);
            add(59f, 71f, 7);
            add(72f, 104f, 17);
            add(105f, 120f, 8);
        }});

        M_RATES.put(Scale.SCALE_0, F_RATES.get(Scale.SCALE_0));

        int counter = 0;

        for (float rate : F_RATES.get(Scale.SCALE_0).getRates()) {
            System.out.printf("raw:%d; t-rate: %s%n", counter++, rate);
        }

        /*F_RATES.put(Scale.SCALE_1, new float[]{
                24f, 26f, 28f, 30f, 33f, 35f, 37f, 39f,
                41f, 43f, 45f, 47f, 49f, 51f, 53f, 55f,
                56f, 58f, 60f, 62f, 64f, 66f, 68f, 70f,
                72f, 74f, 76f, 78f, 80f, 82f, 84f, 86f,
                88f, 91f, 92f, 94f, 96f, 98f, 101f, 102f,
                105f, 106f, 107f, 108f, 109f, 110f, 111f
        });
        F_RATES.put(Scale.SCALE_2, new float[]{
                26f, 26f, 26f, 26f, 26f, 26f,
                28f, 29f, 30f, 31f, 32f, 33f, 35f, 37f,
                39f, 41f, 43f, 45f, 47f, 49f, 52f, 54f,
                56f, 58f, 59f, 61f, 63f, 65f, 67f, 69f,
                71f, 72f, 74f, 76f, 78f, 80f, 82f, 84f,
                86f, 88f, 90f, 92f, 94f, 96f, 98f, 100f,
                102f, 104f, 105f, 107f, 109f, 112f, 114f,
                116f
        });
        F_RATES.put(Scale.SCALE_0, new float[]{
                25.0140f, 26.0281f, 27.0422f, 28.0563f, 29.0704f,
                30.0845f, 31.0985f, 32.1126f, 33.1267f, 34.1408f,
                35.1549f, 36.1690f, 37.1830f, 38.1971f, 39.2112f,
                40.2253f, 41.2394f, 42.2535f, 43.2676f, 44.2816f,
                45.2957f, 46.3098f, 47.3239f, 48.3380f, 49.3521f,
                50.3661f, 51.3802f, 52.3943f, 53.4084f, 54.4225f,
                55.4366f, 56.4507f, 57.4647f, 58.4788f, 59.4929f,
                60.5070f, 61.5211f, 62.5352f, 63.5492f, 64.5633f,
                65.5774f, 66.5915f, 67.6056f, 68.6197f, 69.6338f,
                70.6478f, 71.6619f, 72.6760f, 73.6901f, 74.7042f,
                75.7183f, 76.7323f, 77.7464f, 78.7605f, 79.7746f,
                80.7887f, 81.8028f, 82.8169f, 83.8309f, 84.8450f,
                85.8591f, 86.8732f, 87.8873f, 88.9014f, 89.9155f,
                90.9295f, 91.9436f, 92.9577f, 93.9718f, 94.9859f,
                96f
        });

        M_RATES.put(Scale.SCALE_0, new float[]{
                25.0140f, 26.0281f, 27.0422f, 28.0563f, 29.0704f,
                30.0845f, 31.0985f, 32.1126f, 33.1267f, 34.1408f,
                35.1549f, 36.1690f, 37.1830f, 38.1971f, 39.2112f,
                40.2253f, 41.2394f, 42.2535f, 43.2676f, 44.2816f,
                45.2957f, 46.3098f, 47.3239f, 48.3380f, 49.3521f,
                50.3661f, 51.3802f, 52.3943f, 53.4084f, 54.4225f,
                55.4366f, 56.4507f, 57.4647f, 58.4788f, 59.4929f,
                60.5070f, 61.5211f, 62.5352f, 63.5492f, 64.5633f,
                65.5774f, 66.5915f, 67.6056f, 68.6197f, 69.6338f,
                70.6478f, 71.6619f, 72.6760f, 73.6901f, 74.7042f,
                75.7183f, 76.7323f, 77.7464f, 78.7605f, 79.7746f,
                80.7887f, 81.8028f, 82.8169f, 83.8309f, 84.8450f,
                85.8591f, 86.8732f, 87.8873f, 88.9014f, 89.9155f,
                90.9295f, 91.9436f, 92.9577f, 93.9718f, 94.9859f,
                96f
        });*/
    }

    public static void main(String[] args) {
        System.out.println(INSTANCE);
    }

    public static Rates getInstance() {
        return INSTANCE;
    }

    public EnumMap<Scale, Ranges> getRates(Sex sex) {
        return SEX_RATES.get(sex);
    }

    public double getTRate(Sex sex, Scale scale, int points) {
        float[] rates = getRates(sex).get(scale).getRates();

        if (scale.hasK()) {
            points += scale.getK().calculate(rates[points]);
        }

        return rates.length < points ? 0D : rates[points];
    }

}
