package module3.facade;

/**
 * MODULE 3.8: Facade Pattern
 *
 * Facade gives one simple entry point to a complex subsystem.
 */

class Amplifier {
    public void on() {
        System.out.println("Amplifier on");
    }
}

class Projector {
    public void on() {
        System.out.println("Projector on");
    }
}

class StreamingPlayer {
    public void playMovie(String movie) {
        System.out.println("Playing movie: " + movie);
    }
}

class HomeTheaterFacade {
    private final Amplifier amplifier = new Amplifier();
    private final Projector projector = new Projector();
    private final StreamingPlayer player = new StreamingPlayer();

    public void watchMovie(String movie) {
        amplifier.on();
        projector.on();
        player.playMovie(movie);
    }
}

public class FacadeLesson {
    public static void main(String[] args) {
        System.out.println("--- Facade Demo ---");

        HomeTheaterFacade theater = new HomeTheaterFacade();
        theater.watchMovie("Inception");
    }
}
