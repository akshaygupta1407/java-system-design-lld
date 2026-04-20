package module3.strategy;

/**
 * PRACTICE QUESTION: Strategy Pattern
 *
 * Scenario: You are building a route planning system for a map app.
 *
 * Your goal:
 * 1. Create a `RouteStrategy` interface.
 * 2. Implement three route types:
 *    - `FastestRoute`
 *    - `ShortestRoute`
 *    - `ScenicRoute`
 * 3. Create a `RoutePlanner` that uses a strategy to plan the route.
 * 4. Allow the route strategy to be swapped at runtime.
 *
 * Hint:
 * Avoid putting all route logic inside one big `if-else` block.
 */

interface RouteStrategy {
    void planRoute(String start, String end);
}

class FastestRoute implements RouteStrategy {
    @Override
    public void planRoute(String start, String end) {
        System.out.println("Planning fastest route from " + start + " to " + end);
    }
}

class ShortestRoute implements RouteStrategy {
    @Override
    public void planRoute(String start, String end) {
        System.out.println("Planning shortest route from " + start + " to " + end);
    }
}

class ScenicRoute implements RouteStrategy {
    @Override
    public void planRoute(String start, String end) {
        System.out.println("Planning scenic route from " + start + " to " + end);
    }
}

class RoutePlanner {
    private RouteStrategy routeStrategy;

    public RoutePlanner(RouteStrategy routeStrategy) {
        this.routeStrategy = routeStrategy;
    }

    public void setRouteStrategy(RouteStrategy routeStrategy) {
        this.routeStrategy = routeStrategy;
    }

    public void planRoute(String start, String end) {
        routeStrategy.planRoute(start, end);
    }
}

public class StrategyPractice {
    public static void main(String[] args) {
        System.out.println("--- Strategy Practice ---");

        // TODO:
        // 1. Define the interface and concrete route strategies.
        // 2. Create RoutePlanner using composition.
        // 3. Plan routes using different strategies.
        // 4. Swap strategies at runtime and test again.
        RoutePlanner routePlanner = new RoutePlanner(new FastestRoute());
        routePlanner.planRoute("A", "B");

        routePlanner.setRouteStrategy(new ShortestRoute());
        routePlanner.planRoute("A", "B");

        routePlanner.setRouteStrategy(new ScenicRoute());
        routePlanner.planRoute("A", "B");

        System.out.println("Complete the TODOs to practice Strategy.");
    }
}
