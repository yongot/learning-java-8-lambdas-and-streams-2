package lambdaVideos2.functions.primitives;

import lambdaVideos2.domain.Employee;

import java.util.function.*;

/**
 * @author yongot
 * @created 2020-09-27 : 9:06 PM
 */
// Functions for primitive - "int", "long", "double"
public class PrimitiveFunctions {

    Predicate<Integer> evenNumberPredicate = x -> x%2 == 0;

    // predicate
    IntPredicate evenNumberPredicate2 = x -> x%2 == 0;
    DoublePredicate doublePredicate2 = x -> x > 10;
    LongPredicate longPredicate;
    // consumer
    IntSupplier intSupplier;

    // supplier

    // functions
    Function<Integer, Employee> empFunction = null;
    // int as input
    IntFunction<Employee> empFunction2 = null;
    DoubleFunction<Employee> doubleEmpFunction = null;

    // double and int
    Function<Double, Integer> doubleToIntegerFunction = null;
    DoubleFunction<Integer> doubleToIntegerFunction2 = null;

    // primitive to primitive
    DoubleToIntFunction doubleToIntegerFunction3 = null;

    private void testPredicate(int i) {
        // boxing is heavy
        boolean flag = evenNumberPredicate2.test(i);
        System.out.println("even Number? " + flag);
    }
    public static void main (String ... args) {
        int evenNum = 20;
        new PrimitiveFunctions().testPredicate(evenNum);
    }
}
