package javaStream.streamMethods;



//18. Employee by Salary Range
//Group employees into different salary ranges (e.g., 0-10k, 10k-20k, 20k-30k, 30k-50k) using Java 8 Streams.

import javaStream.Employee;
import javaStream.EmployeeDataGenerator;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeBySalaryRange {
    public static void main(String[] args){
        List<Employee> list =EmployeeDataGenerator.generateSampleData();
        Map<String , List<Employee>> empMap = list.stream()
                .collect(Collectors.groupingBy(e -> getSalaryRange(e.getSalary())));

        empMap.forEach((range, empSalary) -> {
            System.out.println("Salary : " + range);
            empSalary.forEach(emp -> {
                System.out.println("Employee Details : " + emp);
            });
            System.out.println("------------------------------------------------------");
        });
    }

    private static String getSalaryRange(double salary){
        if (salary < 10000){
            return "0-10k";
        } else if (salary < 20000) {
            return "10k-20k";
        } else if (salary < 30000) {
            return "20k-30k";
        } else if (salary < 50000) {
            return "30k-50k";
        }else {
            return "50k+";
        }
    }
}
