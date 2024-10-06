package javaStream.streamMethods;

//20. Printing Employment Duration
//Determine and print the number of years each employee has been with the company using the ChronoUnit class.

import javaStream.Employee;
import javaStream.EmployeeDataGenerator;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PrintingEmploymentDuration {
    public static void main(String[] args){
        List<Employee> list = EmployeeDataGenerator.generateSampleData();

        Map<Long , List<Employee>> year = list.stream()
                .collect(Collectors.groupingBy(employee -> ChronoUnit.YEARS.between(employee.getDateOfJoining(), LocalDate.now())));

        year.forEach((k,v) -> {
            v.forEach(a -> {
                System.out.println(a.getName() + " has been with the company for " + k + " years.");
            });

            System.out.println("-------------------------------------------------------------");

        });
    }
}
