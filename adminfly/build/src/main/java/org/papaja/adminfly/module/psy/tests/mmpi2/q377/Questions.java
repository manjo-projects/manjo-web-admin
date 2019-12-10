package org.papaja.adminfly.module.psy.tests.mmpi2.q377;

import org.papaja.adminfly.module.psy.tests.mmpi2.AbstractQuestions;
import org.papaja.adminfly.module.psy.tests.mmpi2.Scale;

import static org.papaja.adminfly.module.psy.tests.mmpi2.Scale.*;

public class Questions extends AbstractQuestions {

    /**
     * Q-N:
     *   0-FALSE:
     *     SCALE[]
     *   1-TRUE:
     *     SCALE[]
     */
    private static final Scale[][][] MAP = {
            {{}, {SCALE_5_F, SCALE_5_F, SCALE_5_M},}, // Q1
            {{SCALE_5_F, SCALE_5_F, SCALE_5_M}, {},}, // Q2
            {{}, {SCALE_5_F, SCALE_5_F, SCALE_5_M},}, // Q3
            {{SCALE_0, SCALE_5_F, SCALE_5_F, SCALE_5_M}, {},}, // Q4
            {{}, {SCALE_6, SCALE_5_F, SCALE_5_F, SCALE_5_M},}, // Q5
            {{}, {SCALE_0},}, // Q6
            {{}, {SCALE_0},}, // Q7
            {{SCALE_0}, {SCALE_9, SCALE_4, SCALE_3, SCALE_K},}, // Q8
            {{}, {SCALE_0, SCALE_2},}, // Q9
            {{SCALE_4}, {},}, // Q10
            {{SCALE_4, SCALE_3}, {},}, // Q11
            {{SCALE_8, SCALE_6, SCALE_F}, {SCALE_4},}, // Q12
            {{SCALE_K}, {},}, // Q13
            {{}, {SCALE_3},}, // Q14
            {{}, {SCALE_3, SCALE_1},}, // Q15
            {{SCALE_3, SCALE_1}, {},}, // Q16
            {{}, {SCALE_1},}, // Q17
            {{SCALE_2}, {},}, // Q18
            {{}, {SCALE_7, SCALE_2},}, // Q19
            {{SCALE_9}, {SCALE_2},}, // Q20
            {{}, {SCALE_9, SCALE_8, SCALE_7},}, // Q21
            {{}, {SCALE_8},}, // Q22
            {{}, {SCALE_8},}, // Q23
            {{SCALE_8, SCALE_F}, {},}, // Q24
            {{}, {SCALE_F},}, // Q25
            {{}, {SCALE_F},}, // Q26
            {{}, {SCALE_F},}, // Q27
            {{}, {SCALE_6, SCALE_F},}, // Q28
            {{}, {SCALE_9},}, // Q29
            {{}, {},}, // Q30
            {{SCALE_5_F, SCALE_5_F, SCALE_5_M}, {},}, // Q31
            {{}, {SCALE_5_F, SCALE_5_F, SCALE_5_M},}, // Q32
            {{SCALE_5_F, SCALE_5_F, SCALE_5_M}, {},}, // Q33
            {{SCALE_0}, {SCALE_6, SCALE_5_F, SCALE_5_F, SCALE_5_M},}, // Q34
            {{SCALE_9, SCALE_5_F, SCALE_5_F}, {SCALE_5_M},}, // Q35
            {{SCALE_0}, {},}, // Q36
            {{SCALE_0}, {SCALE_F},}, // Q37
            {{SCALE_0}, {SCALE_9, SCALE_4, SCALE_3, SCALE_K},}, // Q38
            {{}, {SCALE_0, SCALE_7},}, // Q39
            {{}, {SCALE_4},}, // Q40
            {{SCALE_8, SCALE_7, SCALE_4, SCALE_3, SCALE_2}, {},}, // Q41
            {{}, {SCALE_8, SCALE_6, SCALE_4},}, // Q42
            {{SCALE_3, SCALE_2, SCALE_K}, {},}, // Q43
            {{SCALE_3}, {},}, // Q44
            {{}, {SCALE_3, SCALE_1},}, // Q45
            {{}, {SCALE_3, SCALE_1},}, // Q46
            {{SCALE_1}, {},}, // Q47
            {{}, {SCALE_2},}, // Q48
            {{}, {SCALE_7, SCALE_2},}, // Q49
            {{SCALE_2, SCALE_L}, {},}, // Q50
            {{}, {SCALE_9, SCALE_8, SCALE_7, SCALE_6},}, // Q51
            {{}, {SCALE_8},}, // Q52
            {{}, {SCALE_8},}, // Q53
            {{}, {SCALE_8, SCALE_F},}, // Q54
            {{}, {SCALE_F},}, // Q55
            {{}, {SCALE_F},}, // Q56
            {{SCALE_F}, {},}, // Q57
            {{SCALE_F, SCALE_L}, {},}, // Q58
            {{}, {SCALE_9},}, // Q59
            {{}, {SCALE_9},}, // Q60
            {{SCALE_5_F, SCALE_5_F, SCALE_5_M}, {},}, // Q61
            {{}, {SCALE_5_F, SCALE_5_F, SCALE_5_M},}, // Q62
            {{SCALE_5_F, SCALE_5_F, SCALE_5_M}, {},}, // Q63
            {{}, {SCALE_5_F, SCALE_5_F, SCALE_5_M},}, // Q64
            {{SCALE_5_F, SCALE_5_F, SCALE_5_M, SCALE_L}, {},}, // Q65
            {{SCALE_0}, {},}, // Q66
            {{SCALE_0}, {},}, // Q67
            {{SCALE_0, SCALE_4}, {},}, // Q68
            {{}, {SCALE_0, SCALE_7},}, // Q69
            {{}, {SCALE_4},}, // Q70
            {{SCALE_9, SCALE_4, SCALE_3}, {},}, // Q71
            {{}, {SCALE_4, SCALE_F},}, // Q72
            {{SCALE_3, SCALE_K}, {},}, // Q73
            {{SCALE_3}, {},}, // Q74
            {{SCALE_3, SCALE_2, SCALE_1}, {},}, // Q75
            {{}, {SCALE_7, SCALE_3},}, // Q76
            {{}, {SCALE_1},}, // Q77
            {{SCALE_2}, {},}, // Q78
            {{}, {SCALE_8, SCALE_7, SCALE_2},}, // Q79
            {{SCALE_9}, {SCALE_7},}, // Q80
            {{}, {SCALE_8, SCALE_7},}, // Q81
            {{}, {SCALE_8},}, // Q82
            {{}, {SCALE_8, SCALE_F},}, // Q83
            {{SCALE_8, SCALE_F}, {},}, // Q84
            {{}, {SCALE_F},}, // Q85
            {{}, {SCALE_F},}, // Q86
            {{}, {},}, // Q87
            {{}, {SCALE_6},}, // Q88
            {{}, {SCALE_9},}, // Q89
            {{SCALE_9, SCALE_L}, {},}, // Q90
            {{SCALE_5_F, SCALE_5_F, SCALE_5_M}, {},}, // Q91
            {{SCALE_5_F, SCALE_5_F, SCALE_5_M}, {},}, // Q92
            {{SCALE_5_F, SCALE_5_F}, {SCALE_5_M},}, // Q93
            {{SCALE_9, SCALE_5_F, SCALE_5_F, SCALE_5_M}, {SCALE_4, SCALE_K},}, // Q94
            {{}, {SCALE_0},}, // Q95
            {{SCALE_0}, {},}, // Q96
            {{}, {SCALE_0},}, // Q97
            {{SCALE_0, SCALE_2}, {SCALE_K},}, // Q98
            {{}, {SCALE_0, SCALE_7},}, // Q99
            {{}, {SCALE_4},}, // Q100
            {{SCALE_4, SCALE_3}, {},}, // Q101
            {{}, {SCALE_4, SCALE_F},}, // Q102
            {{SCALE_3, SCALE_K}, {},}, // Q103
            {{SCALE_3}, {},}, // Q104
            {{}, {SCALE_3, SCALE_2, SCALE_1, SCALE_F},}, // Q105
            {{}, {SCALE_9, SCALE_8, SCALE_7, SCALE_3},}, // Q106
            {{}, {SCALE_1},}, // Q107
            {{}, {SCALE_9, SCALE_2},}, // Q108
            {{}, {SCALE_8, SCALE_7, SCALE_2},}, // Q109
            {{}, {SCALE_7},}, // Q110
            {{}, {SCALE_8, SCALE_7},}, // Q111
            {{}, {SCALE_8},}, // Q112
            {{}, {SCALE_8, SCALE_6, SCALE_F},}, // Q113
            {{}, {SCALE_8, SCALE_6},}, // Q114
            {{}, {SCALE_F},}, // Q115
            {{}, {SCALE_F},}, // Q116
            {{}, {SCALE_F},}, // Q117
            {{SCALE_6}, {},}, // Q118
            {{}, {SCALE_9},}, // Q119
            {{SCALE_9, SCALE_L}, {},}, // Q120
            {{SCALE_5_F, SCALE_5_F, SCALE_5_M}, {},}, // Q121
            {{}, {SCALE_5_F, SCALE_5_F, SCALE_5_M},}, // Q122
            {{SCALE_5_F, SCALE_5_F, SCALE_5_M}, {},}, // Q123
            {{SCALE_5_F, SCALE_5_F, SCALE_5_M, SCALE_3, SCALE_2, SCALE_K}, {},}, // Q124
            {{SCALE_0}, {},}, // Q125
            {{}, {SCALE_0},}, // Q126
            {{}, {SCALE_0},}, // Q127
            {{SCALE_0}, {SCALE_K},}, // Q128
            {{}, {SCALE_0, SCALE_7},}, // Q129
            {{SCALE_4}, {},}, // Q130
            {{SCALE_4, SCALE_2, SCALE_1}, {},}, // Q131
            {{}, {SCALE_4, SCALE_F},}, // Q132
            {{SCALE_3, SCALE_K}, {},}, // Q133
            {{}, {SCALE_3},}, // Q134
            {{}, {SCALE_3, SCALE_1},}, // Q135
            {{}, {SCALE_8, SCALE_7, SCALE_3},}, // Q136
            {{SCALE_2}, {SCALE_1},}, // Q137
            {{SCALE_2}, {},}, // Q138
            {{}, {SCALE_8, SCALE_2},}, // Q139
            {{}, {SCALE_7},}, // Q140
            {{}, {SCALE_8, SCALE_7},}, // Q141
            {{}, {SCALE_8},}, // Q142
            {{}, {SCALE_8, SCALE_6, SCALE_F},}, // Q143
            {{}, {SCALE_8, SCALE_6},}, // Q144
            {{}, {SCALE_F},}, // Q145
            {{}, {SCALE_F},}, // Q146
            {{}, {SCALE_F},}, // Q147
            {{SCALE_6}, {},}, // Q148
            {{}, {SCALE_9},}, // Q149
            {{SCALE_L}, {},}, // Q150
            {{}, {SCALE_5_F, SCALE_5_F, SCALE_5_M},}, // Q151
            {{}, {SCALE_5_F, SCALE_5_F, SCALE_5_M},}, // Q152
            {{SCALE_5_F, SCALE_5_F, SCALE_5_M}, {},}, // Q153
            {{SCALE_7, SCALE_5_F, SCALE_5_F, SCALE_5_M}, {SCALE_K},}, // Q154
            {{SCALE_0}, {SCALE_3},}, // Q155
            {{SCALE_0}, {},}, // Q156
            {{SCALE_0}, {},}, // Q157
            {{SCALE_0}, {SCALE_K},}, // Q158
            {{}, {SCALE_0, SCALE_7},}, // Q159
            {{SCALE_4}, {},}, // Q160
            {{SCALE_4, SCALE_2}, {},}, // Q161
            {{}, {SCALE_6, SCALE_4},}, // Q162
            {{SCALE_3, SCALE_2, SCALE_K, SCALE_L}, {},}, // Q163
            {{SCALE_3}, {},}, // Q164
            {{}, {SCALE_3, SCALE_2, SCALE_1},}, // Q165
            {{}, {SCALE_8, SCALE_3},}, // Q166
            {{SCALE_2, SCALE_1}, {},}, // Q167
            {{}, {SCALE_2},}, // Q168
            {{}, {SCALE_8, SCALE_2},}, // Q169
            {{}, {SCALE_7},}, // Q170
            {{}, {SCALE_8, SCALE_7, SCALE_6},}, // Q171
            {{}, {SCALE_8},}, // Q172
            {{}, {SCALE_8, SCALE_F},}, // Q173
            {{}, {SCALE_9, SCALE_8},}, // Q174
            {{}, {SCALE_F},}, // Q175
            {{SCALE_F}, {},}, // Q176
            {{}, {SCALE_F},}, // Q177
            {{}, {SCALE_6},}, // Q178
            {{}, {SCALE_9},}, // Q179
            {{SCALE_L}, {},}, // Q180
            {{}, {SCALE_5_F, SCALE_5_F, SCALE_5_M},}, // Q181
            {{SCALE_5_F, SCALE_5_F, SCALE_5_M}, {},}, // Q182
            {{SCALE_5_F, SCALE_5_F, SCALE_5_M}, {},}, // Q183
            {{SCALE_5_F, SCALE_5_F, SCALE_5_M, SCALE_3}, {},}, // Q184
            {{SCALE_0}, {},}, // Q185
            {{SCALE_0}, {},}, // Q186
            {{SCALE_0}, {SCALE_4, SCALE_3},}, // Q187
            {{SCALE_0}, {SCALE_6, SCALE_K},}, // Q188
            {{SCALE_0}, {SCALE_7},}, // Q189
            {{}, {SCALE_4},}, // Q190
            {{}, {SCALE_7, SCALE_4},}, // Q191
            {{}, {SCALE_6, SCALE_4},}, // Q192
            {{SCALE_2, SCALE_K, SCALE_F}, {},}, // Q193
            {{}, {SCALE_3},}, // Q194
            {{SCALE_7, SCALE_3, SCALE_1}, {},}, // Q195
            {{SCALE_9, SCALE_3}, {SCALE_6},}, // Q196
            {{}, {SCALE_8, SCALE_1},}, // Q197
            {{SCALE_2}, {},}, // Q198
            {{SCALE_8}, {SCALE_2},}, // Q199
            {{SCALE_7}, {},}, // Q200
            {{}, {SCALE_8, SCALE_7},}, // Q201
            {{}, {SCALE_8},}, // Q202
            {{}, {SCALE_8, SCALE_6, SCALE_F},}, // Q203
            {{}, {SCALE_9, SCALE_8},}, // Q204
            {{SCALE_F}, {},}, // Q205
            {{}, {SCALE_F},}, // Q206
            {{}, {SCALE_F},}, // Q207
            {{}, {SCALE_6},}, // Q208
            {{}, {SCALE_9},}, // Q209
            {{SCALE_L}, {},}, // Q210
            {{SCALE_5_F, SCALE_5_F, SCALE_5_M}, {},}, // Q211
            {{SCALE_5_F, SCALE_5_F, SCALE_5_M}, {},}, // Q212
            {{}, {SCALE_5_F, SCALE_5_F, SCALE_5_M},}, // Q213
            {{SCALE_5_F, SCALE_5_F, SCALE_5_M}, {SCALE_3},}, // Q214
            {{SCALE_0}, {},}, // Q215
            {{SCALE_0}, {},}, // Q216
            {{SCALE_0}, {SCALE_9, SCALE_4, SCALE_K},}, // Q217
            {{SCALE_0, SCALE_3}, {SCALE_6, SCALE_K},}, // Q218
            {{}, {SCALE_0, SCALE_7},}, // Q219
            {{SCALE_4}, {},}, // Q220
            {{}, {SCALE_7, SCALE_4},}, // Q221
            {{}, {SCALE_9, SCALE_6, SCALE_4},}, // Q222
            {{SCALE_2, SCALE_K}, {},}, // Q223
            {{}, {SCALE_3},}, // Q224
            {{}, {SCALE_3, SCALE_2, SCALE_1},}, // Q225
            {{SCALE_6}, {SCALE_3},}, // Q226
            {{SCALE_2}, {},}, // Q227
            {{}, {SCALE_2},}, // Q228
            {{}, {SCALE_8, SCALE_2},}, // Q229
            {{}, {SCALE_7},}, // Q230
            {{SCALE_8, SCALE_7, SCALE_6}, {SCALE_L},}, // Q231
            {{}, {SCALE_8},}, // Q232
            {{SCALE_8, SCALE_F}, {},}, // Q233
            {{}, {SCALE_9, SCALE_8},}, // Q234
            {{SCALE_F}, {},}, // Q235
            {{}, {SCALE_F},}, // Q236
            {{}, {SCALE_F},}, // Q237
            {{SCALE_6}, {},}, // Q238
            {{}, {SCALE_9},}, // Q239
            {{SCALE_L}, {},}, // Q240
            {{SCALE_5_F, SCALE_5_F, SCALE_5_M}, {},}, // Q241
            {{}, {SCALE_5_F, SCALE_5_F, SCALE_5_M},}, // Q242
            {{}, {SCALE_0, SCALE_5_F, SCALE_5_F, SCALE_5_M},}, // Q243
            {{SCALE_5_F, SCALE_5_F, SCALE_5_M, SCALE_2}, {},}, // Q244
            {{}, {SCALE_0},}, // Q245
            {{SCALE_0}, {},}, // Q246
            {{SCALE_0}, {SCALE_8, SCALE_4},}, // Q247
            {{}, {SCALE_0, SCALE_3},}, // Q248
            {{SCALE_0, SCALE_9, SCALE_8}, {},}, // Q249
            {{}, {SCALE_4},}, // Q250
            {{}, {SCALE_7, SCALE_4},}, // Q251
            {{}, {SCALE_6, SCALE_4},}, // Q252
            {{SCALE_7, SCALE_2}, {SCALE_K},}, // Q253
            {{SCALE_3}, {SCALE_2, SCALE_1},}, // Q254
            {{}, {SCALE_3, SCALE_1},}, // Q255
            {{}, {SCALE_9, SCALE_3},}, // Q256
            {{}, {SCALE_2},}, // Q257
            {{}, {SCALE_8, SCALE_7, SCALE_2},}, // Q258
            {{}, {SCALE_6, SCALE_2},}, // Q259
            {{}, {SCALE_7},}, // Q260
            {{SCALE_7, SCALE_F}, {},}, // Q261
            {{}, {SCALE_9, SCALE_8, SCALE_6},}, // Q262
            {{SCALE_8, SCALE_F}, {},}, // Q263
            {{}, {SCALE_9, SCALE_8},}, // Q264
            {{}, {SCALE_F},}, // Q265
            {{}, {SCALE_F},}, // Q266
            {{}, {SCALE_6, SCALE_F},}, // Q267
            {{SCALE_6}, {},}, // Q268
            {{}, {SCALE_9},}, // Q269
            {{SCALE_L}, {},}, // Q270
            {{SCALE_5_F, SCALE_5_F, SCALE_5_M}, {},}, // Q271
            {{SCALE_5_F, SCALE_5_F, SCALE_5_M}, {},}, // Q272
            {{SCALE_0}, {SCALE_5_F, SCALE_5_F, SCALE_5_M},}, // Q273
            {{}, {SCALE_8, SCALE_5_F, SCALE_5_F, SCALE_5_M},}, // Q274
            {{SCALE_0}, {},}, // Q275
            {{SCALE_0}, {SCALE_9},}, // Q276
            {{SCALE_0, SCALE_4, SCALE_2, SCALE_K}, {},}, // Q277
            {{}, {SCALE_0, SCALE_3},}, // Q278
            {{}, {SCALE_0, SCALE_8},}, // Q279
            {{SCALE_4, SCALE_K}, {SCALE_3},}, // Q280
            {{}, {SCALE_9, SCALE_8, SCALE_4},}, // Q281
            {{SCALE_K}, {},}, // Q282
            {{SCALE_8, SCALE_K}, {},}, // Q283
            {{SCALE_3}, {SCALE_2, SCALE_1},}, // Q284
            {{}, {SCALE_3, SCALE_1},}, // Q285
            {{}, {SCALE_1},}, // Q286
            {{SCALE_2}, {},}, // Q287
            {{SCALE_7}, {SCALE_2},}, // Q288
            {{}, {SCALE_9, SCALE_2},}, // Q289
            {{}, {SCALE_7},}, // Q290
            {{}, {SCALE_7, SCALE_6},}, // Q291
            {{SCALE_8}, {},}, // Q292
            {{SCALE_8, SCALE_F}, {},}, // Q293
            {{}, {SCALE_F},}, // Q294
            {{}, {SCALE_F},}, // Q295
            {{SCALE_F}, {},}, // Q296
            {{}, {SCALE_6, SCALE_F},}, // Q297
            {{SCALE_9}, {SCALE_6},}, // Q298
            {{}, {SCALE_9},}, // Q299
            {{SCALE_L}, {},}, // Q300
            {{}, {SCALE_5_F, SCALE_5_F, SCALE_5_M},}, // Q301
            {{}, {SCALE_5_F, SCALE_5_F, SCALE_5_M},}, // Q302
            {{SCALE_0}, {SCALE_5_F, SCALE_5_F, SCALE_5_M},}, // Q303
            {{}, {SCALE_8, SCALE_5_F, SCALE_5_F, SCALE_5_M},}, // Q304
            {{}, {SCALE_0},}, // Q305
            {{SCALE_0}, {},}, // Q306
            {{SCALE_0}, {SCALE_4},}, // Q307
            {{}, {SCALE_0, SCALE_8, SCALE_6, SCALE_1},}, // Q308
            {{}, {SCALE_0, SCALE_8},}, // Q309
            {{SCALE_4, SCALE_K}, {},}, // Q310
            {{}, {SCALE_8, SCALE_4},}, // Q311
            {{SCALE_K}, {},}, // Q312
            {{SCALE_9, SCALE_K}, {},}, // Q313
            {{}, {SCALE_3, SCALE_1},}, // Q314
            {{}, {SCALE_7, SCALE_3, SCALE_2, SCALE_1},}, // Q315
            {{}, {SCALE_1},}, // Q316
            {{}, {SCALE_2},}, // Q317
            {{SCALE_7}, {SCALE_2},}, // Q318
            {{}, {SCALE_9, SCALE_2},}, // Q319
            {{}, {SCALE_7},}, // Q320
            {{}, {SCALE_8},}, // Q321
            {{SCALE_8}, {},}, // Q322
            {{SCALE_8, SCALE_F}, {},}, // Q323
            {{}, {SCALE_F},}, // Q324
            {{}, {SCALE_F},}, // Q325
            {{}, {SCALE_F},}, // Q326
            {{}, {SCALE_6, SCALE_F},}, // Q327
            {{}, {SCALE_9},}, // Q328
            {{}, {},}, // Q329
            {{SCALE_L}, {},}, // Q330
            {{}, {SCALE_5_F, SCALE_5_F, SCALE_5_M},}, // Q331
            {{}, {SCALE_5_F, SCALE_5_F, SCALE_5_M},}, // Q332
            {{SCALE_0, SCALE_5_F, SCALE_5_F, SCALE_5_M}, {},}, // Q333
            {{}, {SCALE_5_F, SCALE_5_F, SCALE_5_M, SCALE_F},}, // Q334
            {{SCALE_0}, {},}, // Q335
            {{SCALE_0}, {},}, // Q336
            {{}, {SCALE_0, SCALE_8, SCALE_7, SCALE_4, SCALE_3, SCALE_2},}, // Q337
            {{}, {SCALE_0, SCALE_2},}, // Q338
            {{SCALE_0}, {SCALE_9, SCALE_6},}, // Q339
            {{}, {SCALE_4, SCALE_K},}, // Q340
            {{}, {SCALE_8, SCALE_4},}, // Q341
            {{SCALE_K}, {},}, // Q342
            {{}, {SCALE_3},}, // Q343
            {{}, {SCALE_3, SCALE_1},}, // Q344
            {{}, {SCALE_8, SCALE_3, SCALE_1},}, // Q345
            {{}, {SCALE_1},}, // Q346
            {{}, {SCALE_2},}, // Q347
            {{SCALE_8, SCALE_7}, {SCALE_2},}, // Q348
            {{}, {SCALE_9, SCALE_2},}, // Q349
            {{}, {SCALE_8, SCALE_7},}, // Q350
            {{}, {SCALE_8},}, // Q351
            {{}, {SCALE_8},}, // Q352
            {{}, {SCALE_9, SCALE_8, SCALE_F},}, // Q353
            {{}, {SCALE_F},}, // Q354
            {{}, {SCALE_F},}, // Q355
            {{}, {SCALE_F},}, // Q356
            {{}, {SCALE_6, SCALE_F},}, // Q357
            {{SCALE_9}, {},}, // Q358
            {{}, {SCALE_9},}, // Q359
            {{SCALE_L}, {},}, // Q360
            {{}, {SCALE_5_F, SCALE_5_F, SCALE_5_M},}, // Q361
            {{}, {SCALE_5_F, SCALE_5_F, SCALE_5_M},}, // Q362
            {{SCALE_0, SCALE_5_F, SCALE_5_F, SCALE_5_M}, {},}, // Q363
            {{SCALE_5_F, SCALE_5_F, SCALE_5_M, SCALE_F}, {},}, // Q364
            {{}, {SCALE_0},}, // Q365
            {{}, {SCALE_0},}, // Q366
            {{}, {SCALE_0, SCALE_7, SCALE_4, SCALE_2},}, // Q367
            {{SCALE_0}, {SCALE_2},}, // Q368
            {{}, {SCALE_4},}, // Q369
            {{SCALE_6}, {SCALE_4, SCALE_3, SCALE_2},}, // Q370
            {{}, {SCALE_8, SCALE_6, SCALE_4},}, // Q371
            {{SCALE_K}, {},}, // Q372
            {{}, {SCALE_3},}, // Q373
            {{SCALE_3}, {SCALE_1},}, // Q374
            {{}, {SCALE_8, SCALE_3, SCALE_1},}, // Q375
            {{}, {SCALE_1},}, // Q376
            {{}, {SCALE_2},}, // Q377
    };

    @Override
    public Scale[][][] getMap() {
        return MAP;
    }

}
