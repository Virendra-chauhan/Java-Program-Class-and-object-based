package javaStream.streamMethods;

//19. Name Concatenation
//Concatenate the names of all employees in the list into a single comma-separated string using Java 8 Streams.

import javaStream.Employee;
import javaStream.EmployeeDataGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class NameConcatenation {
    public static void main(String[] args){
        List<Employee> list = EmployeeDataGenerator.generateSampleData();

        String str = list.stream()
                .map(emp -> emp.getName())
                .collect(Collectors.joining(", "));
        System.out.println("Concatenated Names : " + str);
    }
}
