package main.states;

import java.awt.Graphics;
import main.Main;

/**
 *
 * @author asilence24
 */
public abstract class State {
    
    private static State currentState = null;
    
    public static void setState(State state) {
        currentState = state;
        currentState.reloadState();
    }

    public static State getState() {
        return currentState;
    }
    
    //Class
    protected Main main;

    public State(Main main) {
        this.main = main;
    }
    public abstract void update();
    public abstract void render(Graphics g);
    public abstract void reloadState();
}
