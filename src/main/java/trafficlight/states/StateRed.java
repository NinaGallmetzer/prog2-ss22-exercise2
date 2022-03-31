package trafficlight.states;

import trafficlight.ctrl.TrafficLightCtrl;

public class StateRed implements State {

    private TrafficLightCtrl trafficLightCtrl;

    public StateRed(TrafficLightCtrl trafficLightCtrl) {
        super();
        this.trafficLightCtrl = trafficLightCtrl;
    }

    @Override
    public void nextState() {
        trafficLightCtrl.setPreviousState(this);
        trafficLightCtrl.setCurrentState(trafficLightCtrl.getYellowState());
    }

    @Override
    public TrafficLightColor getState() {
        return TrafficLightColor.RED;
    }

}
