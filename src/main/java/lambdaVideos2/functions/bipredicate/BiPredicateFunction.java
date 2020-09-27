package lambdaVideos2.functions.bipredicate;

import lambdaVideos2.domain.Employee;
import lambdaVideos2.domain.Manager;

import java.util.function.BiPredicate;

/**
 * @author yongot
 * @created 2020-09-27 : 9:13 PM
 */
public class BiPredicateFunction {

    // TWO argument functions: BiPredicate
    BiPredicate<Employee, Manager> empManagerPredicate = (emp, manager) -> emp.getManager().equals(manager)? true: false;

    BiPredicate<Employee, Manager> managerHasAssistantPredicate = (emp, manager) -> manager.getPersonalAssistant().equals(emp)? true: false;

    BiPredicate<Employee, Manager> isPA = empManagerPredicate.and(managerHasAssistantPredicate);

    private void testBiPredicate(Employee emp, Manager manager) {
        boolean isManager = empManagerPredicate.test(emp, manager);
        System.out.println("isManager?: " + isManager);
    }

    private void testNegate(Employee emp, Manager manager) {

    }

    private void testAnd(Employee emp, Manager manager) {

    }

    private void testOr(Employee emp, Manager manager) {
    }

    public static void main(String[] args) {
        Employee emp = new Employee(99);
        Manager manager = new Manager();
        emp.setManager(manager);
        // this returns true because emp's manager is set
        new BiPredicateFunction().testBiPredicate(emp, manager);

        // this returns false, because manager is different
        Manager manager2 = new Manager();
        // new BiPredicateFunction().testBiPredicate(emp, manager2);

        // testNegate
        // new BiPredicateFunction().testNegate(emp, manager);

        // testAnd
        // new BiPredicateFunction().testAnd(emp, manager);

    }

}
