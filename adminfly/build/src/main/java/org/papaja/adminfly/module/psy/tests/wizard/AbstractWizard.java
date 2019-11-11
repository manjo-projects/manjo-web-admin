package org.papaja.adminfly.module.psy.tests.wizard;

import java.util.HashMap;
import java.util.Map;

import static org.papaja.adminfly.module.psy.tests.wizard.Wizard.State.*;

abstract public class AbstractWizard<T> implements Wizard<T> {

    protected Map<Integer, T> results = new HashMap<>();
    protected State           state;
    protected int             position;
    protected int             lowest;
    protected int             highest;

    public AbstractWizard(int lowest, int highest) {
        this.lowest = lowest;
        this.highest = highest;
        reset();
    }

    @Override
    public int lowest() {
        return lowest;
    }

    @Override
    public int highest() {
        return highest;
    }

    @Override
    public int position() {
        return position;
    }

    @Override
    public void start() {
        position = lowest();
        state = RUNNING;
    }

    @Override
    public void reset() {
        position = lowest() - 1;
        state = NEW;
    }

    @Override
    public void finish() {
        position = highest();
        state = FINISHED;
    }

    @Override
    public void move(Direction direction) {
        position += direction.step();
    }

    @Override
    public boolean submit(T result, Direction direction) {
        boolean submitted = false;

        if (validate(direction)) {
            results.put(position(), result);
            move(direction);
            submitted = true;
        }

        return submitted;
    }

    @Override
    public void update() {
        if (position() == lowest() - 1) {
            start();
        } else if (position() < lowest()) {
            reset();
        } else if (position() > highest()) {
            finish();
        }
    }

    @Override
    public boolean validate(Direction direction) {
        return (position() + direction.step()) >= lowest() && position() - 1 <= highest();
    }

    @Override
    public boolean is(State state) {
        return this.state.equals(state);
    }

    @Override
    public Map<Integer, T> results() {
        return results;
    }

}
