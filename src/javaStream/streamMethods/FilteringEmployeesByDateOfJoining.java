package javaStream.streamMethods;

//
//21. Filtering Employees by Date of Joining
//Filter and print the employees who joined the company after a specific date.

import javaStream.Employee;
import javaStream.EmployeeDataGenerator;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FilteringEmployeesByDateOfJoining {
    public static void main(String[] args){
        List<Employee> list = EmployeeDataGenerator.generateSampleData();

        LocalDate specificDate = LocalDate.of(2011, 1, 1);

        List<Employee> emp = list.stream()
                .filter(str -> str.getDateOfJoining().isAfter(specificDate))
                .collect(Collectors.toList());
        System.out.println("Employees who joined after " + specificDate + " ----> ");
        emp.forEach(e -> {
            System.out.println("Employee Name : " + e.getName());
            System.out.println("Joining Date : " + e.getDateOfJoining());

            System.out.println("----------------------------------------------------------------------");
        });
    }
}
