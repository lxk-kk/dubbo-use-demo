package design_pattern.factory.simple_factory;

import design_pattern.factory.Animal;
import design_pattern.factory.Bird;
import design_pattern.factory.Dog;

public class SimpleFactory {
    public Animal createAnimal(String name) {
        if ("GIRD".equals(name)) {
            return new Bird();
        }
        if ("DOG".equals(name)) {
            return new Dog();
        }
        return null;
    }
}
