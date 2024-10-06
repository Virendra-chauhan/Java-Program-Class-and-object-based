package javaStream.streamMethods;

//Create a list of employees’ names who have a salary greater than 20,000 and are in the “Sales” department using Java 8 Streams.

import javaStream.Employee;
import javaStream.EmployeeDataGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class ConditionalMapping {
    public static void main(String[] args){
        List<Employee> list = EmployeeDataGenerator.generateSampleData();

        List<String> employeeList = list.stream()
                .filter(e -> e.getSalary() > 20000 && e.getDepartment().equalsIgnoreCase("sales"))
                .map(employee -> employee.toString())
                .collect(Collectors.toList());

        System.out.println(employeeList);
    }

}
