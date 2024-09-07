package circle;

import java.util.Scanner;

public class Circle {
    private double radius;
    private double area;
    private double perimeter;

    Circle(double radius){
        this.radius = radius;
    }

    public void setRadius(double radius){
        this.radius = radius;
    }

    public double getRadius(){
        return radius;
    }
    public void area(){
        area = 3.14*getRadius()*getRadius();
    }

    public void perimeter(){
        area();
        perimeter = 2 * 3.14 * getRadius();

    }

    public void display(){
        perimeter();
        System.out.println("Area of Circle : " + area);
        System.out.println("Perimeter of Circle : " + perimeter);
    }

}
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Radius : ");
        double r = sc.nextDouble();

        Circle circle = new Circle(r);
        circle.display();
    }
}
