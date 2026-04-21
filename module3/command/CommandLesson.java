package module3.command;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * MODULE 3.9: Command Pattern
 *
 * Command turns actions into objects.
 */

interface Command {
    void execute();
}

class Light {
    public void on() {
        System.out.println("Light turned on");
    }

    public void off() {
        System.out.println("Light turned off");
    }
}

class LightOnCommand implements Command {
    private final Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}

class LightOffCommand implements Command {
    private final Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }
}

class RemoteControl {
    private final Deque<Command> history = new ArrayDeque<>();

    public void pressButton(Command command) {
        command.execute();
        history.push(command);
    }
}

public class CommandLesson {
    public static void main(String[] args) {
        System.out.println("--- Command Demo ---");

        Light light = new Light();
        RemoteControl remote = new RemoteControl();

        remote.pressButton(new LightOnCommand(light));
        remote.pressButton(new LightOffCommand(light));
    }
}
