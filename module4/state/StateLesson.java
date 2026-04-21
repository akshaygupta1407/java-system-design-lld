package module4.state;

interface TrafficLightState {
    void next(TrafficLightContext context);
    String getName();
}

class GreenState implements TrafficLightState {
    public void next(TrafficLightContext context) {
        context.setState(new YellowState());
    }

    public String getName() {
        return "Green";
    }
}

class YellowState implements TrafficLightState {
    public void next(TrafficLightContext context) {
        context.setState(new RedState());
    }

    public String getName() {
        return "Yellow";
    }
}

class RedState implements TrafficLightState {
    public void next(TrafficLightContext context) {
        context.setState(new GreenState());
    }

    public String getName() {
        return "Red";
    }
}

class TrafficLightContext {
    private TrafficLightState state = new RedState();

    public void setState(TrafficLightState state) {
        this.state = state;
    }

    public void change() {
        state.next(this);
    }

    public void show() {
        System.out.println("Traffic light is " + state.getName());
    }
}

public class StateLesson {
    public static void main(String[] args) {
        System.out.println("--- State Demo ---");
        TrafficLightContext light = new TrafficLightContext();
        light.show();
        light.change();
        light.show();
        light.change();
        light.show();
    }
}
