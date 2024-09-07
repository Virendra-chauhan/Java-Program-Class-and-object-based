package employee;

import java.util.ArrayList;
import java.util.Scanner;

public class Employee {
    private String name;
    private String title;
    private double salary;

    Employee(String name, String title, double salary){
        this.name = name;
        this.title = title;
        this.salary = salary;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
        return title;
    }


    public void setSalary(double salary){
        this.salary = salary;
    }

    public double getSalary(){
        return salary;
    }

    public void calculateSalary(double per){
        double updatedSalary = ( ( salary * per ) / 100 ) + salary;
        setSalary(updatedSalary);
    }

}

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

            System.out.print("Enter Employee Name : ");
            String name = sc.nextLine();

            System.out.print("Enter Employee Job Title : ");
            String title = sc.nextLine();

            System.out.print("Enter Employee salary : ");
            double salary = sc.nextDouble();

            Employee employee = new Employee(name, title, salary);
        System.out.println("*********************** Employee Detail ***********************");
        System.out.println("Employee Name : " + employee.getName() + " , Job Title : " + employee.getTitle() + " , Salary : " + employee.getSalary());

        System.out.print("Enter Hike Percentage : ");
        double per = sc.nextDouble();
        employee.calculateSalary(per);


        System.out.println("*********************** After Salary Updated Employee Detail ***********************");
        System.out.println("Employee Name : " + employee.getName() + " , Job Title : " + employee.getTitle() + " , Salary : " + employee.getSalary());


    }
}

