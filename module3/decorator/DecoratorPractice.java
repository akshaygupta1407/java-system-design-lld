package module3.decorator;

/**
 * PRACTICE QUESTION: Decorator Pattern
 *
 * Scenario: You are building a pizza ordering system.
 *
 * Your goal:
 * 1. Create a `Pizza` interface.
 * 2. Implement a base pizza, such as `PlainPizza`.
 * 3. Add toppings using decorators:
 *    - `CheeseTopping`
 *    - `OliveTopping`
 *    - `MushroomTopping`
 * 4. Allow multiple toppings to be stacked on one pizza.
 *
 * Hint:
 * Do not create separate classes for every possible topping combination.
 */

interface Pizza {
    String getDescription();
    double getCost();
}

class PlainPizza implements Pizza {
    @Override
    public String getDescription() {
        return "Plain Pizza";
    }

    @Override
    public double getCost() {
        return 5.00; // Base cost for plain pizza
    }
}

abstract class ToppingDecorator implements Pizza {
    protected Pizza pizza;

    public ToppingDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription();
    }

    @Override
    public double getCost() {
        return pizza.getCost();
    }
}

class CheeseTopping extends ToppingDecorator {
    public CheeseTopping(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Cheese";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 1.50; // Cost for cheese topping
    }
}

class OliveTopping extends ToppingDecorator {
    public OliveTopping(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Olives";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 1.00; // Cost for olive topping
    }
}

class MushroomTopping extends ToppingDecorator {
    public MushroomTopping(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Mushrooms";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 1.25; // Cost for mushroom topping
    }
}

public class DecoratorPractice {
    public static void main(String[] args) {
        System.out.println("--- Decorator Practice ---");

        // TODO:
        // 1. Define the interface and base pizza.
        // 2. Create a decorator base class.
        // 3. Add multiple toppings by wrapping one object inside another.
        // 4. Print final description and cost.
        Pizza pizza = new PlainPizza();
        pizza = new CheeseTopping(pizza);
        pizza = new OliveTopping(pizza);
        pizza = new MushroomTopping(pizza);

        System.out.println("Description: " + pizza.getDescription());
        System.out.println("Cost: $" + String.format("%.2f", pizza.getCost()));


        System.out.println("Complete the TODOs to practice Decorator.");
    }
}
