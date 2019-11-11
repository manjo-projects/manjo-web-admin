package org.papaja.adminfly.module.psy.tests.wizard;

import static org.papaja.adminfly.module.psy.tests.wizard.Wizard.Direction.BACKWARD;
import static org.papaja.adminfly.module.psy.tests.wizard.Wizard.Direction.FORWARD;

public interface Wizard<T> {

    int lowest();

    int highest();

    int position();

    void start();

    void reset();

    void finish();

    boolean validate(Direction direction);

    boolean is(State state);

    void move(Direction direction);

    boolean submit(T result, Direction direction);

    void update();

    default void forward() {
        move(FORWARD);
    }

    default void backward() {
        move(BACKWARD);
    }

    default int size() {
        return (highest() - lowest()) + 1;
    }

    enum Direction {

        FORWARD(1), BACKWARD(-1);

        private int step;

        Direction(int step) {
            this.step = step;
        }

        public int step() {
            return step;
        }

    }

    enum State {

        RUNNING(4), FINISHED(2), NEW(1);

        private int value;

        State(int value) {
            this.value = value;
        }

        public int value() {
            return value;
        }

    }

}
