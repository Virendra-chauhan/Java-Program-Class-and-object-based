package javaStream.streamMethods;


//Find the female employee with the highest salary in a list of `Employee` objects using Java 8 Streams.

import javaStream.Employee;
import javaStream.EmployeeDataGenerator;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FindingHighestSalary {
    public static void main(String[] args){
        List<Employee> list = EmployeeDataGenerator.generateSampleData();

//        List<Double> salaryList = list.stream()
//                .sorted(Comparator.comparing(employee -> employee.getSalary()))
//                .map(employee -> employee.getSalary())
//                .collect(Collectors.toList());

        Employee highestSalary = list.stream()
                        .filter(s -> s.getGender().equalsIgnoreCase("Female"))
                        .sorted(Comparator.comparing(Employee ::getSalary).reversed())
                        .findFirst().get();

        System.out.println("Highest Salary : "+highestSalary);

    }
}
