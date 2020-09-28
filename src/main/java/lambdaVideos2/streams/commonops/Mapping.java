package lambdaVideos2.streams.commonops;

import lambdaVideos2.domain.Employee;
import lambdaVideos2.util.EmployeeUtil;

import java.util.List;
import java.util.stream.Stream;

/**
 * @author yongot
 * @created 2020-09-28 : 8:54 PM
 */
public class Mapping {

    List<Employee> employees = EmployeeUtil.createEmployees();

    private void testMapping() {
        Stream<String> empStream = employees.stream()
                .map(Employee::getName)
                .map(String::toUpperCase);

        empStream.forEach(System.out::println);
    }

    public static void main(String ... args) {
        new Mapping().testMapping();
    }
}
