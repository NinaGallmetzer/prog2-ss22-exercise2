package trafficlight.states;

import org.junit.jupiter.api.Test;
import trafficlight.ctrl.TrafficLightCtrl;

import static org.junit.jupiter.api.Assertions.*;

class StateRedTest {

    private final TrafficLightCtrl trafficLightCtrl = new TrafficLightCtrl();
    State redState = new StateRed(trafficLightCtrl);

    @Test
    void nextState() {
        State expected = trafficLightCtrl.getYellowState();
        redState.nextState();
        State actual = trafficLightCtrl.getCurrentState();
        assertEquals(expected,actual);
    }

    @Test
    void getState() {
        TrafficLightColor expected = TrafficLightColor.RED;
        TrafficLightColor actual = redState.getState();
        assertEquals(expected,actual);
    }

}