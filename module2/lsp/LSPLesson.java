package module2.lsp;

/**
 * MODULE 2.3: Liskov Substitution Principle (LSP)
 *
 * LSP says that a child class should be usable anywhere its parent class is
 * expected, without surprising behavior or broken logic.
 */

// --- BAD DESIGN: A parent contract that not all children can honor ---
abstract class BirdBad {
    public void fly() {
        System.out.println("Bird is flying...");
    }
}

class SparrowBad extends BirdBad {
}

class PenguinBad extends BirdBad {
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Penguins cannot fly");
    }
}

// --- GOOD DESIGN: Separate behaviors so subclasses can truly substitute ---
interface Flyable {
    void fly();
}

class Sparrow implements Flyable {
    @Override
    public void fly() {
        System.out.println("Sparrow is flying...");
    }
}

class Eagle implements Flyable {
    @Override
    public void fly() {
        System.out.println("Eagle is flying high...");
    }
}

class Penguin {
    public void swim() {
        System.out.println("Penguin is swimming...");
    }
}

class BirdShow {
    public void demonstrateFlight(Flyable bird) {
        bird.fly();
    }
}

public class LSPLesson {
    public static void main(String[] args) {
        System.out.println("--- LSP Demo ---");

        BirdShow show = new BirdShow();
        show.demonstrateFlight(new Sparrow());
        show.demonstrateFlight(new Eagle());

        Penguin penguin = new Penguin();
        penguin.swim();

        System.out.println();
        System.out.println("Notice how we do not force penguins into a flying contract.");
        System.out.println("That keeps the design honest and substitutable.");
    }
}
