package javaStream.streamMethods;


//15. Senior Employees
//Filter and retrieve all employees who are older than 30 years and have a salary greater than 30,000 using Java 8 Streams.
import javaStream.Employee;
import javaStream.EmployeeDataGenerator;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class SeniorEmployees {
    public static void main(String[] args){
        List<Employee> list = EmployeeDataGenerator.generateSampleData();
        List<Employee> employeeList = list.stream()
                .filter(e -> e.getAge() > 30 && e.getSalary() > 30000)
                .collect(Collectors.toList());

        employeeList.forEach(System.out::println);
    }
}
