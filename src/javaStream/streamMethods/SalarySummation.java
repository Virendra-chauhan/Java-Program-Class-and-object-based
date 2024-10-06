package javaStream.streamMethods;

import javaStream.Employee;
import javaStream.EmployeeDataGenerator;

import java.util.List;
import java.util.stream.Collectors;

// Calculate the total salary of all female employees in a list of `Employee` objects using Java 8 Streams.

public class SalarySummation {
    public static void main(String[] args){
        List<Employee> list = EmployeeDataGenerator.generateSampleData();

        Double totalSalary = list.stream()
                .filter(employee -> "Female".equalsIgnoreCase(employee.getGender()))
                .map(salary -> salary.getSalary())
                .reduce(0.0,(a,b) -> a+b);


        System.out.println(totalSalary);


    }
}
