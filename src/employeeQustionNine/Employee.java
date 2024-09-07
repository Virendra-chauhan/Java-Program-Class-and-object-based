package employeeQustionNine;

import javax.naming.Name;
import java.time.LocalDate;
import java.time.Period;
import java.time.Year;
import java.util.Scanner;

public class Employee {
    private String name;
    private double salary;
    private LocalDate hireDate;

    Employee(String name, double salary, LocalDate hireDate){
        this.name = name;
        this.salary = salary;
        this.hireDate = hireDate;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setHireDate(LocalDate hireDate){
        this.hireDate = hireDate;
    }

    public LocalDate getHireDate(){
        return hireDate;
    }


    public void setSalary(double salary){
        this.salary = salary;
    }

    public double getSalary(){
        return salary;
    }

    public int calculateYearOfService(){
            return Period.between(hireDate, LocalDate.now()).getYears();
    }

    public void display(){
        System.out.println("----------------------------------------------------------------------------------");
        System.out.printf("| %-16s | %-17s | %-19s | %-5s %n", "Name ", "Salary ", "Hire Date ", "Total Service Year " );

        System.out.println("----------------------------------------------------------------------------------");
        System.out.printf("| %-16s | %-17s | %-19s | %-5s %n", getName(), getSalary(), getHireDate(), calculateYearOfService());
    }
}

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Employee Name : ");
        String name = sc.nextLine();

        System.out.print("Enter Employee salary : ");
        double salary = sc.nextDouble();

        System.out.print("Enter Hire Date (Ex -1919-02-20 ) : ");
        LocalDate date = LocalDate.parse(sc.next());

        Employee employee= new Employee(name, salary,date);

        employee.display();

    }
}


