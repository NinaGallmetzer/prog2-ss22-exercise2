package trafficlight.states;

import trafficlight.ctrl.TrafficLightCtrl;

public class StateGreen implements State {

    private TrafficLightCtrl trafficLightCtrl;

    public StateGreen(TrafficLightCtrl trafficLightCtrl) {
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
        return TrafficLightColor.GREEN;
    }

}
