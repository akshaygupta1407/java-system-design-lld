package module3.builder;

/**
 * MODULE 3.5: Builder Pattern
 *
 * Builder helps create complex objects step by step.
 */

class Pizza {
    private final String size;
    private final boolean cheese;
    private final boolean pepperoni;
    private final boolean mushroom;

    private Pizza(Builder builder) {
        this.size = builder.size;
        this.cheese = builder.cheese;
        this.pepperoni = builder.pepperoni;
        this.mushroom = builder.mushroom;
    }

    public String getDescription() {
        return "Pizza[size=" + size + ", cheese=" + cheese + ", pepperoni=" + pepperoni + ", mushroom=" + mushroom + "]";
    }

    public static class Builder {
        private final String size;
        private boolean cheese;
        private boolean pepperoni;
        private boolean mushroom;

        public Builder(String size) {
            this.size = size;
        }

        public Builder addCheese() {
            this.cheese = true;
            return this;
        }

        public Builder addPepperoni() {
            this.pepperoni = true;
            return this;
        }

        public Builder addMushroom() {
            this.mushroom = true;
            return this;
        }

        public Pizza build() {
            return new Pizza(this);
        }
    }
}

public class BuilderLesson {
    public static void main(String[] args) {
        System.out.println("--- Builder Demo ---");

        Pizza pizza = new Pizza.Builder("Large")
                .addCheese()
                .addPepperoni()
                .build();

        System.out.println(pizza.getDescription());
    }
}
