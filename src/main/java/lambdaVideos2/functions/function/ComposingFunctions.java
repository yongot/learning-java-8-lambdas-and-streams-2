package lambdaVideos2.functions.function;

import lambdaVideos2.domain.Address;
import lambdaVideos2.domain.Employee;
import lambdaVideos2.domain.Manager;

import java.util.function.Function;

/**
 * @author yongot
 * @created 2020-09-27 : 9:00 PM
 */
public class ComposingFunctions {

    Function<Employee, Manager> managerFinder = (emp) -> getManager(emp);
    Function<Manager, Employee> assistantFinder = (manager) -> getPersonalAssistant(manager);

    // andThen method
    private void testAndThen(Employee emp) {
        // find manager assistance from employee's manager
        Function<Employee, Employee> empManagerAssistantFinder = managerFinder.andThen(assistantFinder);

    }

    // compose method
    private void testCompose(Employee emp) {
        // managerFinder first -> assistantFinder
        Function<Employee, Employee> empFinder = assistantFinder.compose(managerFinder);
    }

    private void testIdentity(){
        Function<String, String> id = Function.identity();

        String result = id.apply("ID12EFL");

        System.out.println("Result: "+result);
    }
    private Employee getPersonalAssistant(Manager manager) {
        return manager.getPersonalAssistant();
    }

    private Manager getManager(Employee emp) {
        return emp.getManager();
    }

    public static void main(String[] args) {
        Employee emp = new Employee(1);
        new ComposingFunctions().testAndThen(emp);
        new ComposingFunctions().testCompose(emp);
        new ComposingFunctions().testIdentity();
    }

    private Address getAddress(Employee employee) {
        return employee.getAddress();
    }

    private Employee getEmployee(int id) {
        return new Employee(id);
    }

}
