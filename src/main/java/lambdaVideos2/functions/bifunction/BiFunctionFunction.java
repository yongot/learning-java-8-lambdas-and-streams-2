package lambdaVideos2.functions.bifunction;

import lambdaVideos2.domain.Employee;
import lambdaVideos2.domain.Manager;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author yongot
 * @created 2020-09-27 : 9:41 PM
 */
public class BiFunctionFunction {

    BiFunction<Employee, Manager, Employee> empManagerBiFunction = (emp, manager) -> emp.getManager().getPersonalAssistant();

    Function<Employee, Employee> empManagerFunction = (emp) -> emp.getManager().getPersonalAssistant();

    private void testBiFunction(Employee emp, Manager manager) {
        Employee employee = empManagerBiFunction.apply(emp, manager);
        System.out.println("Employee: " + employee);
    }

    private void testAndThen(Employee emp, Manager manager) {
        BiFunction<Employee, Manager, Employee> perAssistant = empManagerBiFunction.andThen(empManagerFunction);
        Employee pa = perAssistant.apply(emp, manager);
        System.out.println("PA: " + pa);
    }

    public static void main(String ... args) {
        Employee emp = new Employee(99);
        Manager manager = new Manager();
        emp.setManager(manager);
        manager.setPersonalAssistant(emp);
        new BiFunctionFunction().testBiFunction(emp, manager);
        new BiFunctionFunction().testAndThen(emp, manager);
    }
}
