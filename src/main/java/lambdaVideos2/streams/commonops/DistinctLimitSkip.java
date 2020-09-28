package lambdaVideos2.streams.commonops;

import lambdaVideos2.domain.Employee;
import lambdaVideos2.util.EmployeeUtil;

import java.util.List;
import java.util.stream.Stream;

/**
 * @author yongot
 * @created 2020-09-28 : 9:02 PM
 */
public class DistinctLimitSkip {
    List<Employee> employees = EmployeeUtil.createEmployees();

    private void testDistinct(){
        Stream<String> stream = employees.stream()
                .map(Employee::getName)
                .distinct();
        stream.forEach(System.out::println);
    }

    private void testLimit() {
        Stream<String> stream = employees.stream()
                .map(Employee::getName)
                .limit(3);
        stream.forEach(System.out::println);
    }

    private void testSkip(){
        Stream<String> stream = employees.stream()
                .skip(1)
                .map(Employee::getName);
        stream.forEach(System.out::println);
    }

    public static void main(String ... args) {
        // new DistinctLimitSkip().testDistinct();
        // new DistinctLimitSkip().testLimit();
        new DistinctLimitSkip().testSkip();
    }
}
