package org.papaja.adminfly.module.psy.tests.mmpi2;

public enum Answer implements AnswerInterface {

    TRUE((byte)0b1), FALSE((byte)0b10);

    private byte answer;

    Answer(byte answer) {
        this.answer = answer;
    }

    @Override
    public byte getValue() {
        return 0;
    }

}
