package inheritance;

/**
 * PRACTICE QUESTION: Favor Composition Over Inheritance
 * 
 * Objective: Refactor a bad inheritance design into a composition design.
 * 
 * Scenario: We are making a game. We have a `Character` class and some subclasses.
 * 
 * THE BAD DESIGN (Below): 
 * `Warrior` extends `Character` and overrides `attack()`.
 * `Mage` extends `Character` and overrides `attack()`.
 * If we add a new weapon, we have to create `WarriorWithBow`, etc.
 * 
 * YOUR TASK:
 * 1. Create an interface `Weapon` with a method `useWeapon()`.
 * 2. Create two concrete weapons: `Sword` (Prints "Swing sword!") and `Staff` (Prints "Cast spell!").
 * 3. Rewrite the `Hero` class to use COMPOSITION: a Hero should *HAVE A* `Weapon` as a private field.
 * 4. Add a `setWeapon(Weapon w)` method to Hero so they can change weapons at runtime!
 * 5. Test it in main.
 */

// --- IGNORE THIS BAD DESIGN. This is just for context ---
abstract class BadCharacter {
    abstract void attack();
}
class Warrior extends BadCharacter {
    void attack() { System.out.println("Swing sword!"); }
}
// --------------------------------------------------------

// 1. Create Weapon interface here

// 2. Create concrete weapons (Sword, Staff) here

// 3. Create Hero using composition
class Hero {
    // Add Weapon field
    // Add constructor
    
    public void attack() {
        // use the weapon!
    }
    
    // Add setWeapon() to change weapons at runtime!
}

public class CompositionPractice {
    public static void main(String[] args) {
        System.out.println("--- Composition Practice ---");
        
        // Test it here!
        // Weapon sword = new Sword();
        // Weapon staff = new Staff();
        // Hero arthur = new Hero(sword);
        // arthur.attack();
        // arthur.setWeapon(staff); // Arthur picked up a magic staff!
        // arthur.attack();
    }
}
