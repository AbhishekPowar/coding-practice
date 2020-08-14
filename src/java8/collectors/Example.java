package java8.collectors;

import java8.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Example {
    public static void main(String[] args) {
        List<Employee> employees;

        Employee e1 = new Employee(1, "Ashif", 25);
        Employee e2 = new Employee(2, "Swapnil", 28);
        Employee e3 = new Employee(3, "Nikita", 25);

        employees = Arrays.asList(e1, e2, e3);

//        Map<Integer, Long> e = employees.stream()
//                .filter(employee -> employee.getAge() < 28)
//                .collect(
//                        Collectors.groupingBy(Employee::getAge, Collectors.counting())
//                );

        employees.sort(Comparator.comparing(Employee::getAge));
        System.out.println(employees);
    }
}
