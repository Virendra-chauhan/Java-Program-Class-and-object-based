package javaStream.streamMethods;

//Calculate the average salary for all employees and print it.

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;
import javaStream.Employee;
import javaStream.EmployeeDataGenerator;

public class CalculatingAverageSalary {
    public static void main(String[] args){
        List<Employee> list = EmployeeDataGenerator.generateSampleData();

        double averageSalary = list.stream()
                .mapToDouble(employee -> employee.getSalary())
                .average()
                .getAsDouble();

        System.out.println("Average Salary of all Employees : "+averageSalary);

    }
}
