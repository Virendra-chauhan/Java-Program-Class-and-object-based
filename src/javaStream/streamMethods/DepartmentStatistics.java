package javaStream.streamMethods;


//
//17. Department Statistics
//Calculate the total salary, average salary, and number of female employees in each department using Java 8 Streams.

import javaStream.Employee;
import javaStream.EmployeeDataGenerator;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class DepartmentStatistics {
    public static void main(String[] args){
        List<Employee> list = EmployeeDataGenerator.generateSampleData();
        Map<String, DoubleSummaryStatistics> employeeMap = list.stream()
                .collect(Collectors.groupingBy(e -> e.getDepartment() , Collectors.summarizingDouble(emp -> emp.getSalary())));

//        System.out.println(employeeMap);

        Map<String, Long> femaleCountByDepartment = list.stream()
                .filter(e -> "Female".equalsIgnoreCase(e.getGender()))
                .collect(Collectors.groupingBy(emp -> emp.getDepartment() , Collectors.counting()));


        employeeMap.forEach((k,v)  -> {
            System.out.println("Department : " + k);
            System.out.println("Total Salary : " + v.getSum());
            System.out.println("Average : " + v.getAverage());
            System.out.println("Number of Female Employee : " + femaleCountByDepartment.getOrDefault(k, 0L));
        });
    }



}
