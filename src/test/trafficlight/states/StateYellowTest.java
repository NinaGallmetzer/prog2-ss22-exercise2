package trafficlight.states;

import org.junit.jupiter.api.Test;
import trafficlight.ctrl.TrafficLightCtrl;

import static org.junit.jupiter.api.Assertions.*;

class StateYellowTest {

    private final TrafficLightCtrl trafficLightCtrl = new TrafficLightCtrl();
    State yellowState = new StateYellow(trafficLightCtrl);

    @Test
    void nextStatePreviouslyGreenCount0() {
        State expected = trafficLightCtrl.getOffState();
        trafficLightCtrl.setPreviousState(new StateGreen(trafficLightCtrl));
        trafficLightCtrl.setCount(0);
        yellowState.nextState();
        State actual = trafficLightCtrl.getCurrentState();
        assertEquals(expected,actual);
    }

    @Test
    void nextStatePreviouslyGreenCount5() {
        State expected = trafficLightCtrl.getRedState();
        trafficLightCtrl.setPreviousState(new StateGreen(trafficLightCtrl));
        trafficLightCtrl.setCount(5);
        yellowState.nextState();
        State actual = trafficLightCtrl.getCurrentState();
        assertEquals(expected,actual);
    }

    @Test
    void nextStatePreviouslyRed() {
        State expected = trafficLightCtrl.getGreenState();
        trafficLightCtrl.setPreviousState(new StateRed(trafficLightCtrl));
        yellowState.nextState();
        State actual = trafficLightCtrl.getCurrentState();
        assertEquals(expected,actual);
    }

    @Test
    void getState() {
        TrafficLightColor expected = TrafficLightColor.YELLOW;
        TrafficLightColor actual = yellowState.getState();
        assertEquals(expected,actual);
    }

}