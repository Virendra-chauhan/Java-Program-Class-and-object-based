package javaStream.streamMethods;


//16. Departmental Leaders
//Find the employee with the highest salary in each department using Java 8 Streams.

import javaStream.Employee;
import javaStream.EmployeeDataGenerator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DepartmentalLeaders {
    public static void main(String[] args){
        List<Employee> list = EmployeeDataGenerator.generateSampleData();
        Map<String,Employee> employeeList = list.stream()
                .collect(Collectors.toMap(
                        e -> e.getDepartment(),
                        a -> a,
                        (a1, a2) -> a1.getSalary() >= a2.getSalary() ? a1 : a2
                ));
        employeeList.forEach((k,v) -> {
            System.out.println("Department : " + k);
            System.out.println("Employee Details : " + v);
        });
    }
}
