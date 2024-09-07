//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//// Employee class definition
//public class Employee {
//    // Attributes
//    private String name;
//    private String jobTitle;
//    private double salary;
//
//    // Constructor
//    public Employee(String name, String jobTitle, double salary) {
//        this.name = name;
//        this.jobTitle = jobTitle;
//        this.salary = salary;
//    }
//
//    // Method to calculate salary after a raise (percentage increase)
//    public void calculateSalary(double percentageIncrease) {
//        salary += salary * (percentageIncrease / 100);
//    }
//
//    // Method to update salary directly
//    public void updateSalary(double newSalary) {
//        this.salary = newSalary;
//    }
//
//    // Method to display employee details
//    public void displayEmployee() {
//        System.out.println("Name: " + name);
//        System.out.println("Job Title: " + jobTitle);
//        System.out.println("Salary: $" + salary);
//        System.out.println();
//    }
//}
//
//class EmployeeManagement {
//    public static void main(String[] args) {
//        // List to store Employee objects
//        List<Employee> employeeList = new ArrayList<>();
//        Scanner scanner = new Scanner(System.in);
//
//        // Input number of employees
//        System.out.print("Enter the number of employees: ");
//        int numberOfEmployees = scanner.nextInt();
//        scanner.nextLine(); // Consume newline
//
//        // Input employee data
//        for (int i = 0; i < numberOfEmployees; i++) {
//            System.out.println("Enter details for Employee " + (i + 1) + ":");
//
//            // Input name
//            System.out.print("Enter name: ");
//            String name = scanner.nextLine();
//
//            // Input job title
//            System.out.print("Enter job title: ");
//            String jobTitle = scanner.nextLine();
//
//            // Input salary
//            System.out.print("Enter salary: ");
//            double salary = scanner.nextDouble();
//            scanner.nextLine(); // Consume newline
//
//            // Create Employee object and add to the list
//            Employee employee = new Employee(name, jobTitle, salary);
//            employeeList.add(employee);
//        }
//
//        // Update salary for each employee
//        for (Employee employee : employeeList) {
//            System.out.println("Updating salary for " + employee.getClass().getSimpleName());
//
//            // Option to calculate a raise or directly update the salary
//            System.out.print("Enter percentage increase in salary: ");
//            double percentageIncrease = scanner.nextDouble();
//            employee.calculateSalary(percentageIncrease);
//
//            // Display updated employee details
//            employee.displayEmployee();
//        }
//
//        scanner.close();
//    }
//}

//class Parent {
//    public void Print(){
//        System.out.println("Parent");
//    }
//}
//class Child extends Parent {
//    public void Print() {
//        System.out.println("Child");
//    }
//}
//class A {
//
//    public static void main(String[] args) {
////        Parent x = new Parent();
////        Parent y = new Child();
//
//        Child z = new Child();
//
//    }
//}

class A{
    public A(){
        System.out.print("Hello ");
    }
}
class B extends A{
    B(){
        System.out.println("World !");
    }
}
class C extends B{
    C(){
        System.out.println(" Birendra Chauhan");
    }

}
class D{
    public static void main(String[] args){
        B c = new C();
    }
}