package lambdaVideos2.streams.advanced;

import lambdaVideos2.domain.Employee;
import lambdaVideos2.util.EmployeeUtil;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

/**
 * @author yongot
 * @created 2020-09-28 : 9:33 PM
 */
public class Grouping {

    List<Employee> employees = EmployeeUtil.createDetailedEmployees();

    //grouping by department
    private void groupingByDepartment() {
        Map<String, List<Employee>> deptEmployees = employees.stream()
                .collect(groupingBy(e -> e.getDepartment()));
        System.out.println(deptEmployees);
    }

    //grouping by city
    private void groupingByCity() {
        Map<String, List<Employee>> cityEmployees = employees.stream()
                .collect(groupingBy(Employee::getCity));
        System.out.println(cityEmployees);
    }

    // multi level grouping by
    private void groupingByDepartmentAndExec() {
        Map<String, Map<String, List<Employee>>> deptAndCityEmployees =
                employees.stream()
                        // nesting the group method
                        .collect(groupingBy((Employee::getDepartment), groupingBy(Employee::getCity)));
        System.out.println(deptAndCityEmployees);
    }

    // Grouping by list
    private void groupingByList() {
    }

    // Grouping by count
    private void groupingByCount() {
    }

    public static void main(String[] args) {
        new Grouping().groupingByDepartment();
        new Grouping().groupingByCity();
        new Grouping().groupingByDepartmentAndExec();
        new Grouping().groupingByList();
        new Grouping().groupingByCount();
    }

}
