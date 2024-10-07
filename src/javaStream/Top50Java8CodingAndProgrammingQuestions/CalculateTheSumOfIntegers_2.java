package javaStream.Top50Java8CodingAndProgrammingQuestions;


import java.util.List;
import java.util.Optional;

//Question 2: Write a Java 8 program to calculate the sum of integers in a list ?
public class CalculateTheSumOfIntegers_2 {
    public static void main(String[] args){
        List<Integer> list = List.of(1,2,3,4,5,6,7,8,9,10);

        int sum = list.stream()
                .reduce(0, (a,b) -> a+b);

        System.out.println("Sum : "+sum);
    }
}
