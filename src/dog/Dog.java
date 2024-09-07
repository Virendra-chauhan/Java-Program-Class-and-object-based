package dog;

import java.util.Scanner;

public class Dog {
    private String name;
    private String breed;

    Dog(String name, String breed){
        this.name = name;
        this.breed = breed;
    }

    public void display(){
        System.out.println("*************** Before Setter Method ***************");
        System.out.println("Dog name is "+ name + " and Breed " + breed);
    }

    public void setName(String name){
        this.name = name;
    }
    public void setBreed(String breed){
        this.breed = breed;
    }

    public void setValuesDisplay(){
        System.out.println("*************** After Setter Method ***************");
        System.out.println("Dog name is "+ name + " and Breed " + breed);
    }
}
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Dog name : ");
        String n = sc.nextLine();

        System.out.print("Enter Breed : ");
        String b = sc.nextLine();

        Dog dog = new Dog(n,b);
        dog.display();

        System.out.println("**************************************************");

        System.out.print("Enter Updated Dog name : ");
        String d = sc.nextLine();

        System.out.print("Enter Updated Breed : ");
        String o = sc.nextLine();

        dog.setName(d);
        dog.setBreed(o);
        dog.setValuesDisplay();
    }
}
