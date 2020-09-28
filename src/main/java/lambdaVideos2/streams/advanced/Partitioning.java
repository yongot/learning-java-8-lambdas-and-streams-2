package lambdaVideos2.streams.advanced;

import lambdaVideos2.domain.Employee;
import lambdaVideos2.util.EmployeeUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.partitioningBy;

/**
 * @author yongot
 * @created 2020-09-28 : 9:38 PM
 */
public class Partitioning {
    List<Employee> employees = EmployeeUtil.createDetailedEmployees();

    private void partitionByExecutives() {
        Map<Boolean, List<Employee>> empPartition =
                employees.stream().collect(Collectors.partitioningBy(Employee::isExecutive));

        System.out.println("partitionByExecutives");
        System.out.println(empPartition);
    }

    private void partitioningAndGrouping() {
        System.out.println("partitioningAndGrouping");
        Map<Boolean, Map<String, List<Employee>>> execEmployees =
                employees.stream()
                        .collect(partitioningBy((Employee::isExecutive), Collectors.groupingBy(Employee::getDepartment)));

        for(Boolean b: execEmployees.keySet()){
            System.out.println(b+" --> "+execEmployees.get(b));
        }

    }

    private void partitioningMultiLevel() {
        System.out.println("partitioningMultiLevel");
        Map<Boolean, Map<Boolean, List<Employee>>> execEmployees =
                employees.stream()
                        .collect(partitioningBy((Employee::isExecutive), partitioningBy(Employee::isSenior)));

        for(Boolean b: execEmployees.keySet()){
            System.out.println(b+" ==> "+execEmployees.get(b));
        }

    }

    public static void main(String[] args) {
        new Partitioning().partitionByExecutives();
        new Partitioning().partitioningAndGrouping();
        new Partitioning().partitioningMultiLevel();
    }


}
