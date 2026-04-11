package module2.isp;

/**
 * PRACTICE QUESTION: Interface Segregation Principle
 *
 * Scenario: You are designing a smart home system.
 *
 * Your goal:
 * 1. Split device capabilities into small interfaces.
 * 2. Create a `SmartLight` that can turn on and off.
 * 3. Create a `SmartThermostat` that can adjust temperature.
 * 4. Create a `SmartSecurityCamera` that can record video.
 * 5. Make sure each device implements only the interfaces it actually needs.
 *
 * Hint:
 * Don't create one huge `SmartDevice` interface with methods that every device
 * is forced to implement.
 */

interface Switchable {
    void turnOn();
    void turnOff();
}

interface TemperatureAdjustable {
    void setTemperature(int temperature);
}

interface Recordable {
    void startRecording();
}

class SmartLight implements Switchable {
    @Override
    public void turnOn() {
        System.out.println("Smart light turned on");
    }

    @Override
    public void turnOff() {
        System.out.println("Smart light turned off");
    }
}

class SmartThermostat implements TemperatureAdjustable {
    @Override
    public void setTemperature(int temperature) {
        System.out.println("Smart thermostat set to " + temperature + " degrees");
    }
}

class SmartSecurityCamera implements Recordable {
    @Override
    public void startRecording() {
        System.out.println("Smart security camera started recording");
    }
}

public class ISPPractice {
    public static void main(String[] args) {
        System.out.println("--- ISP Practice ---");

        Switchable light = new SmartLight();
        light.turnOn();
        light.turnOff();

        TemperatureAdjustable thermostat = new SmartThermostat();
        thermostat.setTemperature(24);

        Recordable camera = new SmartSecurityCamera();
        camera.startRecording();

        System.out.println("Complete the TODOs to practice ISP.");
    }
}
