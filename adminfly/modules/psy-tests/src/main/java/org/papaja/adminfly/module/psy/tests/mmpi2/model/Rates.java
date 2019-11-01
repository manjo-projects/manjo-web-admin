package org.papaja.adminfly.module.psy.tests.mmpi2.model;

import java.util.EnumMap;
import java.util.Map;

import static org.papaja.adminfly.module.psy.tests.mmpi2.model.Sex.*;

public enum Rates {
    INSTANCE;

    /*
    * RATES[MALE|FEMALE][SCALE][RAW_POINTS] = T_POINTS_WITHOUT_K
    */
    private static final Map<Sex, EnumMap<Scale, double[]>> SEX_RATES;

    static {
        SEX_RATES = new EnumMap<>(Sex.class);

        EnumMap<Scale, double[]> M_RATES = new EnumMap<>(Scale.class);
        EnumMap<Scale, double[]> F_RATES = new EnumMap<>(Scale.class);

        SEX_RATES.put(M, M_RATES);
        SEX_RATES.put(F, F_RATES);

        F_RATES.put(Scale.SCALE_1, new double[] {
                24D, 26D, 28D, 30D, 33D, 35D, 37D, 39D,
                41D, 43D, 45D, 47D, 49D, 51D, 53D, 55D,
                56D, 58D, 60D, 62D, 64D, 66D, 68D, 70D,
                72D, 74D, 76D, 78D, 80D, 82D, 84D, 86D,
                88D, 91D, 92D, 94D, 96D, 98D, 101D, 102D,
                105D, 106D, 107D, 108D, 109D, 110D, 111D
        });
        F_RATES.put(Scale.SCALE_2, new double[] {
                28D, 29D, 30D, 31D, 32D, 33D, 35D, 37D,
                39D, 41D, 43D, 45D, 47D, 49D, 52D, 54D,
                56D, 58D, 59D, 61D, 63D, 65D, 67D, 69D,
                71D, 72D, 74D, 76D, 78D, 80D, 82D, 84D,
                86D, 88D, 90D, 92D, 94D, 96D, 98D, 100D,
                102D, 104D, 105D, 107D, 109D, 112D, 114D,
                116D
        });
        F_RATES.put(Scale.SCALE_0, new double[] {
                25.0140D, 26.0281D, 27.0422D, 28.0563D, 29.0704D,
                30.0845D, 31.0985D, 32.1126D, 33.1267D, 34.1408D,
                35.1549D, 36.1690D, 37.1830D, 38.1971D, 39.2112D,
                40.2253D, 41.2394D, 42.2535D, 43.2676D, 44.2816D,
                45.2957D, 46.3098D, 47.3239D, 48.3380D, 49.3521D,
                50.3661D, 51.3802D, 52.3943D, 53.4084D, 54.4225D,
                55.4366D, 56.4507D, 57.4647D, 58.4788D, 59.4929D,
                60.5070D, 61.5211D, 62.5352D, 63.5492D, 64.5633D,
                65.5774D, 66.5915D, 67.6056D, 68.6197D, 69.6338D,
                70.6478D, 71.6619D, 72.6760D, 73.6901D, 74.7042D,
                75.7183D, 76.7323D, 77.7464D, 78.7605D, 79.7746D,
                80.7887D, 81.8028D, 82.8169D, 83.8309D, 84.8450D,
                85.8591D, 86.8732D, 87.8873D, 88.9014D, 89.9155D,
                90.9295D, 91.9436D, 92.9577D, 93.9718D, 94.9859D,
                96D
        });

        M_RATES.put(Scale.SCALE_0, new double[] {
                25.0140D, 26.0281D, 27.0422D, 28.0563D, 29.0704D,
                30.0845D, 31.0985D, 32.1126D, 33.1267D, 34.1408D,
                35.1549D, 36.1690D, 37.1830D, 38.1971D, 39.2112D,
                40.2253D, 41.2394D, 42.2535D, 43.2676D, 44.2816D,
                45.2957D, 46.3098D, 47.3239D, 48.3380D, 49.3521D,
                50.3661D, 51.3802D, 52.3943D, 53.4084D, 54.4225D,
                55.4366D, 56.4507D, 57.4647D, 58.4788D, 59.4929D,
                60.5070D, 61.5211D, 62.5352D, 63.5492D, 64.5633D,
                65.5774D, 66.5915D, 67.6056D, 68.6197D, 69.6338D,
                70.6478D, 71.6619D, 72.6760D, 73.6901D, 74.7042D,
                75.7183D, 76.7323D, 77.7464D, 78.7605D, 79.7746D,
                80.7887D, 81.8028D, 82.8169D, 83.8309D, 84.8450D,
                85.8591D, 86.8732D, 87.8873D, 88.9014D, 89.9155D,
                90.9295D, 91.9436D, 92.9577D, 93.9718D, 94.9859D,
                96D
        });
    }

    public static Rates getInstance() {
        return INSTANCE;
    }

    public EnumMap<Scale, double[]> getRates(Sex sex) {
        return SEX_RATES.get(sex);
    }

    public double getRate(Sex sex, Scale scale, int points) {
        double[] rates = getRates(sex).get(scale);

        return rates.length < points ? 0D : rates[points];
    }

}
