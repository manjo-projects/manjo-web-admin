package org.papaja.adminfly.module.psy.tests.MMPI.Q71;

import org.papaja.adminfly.module.psy.tests.MMPI.AbstractQuestions;
import org.papaja.adminfly.module.psy.tests.MMPI.Scale;

import static org.papaja.adminfly.module.psy.tests.MMPI.Scale.*;

public class Questions extends AbstractQuestions {

    /**
     * Q-N:
     *   0-FALSE:
     *     SCALE[]
     *   1-TRUE:
     *     SCALE[]
     */
    private static final Scale[][][] MAP = {
            {{SCALE_1, SCALE_2, SCALE_3}, {},}, // Q1
            {{SCALE_1, SCALE_3, SCALE_7}, {},}, // Q2
            {{SCALE_2, SCALE_3, SCALE_4, SCALE_7, SCALE_8}, {},}, // Q3
            {{}, {SCALE_9},}, // Q4
            {{SCALE_L}, {SCALE_6, SCALE_7, SCALE_8},}, // Q5
            {{SCALE_1, SCALE_2}, {},}, // Q6
            {{}, {SCALE_4, SCALE_8, SCALE_9},}, // Q7
            {{}, {SCALE_6, SCALE_7, SCALE_8, SCALE_9},}, // Q8
            {{}, {SCALE_F, SCALE_1, SCALE_2, SCALE_3},}, // Q9
            {{}, {SCALE_4, SCALE_6, SCALE_8},}, // Q10
            {{SCALE_L, SCALE_K, SCALE_2, SCALE_3}, {SCALE_2},}, // Q11
            {{}, {SCALE_F},}, // Q12
            {{}, {SCALE_2, SCALE_3, SCALE_4, SCALE_7, SCALE_8},}, // Q13
            {{}, {SCALE_4, SCALE_8},}, // Q14
            {{}, {SCALE_F, SCALE_4, SCALE_6, SCALE_8},}, // Q15
            {{}, {SCALE_4, SCALE_8},}, // Q16
            {{}, {SCALE_7, SCALE_8},}, // Q17
            {{}, {SCALE_1, SCALE_2, SCALE_3},}, // Q18
            {{}, {SCALE_F},}, // Q19
            {{}, {},}, // Q20
            {{}, {SCALE_9},}, // Q21
            {{SCALE_F}, {SCALE_2, SCALE_4, SCALE_7},}, // Q22
            {{SCALE_K, SCALE_3}, {},}, // Q23
            {{SCALE_L, SCALE_F}, {},}, // Q24
            {{}, {SCALE_2, SCALE_7},}, // Q25
            {{}, {SCALE_1, SCALE_3, SCALE_8},}, // Q26
            {{}, {SCALE_4, SCALE_7},}, // Q27
            {{SCALE_2, SCALE_3, SCALE_4, SCALE_6}, {},}, // Q28
            {{SCALE_3, SCALE_6}, {SCALE_9},}, // Q29
            {{}, {SCALE_F, SCALE_6, SCALE_8},}, // Q30
            {{SCALE_K, SCALE_3, SCALE_6}, {},}, // Q31
            {{}, {SCALE_1},}, // Q32
            {{SCALE_K, SCALE_3}, {},}, // Q33
            {{SCALE_K, SCALE_4}, {SCALE_9},}, // Q34
            {{SCALE_3, SCALE_4}, {},}, // Q35
            {{SCALE_K}, {SCALE_2, SCALE_7},}, // Q36
            {{SCALE_1, SCALE_2, SCALE_3}, {},}, // Q37
            {{}, {SCALE_F, SCALE_8, SCALE_9},}, // Q38
            {{}, {SCALE_6, SCALE_8, SCALE_9},}, // Q39
            {{SCALE_K, SCALE_2, SCALE_3}, {},}, // Q40
            {{SCALE_K, SCALE_3, SCALE_4}, {},}, // Q41
            {{SCALE_2, SCALE_7, SCALE_8}, {},}, // Q42
            {{SCALE_K, SCALE_3, SCALE_4, SCALE_9}, {},}, // Q43
            {{}, {SCALE_1, SCALE_2, SCALE_3, SCALE_7},}, // Q44
            {{SCALE_1, SCALE_3}, {},}, // Q45
            {{}, {SCALE_1, SCALE_3, SCALE_8},}, // Q46
            {{SCALE_L}, {},}, // Q47
            {{}, {SCALE_F},}, // Q48
            {{}, {SCALE_F},}, // Q49
            {{SCALE_3, SCALE_4}, {},}, // Q50
            {{SCALE_K}, {SCALE_7},}, // Q51
            {{}, {SCALE_4},}, // Q52
            {{SCALE_L}, {},}, // Q53
            {{}, {SCALE_9},}, // Q54
            {{}, {SCALE_1, SCALE_3},}, // Q55
            {{SCALE_K, SCALE_3}, {},}, // Q56
            {{}, {SCALE_3, SCALE_7, SCALE_8, SCALE_9},}, // Q57
            {{}, {SCALE_4},}, // Q58
            {{}, {SCALE_F},}, // Q59
            {{SCALE_2}, {SCALE_9},}, // Q60
            {{SCALE_F, SCALE_K, SCALE_2}, {},}, // Q61
            {{}, {SCALE_1, SCALE_3},}, // Q62
            {{}, {SCALE_1, SCALE_6, SCALE_8},}, // Q63
            {{}, {SCALE_F, SCALE_6, SCALE_8},}, // Q64
            {{SCALE_K, SCALE_2, SCALE_4}, {},}, // Q65
            {{}, {SCALE_6, SCALE_7, SCALE_8},}, // Q66
            {{SCALE_K, SCALE_6}, {},}, // Q67
            {{}, {SCALE_6, SCALE_7},}, // Q68
            {{SCALE_K}, {},}, // Q69
            {{SCALE_K}, {},}, // Q70
            {{}, {SCALE_F, SCALE_4},}, // Q71
    };

    @Override
    public Scale[][][] getMap() {
        return MAP;
    }

}
