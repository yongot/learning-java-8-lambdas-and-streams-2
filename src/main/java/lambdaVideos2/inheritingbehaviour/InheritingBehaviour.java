package lambdaVideos2.inheritingbehaviour;

/**
 * @author yongot
 * @created 2020-09-27 : 5:21 PM
 */

// inheriting behavior from multiple interfaces
interface Engine {
    default String make() {
        return "DEFAULT MAKE";
    }
}

interface Vehicle {
    default String model() {
        return "DEFAULT MODEL";
    }
}

class Car implements Engine, Vehicle {
    String makeAndModel() {
        return Engine.super.make() +
                Vehicle.super.model();
    }
}
public class InheritingBehaviour {
    public static void main(String ... args) {

    }
}
