package javaStream.streamMethods;


//14. Salary Adjustment
//Increase the salary of all female employees in the “Marketing” department by 10% using Java 8 Streams.


import javaStream.Employee;
import javaStream.EmployeeDataGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class SalaryAdjustment {
    public static void main(String[] args){
        List<Employee> list = EmployeeDataGenerator.generateSampleData();

        List<Double> employeeList = list.stream()
                .filter(e -> ("Female".equalsIgnoreCase(e.getGender()) && "Marketing".equalsIgnoreCase(e.getDepartment())))
                .map(employee -> employee.getSalary() + (employee.getSalary()*10)/100)
                .collect(Collectors.toList());

        employeeList.forEach(e -> System.out.println(e));
    }
}
