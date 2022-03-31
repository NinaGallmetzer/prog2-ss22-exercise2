package trafficlight.states;

import trafficlight.ctrl.TrafficLightCtrl;

public class StateYellow implements State {

    private TrafficLightCtrl trafficLightCtrl;

    public StateYellow(TrafficLightCtrl trafficLightCtrl) {
        super();
        this.trafficLightCtrl = trafficLightCtrl;
    }

    @Override
    public void nextState() {
        if (trafficLightCtrl.getPreviousState() instanceof StateGreen) {
            if (trafficLightCtrl.getCount() < 5) {
                trafficLightCtrl.setCurrentState(trafficLightCtrl.getOffState());
                trafficLightCtrl.setCount(trafficLightCtrl.getCount()+1);
            } else {
                trafficLightCtrl.setCount(0);
                trafficLightCtrl.setCurrentState(trafficLightCtrl.getRedState());
            }
        } else {
            trafficLightCtrl.setCount(0);
            trafficLightCtrl.setCurrentState(trafficLightCtrl.getGreenState());
        }
    }

    @Override
    public TrafficLightColor getState() {
        return TrafficLightColor.YELLOW;
    }

}
