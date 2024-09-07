package rectangle;

import java.util.Scanner;

public class Rectangle {
    private double width;
    private double height;
    private double area;
    private double perimeter;

    Rectangle(double width, double height){
        this.width = width;
        this.height = height;
    }

    public void area(){
        area = width * height;
    }

    public void perimeter(){
        area();
        perimeter = 2 * ( width + height );

    }

    public void display(){
        perimeter();
        System.out.println("Area of Rectangle : " + area);
        System.out.println("Perimeter of Rectangle : " + perimeter);
    }

}
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Width : ");
        double n = sc.nextDouble();

        System.out.print("Enter Height : ");
        double b = sc.nextDouble();

        Rectangle rectangle = new Rectangle(n,b);
        rectangle.display();
    }
}
