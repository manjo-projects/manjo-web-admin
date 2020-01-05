package org.papaja.adminfly.module.psy.tests.MMPI.converter;

import org.papaja.adminfly.module.psy.tests.MMPI.PointsTRateConverterInterface;
import org.papaja.adminfly.module.psy.tests.MMPI.Scale;
import org.papaja.adminfly.module.psy.tests.payload.MapPayload;

import java.util.HashMap;
import java.util.Map;

import static org.papaja.adminfly.module.psy.tests.MMPI.Scale.*;

public class PointsTRateQ71Converter implements PointsTRateConverterInterface {

    private static final Map<Scale, float[]> MAP = new HashMap<>() {{
        put(SCALE_L, new float[]{38f, 46f, 55f, 62f, 70f, 79f});
        put(SCALE_F, new float[]{35f, 40f, 46f, 50f, 55f, 60f, 65f, 70f, 75f, 80f, 85f, 90f, 95f});
        put(SCALE_K, new float[]{28f, 31f, 34f, 37f, 40f, 42f, 45f, 48f, 51f, 54f, 56f, 59f, 62f, 65f, 67f, 70f, 73f});
        put(SCALE_1, new float[]{26f, 28f, 32f, 35f, 38f, 42f, 45f, 48f, 52f, 55f, 58f, 61f, 65f, 68f, 71f, 75f, 78f, 81f, 84f, 87f, 91f, 94f, 97f, 101f, 104f, 107f, 110f});
        put(SCALE_2, new float[]{24f, 28f, 31f, 35f, 39f, 42f, 46f, 50f, 54f, 57f, 61f, 65f, 70f, 72f, 76f, 80f, 84f, 87f, 91f, 95f, 100f, 103f, 107f});
        put(SCALE_3, new float[]{20f, 20f, 21f, 25f, 28f, 32f, 36f, 40f, 44f, 47f, 51f, 55f, 59f, 62f, 66f, 70f, 74f, 77f, 81f, 84f, 88f, 92f, 96f, 100f, 103f, 107f, 111f});
        put(SCALE_4, new float[]{19f, 19f, 19f, 19f, 19f, 20f, 26f, 35f, 40f, 44f, 49f, 53f, 58f, 63f, 68f, 72f, 77f, 82f, 86f, 92f, 96f, 101f, 106f, 111f});
        put(SCALE_6, new float[]{26f, 32f, 38f, 43f, 50f, 55f, 61f, 66f, 72f, 78f, 84f, 89f, 95f, 101f, 107f});
        put(SCALE_7, new float[]{20f, 20f, 20f, 20f, 21f, 21f, 21f, 22f, 26f, 31f, 35f, 39f, 43f, 47f, 51f, 56f, 60f, 64f, 69f, 73f, 77f, 81f, 85f, 90f, 94f, 98f, 102f, 107f});
        put(SCALE_8, new float[]{18f, 19f, 20f, 21f, 22f, 23f, 24f, 27f, 31f, 35f, 38f, 42f, 46f, 49f, 52f, 56f, 60f, 63f, 67f, 70f, 74f, 77f, 81f, 84f, 88f, 91f, 95f, 98f, 102f, 105f, 110f});
        put(SCALE_9, new float[]{20f, 22f, 24f, 30f, 35f, 40f, 46f, 51f, 57f, 62f, 68f, 74f, 79f, 85f, 90f, 96f, 101f, 107f});
    }};

    @Override
    public Map<Scale, Float> convert(MapPayload<Scale, Integer> payload) {
        Map<Scale, Float> rates = new HashMap<>();

        payload.getValue()
                .forEach((scale, point) -> rates.put(scale, MAP.get(scale)[point]));

        return rates;
    }

}
