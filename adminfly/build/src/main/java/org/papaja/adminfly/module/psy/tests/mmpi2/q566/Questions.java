package org.papaja.adminfly.module.psy.tests.mmpi2.q566;

import org.papaja.adminfly.module.psy.tests.mmpi2.Answer;
import org.papaja.adminfly.module.psy.tests.mmpi2.QuestionsInterface;
import org.papaja.adminfly.module.psy.tests.mmpi2.Scale;

import static org.papaja.adminfly.module.psy.tests.mmpi2.Scale.*;

public enum Questions implements QuestionsInterface {
    QUESTIONS;

    /**
     * Q-N:
     *   0-FALSE:
     *     SCALE[]
     *   1-TRUE:
     *     SCALE[]
     */
    private static final Scale[][][] MAP = {
            {{SCALE_5_F, SCALE_5_M},{},}, // Q1
            {{SCALE_1, SCALE_2, SCALE_3},{},}, // Q2
            {{SCALE_1, SCALE_3, SCALE_7},{},}, // Q3
            {{},{SCALE_5_F, SCALE_5_M},}, // Q4
            {{},{SCALE_2},}, // Q5
            {{SCALE_3},{},}, // Q6
            {{SCALE_1, SCALE_3},{},}, // Q7
            {{SCALE_2, SCALE_3, SCALE_4, SCALE_7, SCALE_8},{},}, // Q8
            {{SCALE_1, SCALE_2, SCALE_3},{},}, // Q9
            {{},{SCALE_3, SCALE_7},}, // Q10
            {{},{SCALE_9},}, // Q11
            {{SCALE_3},{},}, // Q12
            {{},{SCALE_2, SCALE_9},}, // Q13
            {{},{SCALE_F},}, // Q14
            {{SCALE_L},{SCALE_6, SCALE_7, SCALE_8},}, // Q15
            {{},{SCALE_4, SCALE_6, SCALE_8},}, // Q16
            {{SCALE_F, SCALE_8},{},}, // Q17
            {{SCALE_1, SCALE_2},{},}, // Q18
            {{SCALE_5_F, SCALE_5_M},{},}, // Q19
            {{SCALE_F, SCALE_4, SCALE_8},{},}, // Q20
            {{},{SCALE_4, SCALE_8, SCALE_9},}, // Q21
            {{},{SCALE_6, SCALE_7, SCALE_8, SCALE_9},}, // Q22
            {{},{SCALE_F, SCALE_1, SCALE_2, SCALE_3},}, // Q23
            {{},{SCALE_4, SCALE_6, SCALE_8},}, // Q24
            {{SCALE_5_F, SCALE_5_M},{SCALE_0},}, // Q25
            {{SCALE_3, SCALE_5_F, SCALE_5_M},{},}, // Q26
            {{},{SCALE_F, SCALE_6},}, // Q27
            {{SCALE_5_M},{},}, // Q28
            {{},{SCALE_1},}, // Q29
            {{SCALE_L, SCALE_K, SCALE_2, SCALE_3},{},}, // Q30
            {{},{SCALE_F},}, // Q31
            {{},{SCALE_2, SCALE_3, SCALE_4, SCALE_7, SCALE_8, SCALE_0},}, // Q32
            {{SCALE_F, SCALE_4, SCALE_8},{SCALE_0},}, // Q33
            {{},{SCALE_F},}, // Q34
            {{},{SCALE_F, SCALE_4, SCALE_6, SCALE_8},}, // Q35
            {{SCALE_2, SCALE_7},{SCALE_4},}, // Q36
            {{SCALE_4, SCALE_8},{},}, // Q37
            {{},{SCALE_8},}, // Q38
            {{SCALE_K, SCALE_2},{},}, // Q39
            {{},{SCALE_F, SCALE_8},}, // Q40
            {{},{SCALE_2, SCALE_7, SCALE_8},}, // Q41
            {{},{SCALE_F, SCALE_4},}, // Q42
            {{},{SCALE_1, SCALE_2, SCALE_3},}, // Q43
            {{},{SCALE_3},}, // Q44
            {{SCALE_L},{},}, // Q45
            {{SCALE_2},{},}, // Q46
            {{},{SCALE_3, SCALE_8},}, // Q47
            {{},{SCALE_F},}, // Q48
            {{},{SCALE_F},}, // Q49
            {{},{SCALE_F},}, // Q50
            {{SCALE_1, SCALE_2, SCALE_3},{},}, // Q51
            {{},{SCALE_2, SCALE_8},}, // Q52
            {{},{SCALE_F},}, // Q53
            {{SCALE_F},{},}, // Q54
            {{SCALE_1, SCALE_3},{},}, // Q55
            {{},{SCALE_F},}, // Q56
            {{SCALE_2, SCALE_0},{},}, // Q57
            {{SCALE_2},{},}, // Q58
            {{},{SCALE_9},}, // Q59
            {{SCALE_L},{},}, // Q60
            {{},{SCALE_4},}, // Q61
            {{},{SCALE_1},}, // Q62
            {{SCALE_1},{},}, // Q63
            {{SCALE_2},{SCALE_9},}, // Q64
            {{SCALE_F, SCALE_8},{},}, // Q65
            {{},{SCALE_F},}, // Q66
            {{},{SCALE_2, SCALE_4, SCALE_7, SCALE_0},}, // Q67
            {{SCALE_1},{},}, // Q68
            {{SCALE_5_F},{SCALE_5_M},}, // Q69
            {{},{SCALE_5_F, SCALE_5_M},}, // Q70
            {{SCALE_K, SCALE_3},{},}, // Q71
            {{},{SCALE_1},}, // Q72
            {{},{SCALE_9},}, // Q73
            {{},{SCALE_5_F, SCALE_5_M},}, // Q74
            {{SCALE_L, SCALE_F},{},}, // Q75
            {{},{SCALE_3, SCALE_7, SCALE_8},}, // Q76
            {{},{SCALE_5_F, SCALE_5_M},}, // Q77
            {{},{SCALE_5_F, SCALE_5_M},}, // Q78
            {{SCALE_5_F, SCALE_5_M},{},}, // Q79
            {{SCALE_2, SCALE_5_F, SCALE_5_M},{},}, // Q80
            {{SCALE_5_F, SCALE_5_M},{},}, // Q81
            {{SCALE_4},{SCALE_0},}, // Q82
            {{SCALE_F},{},}, // Q83
            {{},{SCALE_4},}, // Q84
            {{},{SCALE_F},}, // Q85
            {{},{SCALE_2, SCALE_7},}, // Q86
            {{},{SCALE_5_F, SCALE_5_M},}, // Q87
            {{SCALE_2},{},}, // Q88
            {{SCALE_K, SCALE_2, SCALE_3, SCALE_5_F, SCALE_5_M},{},}, // Q89
            {{SCALE_L},{},}, // Q90
            {{SCALE_4, SCALE_0},{},}, // Q91
            {{},{SCALE_5_F, SCALE_5_M},}, // Q92
            {{SCALE_3, SCALE_6},{},}, // Q93
            {{},{SCALE_4, SCALE_7},}, // Q94
            {{SCALE_2},{},}, // Q95
            {{SCALE_K},{SCALE_4},}, // Q96
            {{},{SCALE_8, SCALE_9},}, // Q97
            {{SCALE_2},{},}, // Q98
            {{SCALE_5_F, SCALE_5_M, SCALE_0},{},}, // Q99
            {{},{SCALE_9},}, // Q100
            {{SCALE_9},{},}, // Q101
            {{},{SCALE_4, SCALE_7},}, // Q102
            {{SCALE_1, SCALE_3, SCALE_8},{},}, // Q103
            {{},{SCALE_2, SCALE_8},}, // Q104
            {{SCALE_L, SCALE_9},{},}, // Q105
            {{},{SCALE_4, SCALE_7},}, // Q106
            {{SCALE_2, SCALE_3, SCALE_4, SCALE_6},{},}, // Q107
            {{},{SCALE_1},}, // Q108
            {{SCALE_3, SCALE_6},{SCALE_9},}, // Q109
            {{},{SCALE_4, SCALE_6},}, // Q110
            {{SCALE_6, SCALE_9},{SCALE_0},}, // Q111
            {{SCALE_F, SCALE_5_F, SCALE_5_M},{},}, // Q112
            {{SCALE_F},{},}, // Q113
            {{},{SCALE_1, SCALE_3},}, // Q114
            {{SCALE_F, SCALE_5_F, SCALE_5_M},{},}, // Q115
            {{SCALE_5_F, SCALE_5_M},{},}, // Q116
            {{SCALE_5_F, SCALE_5_M, SCALE_6},{SCALE_0},}, // Q117
            {{},{SCALE_4},}, // Q118
            {{SCALE_8, SCALE_9, SCALE_0},{},}, // Q119
            {{SCALE_L, SCALE_5_F, SCALE_5_M},{},}, // Q120
            {{},{SCALE_F, SCALE_6, SCALE_8},}, // Q121
            {{SCALE_2, SCALE_7},{},}, // Q122
            {{},{SCALE_F, SCALE_6},}, // Q123
            {{SCALE_K, SCALE_3, SCALE_6},{SCALE_0},}, // Q124
            {{},{SCALE_1},}, // Q125
            {{SCALE_5_F, SCALE_5_M},{SCALE_0},}, // Q126
            {{},{SCALE_4, SCALE_6, SCALE_9},}, // Q127
            {{SCALE_3},{},}, // Q128
            {{SCALE_K, SCALE_3},{},}, // Q129
            {{SCALE_2},{SCALE_9},}, // Q130
            {{SCALE_2},{},}, // Q131
            {{},{SCALE_5_F, SCALE_5_M},}, // Q132
            {{SCALE_5_F},{SCALE_5_M},}, // Q133
            {{SCALE_K, SCALE_4},{SCALE_5_F, SCALE_5_M, SCALE_9},}, // Q134
            {{SCALE_L},{},}, // Q135
            {{SCALE_3},{},}, // Q136
            {{SCALE_3, SCALE_4},{},}, // Q137
            {{SCALE_K},{SCALE_2, SCALE_0},}, // Q138
            {{},{SCALE_F},}, // Q139
            {{SCALE_1},{SCALE_5_F, SCALE_5_M},}, // Q140
            {{SCALE_3, SCALE_4},{},}, // Q141
            {{SCALE_K},{SCALE_2, SCALE_7},}, // Q142
            {{SCALE_0},{},}, // Q143
            {{SCALE_5_F, SCALE_5_M},{},}, // Q144
            {{SCALE_2},{SCALE_9},}, // Q145
            {{},{SCALE_F},}, // Q146
            {{SCALE_3},{SCALE_0},}, // Q147
            {{SCALE_K, SCALE_9},{},}, // Q148
            {{},{SCALE_5_F, SCALE_5_M},}, // Q149
            {{SCALE_L},{},}, // Q150
            {{},{SCALE_F, SCALE_6},}, // Q151
            {{SCALE_2, SCALE_7},{},}, // Q152
            {{SCALE_1, SCALE_2, SCALE_3},{},}, // Q153
            {{SCALE_2},{},}, // Q154
            {{SCALE_1, SCALE_2, SCALE_4},{},}, // Q155
            {{},{SCALE_F, SCALE_8, SCALE_9},}, // Q156
            {{},{SCALE_6, SCALE_8, SCALE_9},}, // Q157
            {{},{SCALE_2, SCALE_6},}, // Q158
            {{},{SCALE_2, SCALE_7, SCALE_8},}, // Q159
            {{SCALE_K, SCALE_2, SCALE_3},{},}, // Q160
            {{},{SCALE_1},}, // Q161
            {{SCALE_3},{},}, // Q162
            {{SCALE_1, SCALE_3},{},}, // Q163
            {{SCALE_F, SCALE_7},{},}, // Q164
            {{SCALE_L},{},}, // Q165
            {{SCALE_9},{},}, // Q166
            {{},{SCALE_9},}, // Q167
            {{},{SCALE_F, SCALE_8},}, // Q168
            {{SCALE_F},{},}, // Q169
            {{SCALE_K, SCALE_3, SCALE_4},{},}, // Q170
            {{SCALE_K, SCALE_4, SCALE_9},{SCALE_0},}, // Q171
            {{SCALE_3},{SCALE_0},}, // Q172
            {{SCALE_4},{},}, // Q173
            {{SCALE_3},{},}, // Q174
            {{SCALE_1, SCALE_3},{},}, // Q175
            {{SCALE_5_F, SCALE_5_M},{},}, // Q176
            {{SCALE_F, SCALE_8},{},}, // Q177
            {{SCALE_2, SCALE_7, SCALE_8},{},}, // Q178
            {{SCALE_3, SCALE_5_M, SCALE_8},{SCALE_5_F},}, // Q179
            {{SCALE_K, SCALE_3, SCALE_4, SCALE_9},{SCALE_0},}, // Q180
            {{},{SCALE_9},}, // Q181
            {{},{SCALE_2, SCALE_7, SCALE_8},}, // Q182
            {{SCALE_K, SCALE_4},{},}, // Q183
            {{},{SCALE_F},}, // Q184
            {{SCALE_F},{},}, // Q185
            {{},{SCALE_3},}, // Q186
            {{SCALE_5_F, SCALE_5_M},{SCALE_8},}, // Q187
            {{SCALE_1, SCALE_3},{},}, // Q188
            {{},{SCALE_1, SCALE_2, SCALE_3, SCALE_7},}, // Q189
            {{SCALE_1, SCALE_3},{},}, // Q190
            {{SCALE_2},{},}, // Q191
            {{SCALE_1, SCALE_3, SCALE_8},{},}, // Q192
            {{SCALE_2},{SCALE_0},}, // Q193
            {{},{SCALE_8, SCALE_9},}, // Q194
            {{SCALE_L},{},}, // Q195
            {{SCALE_F, SCALE_8},{},}, // Q196
            {{},{SCALE_F},}, // Q197
            {{SCALE_5_F, SCALE_5_M},{},}, // Q198
            {{SCALE_F},{},}, // Q199
            {{},{SCALE_F},}, // Q200
            {{SCALE_3, SCALE_4},{SCALE_0},}, // Q201
            {{},{SCALE_F, SCALE_6, SCALE_8},}, // Q202
            {{},{SCALE_5_F, SCALE_5_M},}, // Q203
            {{},{SCALE_5_F, SCALE_5_M},}, // Q204
            {{},{SCALE_F},}, // Q205
            {{},{SCALE_F},}, // Q206
            {{SCALE_2},{},}, // Q207
            {{SCALE_2, SCALE_0},{},}, // Q208
            {{},{SCALE_F},}, // Q209
            {{},{SCALE_F, SCALE_8},}, // Q210
            {{},{SCALE_F},}, // Q211
            {{},{SCALE_8, SCALE_9},}, // Q212
            {{SCALE_3, SCALE_5_F, SCALE_5_M},{},}, // Q213
            {{SCALE_5_M},{},}, // Q214
            {{},{SCALE_F, SCALE_4},}, // Q215
            {{},{SCALE_4},}, // Q216
            {{SCALE_K},{SCALE_5_F, SCALE_5_M, SCALE_7},}, // Q217
            {{},{SCALE_F},}, // Q218
            {{SCALE_5_F, SCALE_5_M},{},}, // Q219
            {{SCALE_F, SCALE_8},{},}, // Q220
            {{SCALE_5_F, SCALE_5_M},{},}, // Q221
            {{},{SCALE_9},}, // Q222
            {{SCALE_5_F, SCALE_5_M},{},}, // Q223
            {{},{SCALE_4},}, // Q224
            {{SCALE_L},{},}, // Q225
            {{},{SCALE_5_F, SCALE_5_M, SCALE_9},}, // Q226
            {{},{SCALE_F},}, // Q227
            {{},{SCALE_9},}, // Q228
            {{SCALE_5_F, SCALE_5_M, SCALE_0},{},}, // Q229
            {{SCALE_1, SCALE_3},{},}, // Q230
            {{SCALE_4, SCALE_5_F, SCALE_0},{SCALE_5_M},}, // Q231
            {{},{SCALE_9},}, // Q232
            {{},{SCALE_9},}, // Q233
            {{SCALE_K, SCALE_3},{},}, // Q234
            {{SCALE_4},{},}, // Q235
            {{},{SCALE_2, SCALE_0},}, // Q236
            {{SCALE_4},{},}, // Q237
            {{SCALE_2},{SCALE_3, SCALE_7, SCALE_8, SCALE_9},}, // Q238
            {{},{SCALE_4, SCALE_5_F, SCALE_5_M},}, // Q239
            {{},{SCALE_9},}, // Q240
            {{},{SCALE_8},}, // Q241
            {{},{},}, // Q242
            {{SCALE_1, SCALE_3},{},}, // Q243
            {{},{SCALE_4},}, // Q244
            {{},{SCALE_F, SCALE_4},}, // Q245
            {{},{SCALE_F},}, // Q246
            {{},{SCALE_F},}, // Q247
            {{SCALE_2, SCALE_4},{},}, // Q248
            {{SCALE_5_F, SCALE_5_M},{},}, // Q249
            {{},{SCALE_9},}, // Q250
            {{},{SCALE_8, SCALE_9},}, // Q251
            {{},{SCALE_F},}, // Q252
            {{},{},}, // Q253
            {{SCALE_5_F, SCALE_5_M, SCALE_0},{},}, // Q254
            {{SCALE_L},{},}, // Q255
            {{},{SCALE_F},}, // Q256
            {{SCALE_F},{},}, // Q257
            {{SCALE_F},{},}, // Q258
            {{},{SCALE_2, SCALE_8},}, // Q259
            {{SCALE_5_F, SCALE_5_M},{},}, // Q260
            {{},{SCALE_5_F, SCALE_5_M},}, // Q261
            {{SCALE_5_F, SCALE_5_M, SCALE_0},{},}, // Q262
            {{SCALE_2},{SCALE_9},}, // Q263
            {{SCALE_5_F, SCALE_5_M},{},}, // Q264
            {{SCALE_3},{},}, // Q265
            {{},{SCALE_7, SCALE_8, SCALE_9},}, // Q266
            {{SCALE_K, SCALE_3, SCALE_4, SCALE_9},{SCALE_0},}, // Q267
            {{SCALE_6},{SCALE_9},}, // Q268
            {{},{SCALE_F},}, // Q269
            {{SCALE_2},{},}, // Q270
            {{SCALE_2},{SCALE_9},}, // Q271
            {{SCALE_F, SCALE_K, SCALE_2},{},}, // Q272
            {{},{SCALE_1, SCALE_8},}, // Q273
            {{SCALE_1, SCALE_3},{},}, // Q274
            {{},{SCALE_F, SCALE_6},}, // Q275
            {{SCALE_F, SCALE_8},{},}, // Q276
            {{},{SCALE_9},}, // Q277
            {{},{SCALE_5_F, SCALE_5_M, SCALE_0},}, // Q278
            {{SCALE_3},{SCALE_9},}, // Q279
            {{SCALE_5_F, SCALE_5_M},{},}, // Q280
            {{SCALE_1, SCALE_6, SCALE_8, SCALE_0},{},}, // Q281
            {{},{SCALE_5_F, SCALE_5_M, SCALE_8},}, // Q282
            {{SCALE_5_F, SCALE_5_M},{},}, // Q283
            {{},{SCALE_4, SCALE_6},}, // Q284
            {{SCALE_L, SCALE_2},{},}, // Q285
            {{},{SCALE_F},}, // Q286
            {{SCALE_4},{},}, // Q287
            {{},{},}, // Q288
            {{SCALE_3, SCALE_4, SCALE_9},{},}, // Q289
            {{},{},}, // Q290
            {{},{SCALE_F, SCALE_6, SCALE_8},}, // Q291
            {{SCALE_3},{SCALE_0},}, // Q292
            {{},{SCALE_F, SCALE_6},}, // Q293
            {{SCALE_4, SCALE_6},{},}, // Q294
            {{},{SCALE_5_F, SCALE_5_M},}, // Q295
            {{SCALE_K, SCALE_2, SCALE_4, SCALE_0},{},}, // Q296
            {{SCALE_5_F},{SCALE_5_M, SCALE_8},}, // Q297
            {{},{SCALE_9},}, // Q298
            {{},{SCALE_5_F, SCALE_5_M, SCALE_6},}, // Q299
            {{SCALE_5_F, SCALE_5_M},{},}, // Q300
            {{},{SCALE_7, SCALE_8},}, // Q301
            {{},{},}, // Q302
            {{},{SCALE_8},}, // Q303
            {{},{SCALE_7, SCALE_0},}, // Q304
            {{},{SCALE_6, SCALE_7, SCALE_8},}, // Q305
            {{SCALE_8},{},}, // Q306
            {{},{SCALE_8},}, // Q307
            {{},{},}, // Q308
            {{SCALE_8, SCALE_0},{},}, // Q309
            {{},{},}, // Q310
            {{},{},}, // Q311
            {{},{SCALE_8},}, // Q312
            {{SCALE_6},{},}, // Q313
            {{},{},}, // Q314
            {{},{},}, // Q315
            {{SCALE_K, SCALE_6},{SCALE_0},}, // Q316
            {{},{SCALE_6, SCALE_7},}, // Q317
            {{},{},}, // Q318
            {{SCALE_6},{},}, // Q319
            {{},{SCALE_8},}, // Q320
            {{},{SCALE_7, SCALE_0},}, // Q321
            {{SCALE_K, SCALE_8},{},}, // Q322
            {{},{},}, // Q323
            {{},{SCALE_8},}, // Q324
            {{},{SCALE_8},}, // Q325
            {{},{},}, // Q326
            {{SCALE_6},{},}, // Q327
            {{},{},}, // Q328
            {{SCALE_7},{},}, // Q329
            {{SCALE_8},{},}, // Q330
            {{},{},}, // Q331
            {{},{SCALE_8, SCALE_0},}, // Q332
            {{},{},}, // Q333
            {{},{SCALE_8},}, // Q334
            {{},{SCALE_8},}, // Q335
            {{},{SCALE_7, SCALE_0},}, // Q336
            {{},{SCALE_7},}, // Q337
            {{},{SCALE_6},}, // Q338
            {{},{SCALE_8},}, // Q339
            {{},{SCALE_7},}, // Q340
            {{},{SCALE_6, SCALE_8},}, // Q341
            {{},{SCALE_7, SCALE_0},}, // Q342
            {{},{SCALE_7},}, // Q343
            {{},{SCALE_7},}, // Q344
            {{},{SCALE_8},}, // Q345
            {{},{SCALE_7},}, // Q346
            {{SCALE_6},{},}, // Q347
            {{SCALE_6},{},}, // Q348
            {{},{SCALE_7, SCALE_8},}, // Q349
            {{},{SCALE_8},}, // Q350
            {{},{SCALE_7},}, // Q351
            {{},{SCALE_7, SCALE_8},}, // Q352
            {{SCALE_7, SCALE_0},{},}, // Q353
            {{},{SCALE_8},}, // Q354
            {{},{SCALE_8},}, // Q355
            {{},{SCALE_7, SCALE_8},}, // Q356
            {{},{SCALE_7, SCALE_0},}, // Q357
            {{},{},}, // Q358
            {{SCALE_7},{SCALE_0},}, // Q359
            {{},{SCALE_7, SCALE_8},}, // Q360
            {{},{SCALE_7},}, // Q361
            {{},{},}, // Q362
            {{},{SCALE_8},}, // Q363
            {{},{SCALE_6, SCALE_8},}, // Q364
            {{},{SCALE_6},}, // Q365
            {{},{},}, // Q366
            {{},{},}, // Q367
            {{},{},}, // Q368
            {{},{},}, // Q369
            {{},{},}, // Q370
            {{SCALE_0},{},}, // Q371
            {{},{},}, // Q372
            {{},{},}, // Q373
            {{SCALE_K},{},}, // Q374
            {{},{},}, // Q375
            {{},{},}, // Q376
            {{},{SCALE_0},}, // Q377
            {{},{},}, // Q378
            {{},{},}, // Q379
            {{},{},}, // Q380
            {{},{},}, // Q381
            {{},{},}, // Q382
            {{SCALE_K},{SCALE_0},}, // Q383
            {{},{},}, // Q384
            {{},{},}, // Q385
            {{},{},}, // Q386
            {{},{},}, // Q387
            {{},{},}, // Q388
            {{},{},}, // Q389
            {{},{},}, // Q390
            {{SCALE_0},{},}, // Q391
            {{},{},}, // Q392
            {{},{},}, // Q393
            {{},{},}, // Q394
            {{},{},}, // Q395
            {{},{},}, // Q396
            {{SCALE_K},{},}, // Q397
            {{SCALE_K},{SCALE_0},}, // Q398
            {{},{},}, // Q399
            {{SCALE_0},{},}, // Q400
            {{},{SCALE_0},}, // Q401
            {{},{},}, // Q402
            {{},{},}, // Q403
            {{},{},}, // Q404
            {{},{},}, // Q405
            {{SCALE_K},{},}, // Q406
            {{},{},}, // Q407
            {{},{},}, // Q408
            {{},{},}, // Q409
            {{},{},}, // Q410
            {{},{},}, // Q411
            {{},{},}, // Q412
            {{},{},}, // Q413
            {{},{},}, // Q414
            {{SCALE_0},{},}, // Q415
            {{},{},}, // Q416
            {{},{},}, // Q417
            {{},{},}, // Q418
            {{},{},}, // Q419
            {{},{},}, // Q420
            {{},{},}, // Q421
            {{},{},}, // Q422
            {{},{},}, // Q423
            {{},{},}, // Q424
            {{},{},}, // Q425
            {{},{},}, // Q426
            {{},{SCALE_0},}, // Q427
            {{},{},}, // Q428
            {{},{},}, // Q429
            {{},{},}, // Q430
            {{},{},}, // Q431
            {{},{},}, // Q432
            {{},{},}, // Q433
            {{},{},}, // Q434
            {{},{},}, // Q435
            {{},{SCALE_0},}, // Q436
            {{},{},}, // Q437
            {{},{},}, // Q438
            {{},{},}, // Q439
            {{SCALE_0},{},}, // Q440
            {{},{},}, // Q441
            {{},{},}, // Q442
            {{},{},}, // Q443
            {{},{},}, // Q444
            {{},{},}, // Q445
            {{SCALE_0},{},}, // Q446
            {{},{},}, // Q447
            {{},{},}, // Q448
            {{SCALE_0},{},}, // Q449
            {{SCALE_0},{},}, // Q450
            {{SCALE_0},{},}, // Q451
            {{},{},}, // Q452
            {{},{},}, // Q453
            {{},{},}, // Q454
            {{},{SCALE_0},}, // Q455
            {{},{},}, // Q456
            {{},{},}, // Q457
            {{},{},}, // Q458
            {{},{},}, // Q459
            {{},{},}, // Q460
            {{SCALE_K},{},}, // Q461
            {{SCALE_0},{},}, // Q462
            {{},{},}, // Q463
            {{},{},}, // Q464
            {{},{},}, // Q465
            {{},{},}, // Q466
            {{},{SCALE_0},}, // Q467
            {{},{},}, // Q468
            {{SCALE_0},{},}, // Q469
            {{},{},}, // Q470
            {{},{},}, // Q471
            {{},{},}, // Q472
            {{},{SCALE_0},}, // Q473
            {{},{},}, // Q474
            {{},{},}, // Q475
            {{},{},}, // Q476
            {{},{},}, // Q477
            {{},{},}, // Q478
            {{SCALE_0},{},}, // Q479
            {{},{},}, // Q480
            {{SCALE_0},{},}, // Q481
            {{SCALE_0},{},}, // Q482
            {{},{},}, // Q483
            {{},{},}, // Q484
            {{},{},}, // Q485
            {{},{},}, // Q486
            {{},{},}, // Q487
            {{},{},}, // Q488
            {{},{},}, // Q489
            {{},{},}, // Q490
            {{},{},}, // Q491
            {{},{},}, // Q492
            {{},{},}, // Q493
            {{},{},}, // Q494
            {{},{},}, // Q495
            {{},{},}, // Q496
            {{},{},}, // Q497
            {{},{},}, // Q498
            {{},{},}, // Q499
            {{},{},}, // Q500
            {{SCALE_0},{},}, // Q501
            {{SCALE_K},{},}, // Q502
            {{},{},}, // Q503
            {{},{},}, // Q504
            {{},{},}, // Q505
            {{},{},}, // Q506
            {{},{},}, // Q507
            {{},{},}, // Q508
            {{},{},}, // Q509
            {{},{},}, // Q510
            {{},{},}, // Q511
            {{},{},}, // Q512
            {{},{},}, // Q513
            {{},{},}, // Q514
            {{},{},}, // Q515
            {{},{},}, // Q516
            {{},{},}, // Q517
            {{},{},}, // Q518
            {{},{},}, // Q519
            {{},{},}, // Q520
            {{SCALE_0},{},}, // Q521
            {{},{},}, // Q522
            {{},{},}, // Q523
            {{},{},}, // Q524
            {{},{},}, // Q525
            {{},{},}, // Q526
            {{},{},}, // Q527
            {{},{},}, // Q528
            {{},{},}, // Q529
            {{},{},}, // Q530
            {{},{},}, // Q531
            {{},{},}, // Q532
            {{},{},}, // Q533
            {{},{},}, // Q534
            {{},{},}, // Q535
            {{},{},}, // Q536
            {{},{},}, // Q537
            {{},{},}, // Q538
            {{},{},}, // Q539
            {{},{},}, // Q540
            {{},{},}, // Q541
            {{},{},}, // Q542
            {{},{},}, // Q543
            {{},{},}, // Q544
            {{},{},}, // Q545
            {{},{},}, // Q546
            {{SCALE_0},{},}, // Q547
            {{},{},}, // Q548
            {{},{SCALE_0},}, // Q549
            {{},{},}, // Q550
            {{},{},}, // Q551
            {{},{},}, // Q552
            {{},{},}, // Q553
            {{},{},}, // Q554
            {{},{},}, // Q555
            {{},{},}, // Q556
            {{},{},}, // Q557
            {{},{},}, // Q558
            {{},{},}, // Q559
            {{},{},}, // Q560
            {{},{},}, // Q561
            {{},{},}, // Q562
            {{},{},}, // Q563
            {{},{SCALE_0},}, // Q564
            {{},{},}, // Q565
            {{},{},}, // Q566
    };

    @Override
    public Scale[] getScales(int question, Answer answer) {
        return MAP[question - 1][answer.getValue()];
    }

    @Override
    public boolean hasScales(int question, Answer answer) {
        return getScales(question, answer).length > 0;
    }

}
