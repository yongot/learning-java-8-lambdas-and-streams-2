package lambdaVideos2.functions.biconsumer;

import lambdaVideos2.domain.Employee;

import java.util.function.BiConsumer;

/**
 * @author yongot
 * @created 2020-09-27 : 9:36 PM
 */
public class BiConsumerFunction {

    BiConsumer<Employee, Integer> empBonusConsumer =
            (emp, bonus) -> System.out.printf("Employee %s is set of %d pct of bonus: ", emp, bonus);

    BiConsumer<Employee, Integer> empSalaryConsumer =
            (emp, salaryHike) -> System.out.printf("Employee %s is receiving %d hike in salary: ", emp, salaryHike);

    BiConsumer<Employee, Integer> empBonusAndHikeConsumer = empBonusConsumer.andThen(empSalaryConsumer);

    private void testBiConsumer(Employee emp, Integer bonus, Integer salaryHike) {
        empBonusConsumer.accept(emp, bonus);

    }

    public static void main(String ... args) {
        Employee emp = new Employee(10);
        int bonus = 5;
        int salaryHike = 15;
        new BiConsumerFunction().testBiConsumer(emp, bonus, salaryHike);
    }
}
