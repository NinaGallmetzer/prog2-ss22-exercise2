package trafficlight.ctrl;

import trafficlight.gui.TrafficLightGui;
import trafficlight.states.*;

public class TrafficLightCtrl {

    private State greenState;
    private State redState;
    private State yellowState;
    private State offState;
    private State currentState;
    private State previousState;
    private TrafficLightGui gui;
    private int count;

    public TrafficLightCtrl() {
        super();
        initStates();
        gui = new TrafficLightGui(this);
        gui.setLight(TrafficLightColor.RED);
        gui.setVisible(true);
    }

    private void initStates() {
        greenState  = new StateGreen(this);
        redState    = new StateRed(this);
        yellowState = new StateYellow(this);
        offState    = new StateOff(this);
        previousState = redState;
        currentState  = redState;
    }

    public State getGreenState() {
        return greenState;
    }

    public State getRedState() {
        return redState;
    }

    public State getYellowState() {
        return yellowState;
    }

    public State getOffState() {return offState;}

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public State getPreviousState() {
        return previousState;
    }

    public void setPreviousState(State previousState) {
        this.previousState = previousState;
    }

    public void run() {
        gui.run();
    }

    public void nextState() {
        getCurrentState().nextState();
        gui.setLight(getCurrentState().getState());
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return this.count;
    }

}