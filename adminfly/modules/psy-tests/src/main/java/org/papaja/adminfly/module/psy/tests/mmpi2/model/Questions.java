package org.papaja.adminfly.module.psy.tests.mmpi2.model;

import org.papaja.tuple.Pair;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.papaja.adminfly.module.psy.tests.mmpi2.model.Answer.TRUE;
import static org.papaja.adminfly.module.psy.tests.mmpi2.model.Scale.*;

public class Questions {

    private static final int QUESTION_START = 1;
    private static final int QUESTION_END = 566;

    public static final Questions F_QUESTIONS = new Questions() {{
        add(SCALE_L, 15, 30, 45, 75, 105, 135, 195, 225, 255, 285, 60, 90, 120, 150, 165);
        add(SCALE_F, 14, 23, 27, 31, 33, 34, 35, 40, 42, 48, 49, 50, 53, 56, 66, 85, 121, 123, 139, 146, 151, 156, 168, 184, 197, 200, 202, 205, 206, 209, 210, 211, 215, 218, 227, 245, 246, 247, 252, 256, 269, 275, 286, 291, 293, 17, 20, 54, 65, 75, 83, 112, 113, 115, 164, 169, 177, 185, 196, 199, 220, 257, 258, 272, 276);
        add(SCALE_K, 96, 30, 39, 71, 89, 124, 129, 134, 138, 142, 148, 160, 170, 171, 180, 183, 217, 234, 267, 272, 296, 316, 322, 374, 383, 397, 398, 406, 461, 502);
//        add(SCALE_1, );
//        add(SCALE_2, );
//        add(SCALE_3, );
//        add(SCALE_4, );
//        add(SCALE_5, );
//        add(SCALE_6, );
//        add(SCALE_7, );
//        add(SCALE_8, );
//        add(SCALE_9, );
//        add(SCALE_0, );
    }};

    public static final Questions M_QUESTIONS = new Questions() {{
//        add(SCALE_L, 15, 30, 45, 75, 105, 135, 195, 225, 255, 285, 60, 90, 120, 150, 165);
//        add(SCALE_F, );
//        add(SCALE_K, );
//        add(SCALE_1, );
//        add(SCALE_2, );
//        add(SCALE_3, );
//        add(SCALE_4, );
//        add(SCALE_5, );
//        add(SCALE_6, );
//        add(SCALE_7, );
//        add(SCALE_8, );
//        add(SCALE_9, );
//        add(SCALE_0, );
    }};

    private Map<Integer, Scale> questions = new TreeMap<>();

    private Questions() {
        Pair<Answer, Scale[]> pair = new Pair<>(TRUE, new Scale[]{SCALE_1, SCALE_2});


    }

    public void add(Scale scale, Integer... numbers) {
        for (Integer number : numbers) {
            questions.put(number, scale);
        }
    }

    public List<Integer> getRange() {
        return IntStream.range(QUESTION_START, QUESTION_END).boxed().collect(Collectors.toList());
    }

}
