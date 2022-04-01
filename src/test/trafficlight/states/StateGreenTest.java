package trafficlight.states;

import org.junit.jupiter.api.Test;
import trafficlight.ctrl.TrafficLightCtrl;

import static org.junit.jupiter.api.Assertions.*;

class StateGreenTest {

    private final TrafficLightCtrl trafficLightCtrl = new TrafficLightCtrl();
    State greenState = new StateGreen(trafficLightCtrl);

    @Test
    void nextState() {
        State expected = trafficLightCtrl.getYellowState();
        greenState.nextState();
        State actual = trafficLightCtrl.getCurrentState();
        assertEquals(expected,actual);
    }

    @Test
    void getState() {
        TrafficLightColor expected = TrafficLightColor.GREEN;
        TrafficLightColor actual = greenState.getState();
        assertEquals(expected,actual);
    }

}