package javaStream.Top50Java8CodingAndProgrammingQuestions;

import java.util.List;

//Question 5: Write a Java 8 program to find the sum of all even numbers in a list of integers ?
public class SumOfAllEvenNumbers_5 {
    public static void main(String[] args){
        List<Integer> list = List.of(1,2,3,4,5,6,7,8,9,10);
        int sum = list.stream()
                .filter(a -> a%2 == 0)
                .reduce(0, (a,b) -> a+b);

        System.out.println("All Even Number Sum : " + sum);

    }


}
