package javaStream.streamMethods;

// Create a list of names (Strings) from a list of `Employee` objects using Java 8 Streams.

import javaStream.Employee;
import javaStream.EmployeeDataGenerator;


import java.util.List;
import java.util.stream.Collectors;

public class ExtractingNames {
    public static void main(String[] args){
        List<Employee> list = EmployeeDataGenerator.generateSampleData();

        List<String> names = list.stream()
                .map(e -> e.getName())
                .collect(Collectors.toList());

//        System.out.println(names);

        names.forEach(System.out::println);
    }
}
