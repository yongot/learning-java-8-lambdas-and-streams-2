package lambdaVideos2.streams.commonops;

import lambdaVideos2.domain.Employee;
import lambdaVideos2.util.EmployeeUtil;

import java.util.List;
import java.util.stream.Stream;

/**
 * @author yongot
 * @created 2020-09-28 : 8:48 PM
 */
public class Filtering {
    List<Employee> employees = EmployeeUtil.createEmployees();

    private void testFiltering() {
        Stream<Employee> empStream = employees.stream()
                .filter(Employee::isSenior)
                .filter(e -> e.getDepartment().equals("Marketing"))
                .filter(Employee::isExecutive);
        empStream.forEach(System.out::println);
    }

    public static void main(String ... args) {
        new Filtering().testFiltering();
    }
}
