package trafficlight.states;

import trafficlight.ctrl.TrafficLightCtrl;

public class StateOff implements State {

    private TrafficLightCtrl trafficLightCtrl;

    public StateOff(TrafficLightCtrl trafficLightCtrl) {
        super();
        this.trafficLightCtrl = trafficLightCtrl;
    }

    @Override
    public void nextState() {
        trafficLightCtrl.setCurrentState(trafficLightCtrl.getYellowState());
        trafficLightCtrl.setCount(trafficLightCtrl.getCount()+1);
    }

    @Override
    public TrafficLightColor getState() {
        return TrafficLightColor.OFF;
    }
}
