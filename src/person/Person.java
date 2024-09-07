package person;

import java.util.Scanner;

public class Person {
    private String name;
    private int age;

    Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void display(){
        System.out.println("My name is "+ name + " and I am " + age + " year old.");
    }
}
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Your name : ");
        String n = sc.nextLine();

        System.out.print("Enter Your age : ");
        int a = sc.nextInt();

        Person person = new Person(n,a);
        person.display();
    }
}
