package trafficlight;

import java.util.Scanner;

public class TrafficLight {
    private String color;
    private int duration;

    TrafficLight(String color, int duration){
        this.color = color;
        this.duration = duration;
    }

    public String getColor(){
        return this.color;
    }
    public void setColor(String color){
        this.color = color;
    }

    public int getDuration(){
        return this.duration;
    }
    public void setDuration(int duration){
        this.duration = duration;
    }

    public void changeColor(){
        if (getColor().equalsIgnoreCase("red")){
            System.out.println("Light is Red please wait for " + getDuration() + " sec.");
            try {
                Thread.sleep(1000 * (long)getDuration());
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            System.out.println("Green Light Go...");
        } else if (getColor().equalsIgnoreCase("green")){
            System.out.println("Light is green Go....");
            try {
                Thread.sleep(1000 * (long)getDuration());
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            System.out.println("Now , Light is red please Stop.");
        } else if (getColor().equalsIgnoreCase("yellow")) {
            System.out.println("Light is yellow please wait " + getDuration() + " sec.");
            try {
                Thread.sleep(1000 * (long) getDuration());
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            System.out.println("Now , Light is red please Stop.");
        }else {
            System.out.println("Enter right input...");
        }
    }
}

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter color : ");
        String c = sc.next();

        System.out.print("Enter duration : ");
        int d = sc.nextInt();

        TrafficLight tf = new TrafficLight(c,d);
        tf.changeColor();
    }
}
