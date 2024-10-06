package javaStream.streamMethods;


//13. Department Averaging
//Calculate the average salary for employees in each department using Java 8 Streams.

import javaStream.Employee;
import javaStream.EmployeeDataGenerator;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DepartmentAveraging {
    public static void main(String[] args){
        List<Employee> list = EmployeeDataGenerator.generateSampleData();

//        double averageSalary = list.stream()
//                .filter(employee -> "HR".equalsIgnoreCase(employee.getDepartment()))
//                .mapToDouble(e -> e.getSalary())
//                .average()
//                .getAsDouble();

       Map<String , Double> averageSalary = list.stream()
               .collect(Collectors.groupingBy(employee -> employee.getDepartment(), Collectors.averagingDouble(em -> em.getSalary())));

        averageSalary.forEach((k,v) -> {
            System.out.println("Average Salary of " +k +" Department : " + v);
        });
    }


}
