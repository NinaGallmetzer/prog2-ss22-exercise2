package trafficlight.states;

import org.junit.jupiter.api.Test;
import trafficlight.ctrl.TrafficLightCtrl;

import static org.junit.jupiter.api.Assertions.*;

class StateOffTest {

    private final TrafficLightCtrl trafficLightCtrl = new TrafficLightCtrl();
    State offState = new StateOff(trafficLightCtrl);

    @Test
    void nextState() {
        State expected = trafficLightCtrl.getYellowState();
        offState.nextState();
        State actual = trafficLightCtrl.getCurrentState();
        assertEquals(expected,actual);
    }

    @Test
    void getState() {
        TrafficLightColor expected = TrafficLightColor.OFF;
        TrafficLightColor actual = offState.getState();
        assertEquals(expected,actual);
    }

}