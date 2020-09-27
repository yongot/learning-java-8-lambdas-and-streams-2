package lambdaVideos2.inheritance;

/**
 * @author yongot
 * @created 2020-09-27 : 5:25 PM
 */

interface Engine {
    default String model(int id) {
        return "DEFAULT ENGINE";
    }
}

interface Vehicle {
    default String model(int id) {
        return "DEFAULT VEHICLE";
    }
}

class Car implements Engine, Vehicle {
    String getModel(int id) {
        return model(id);
    }

    // re-implementing the method using rule 1 - class method always win
    @Override
    public String model(int id) {
//        return "DEFAULT CAR";
        // use the method from Engine using super
        return Engine.super.model(id);
    }
}



public class MultipleInheritance {
    public static void main(String ... args) {

    }
}
