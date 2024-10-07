package javaStream.Top50Java8CodingAndProgrammingQuestions;

//Question 1: Write a Java 8 program to filter even numbers from a list ?

import java.util.List;
import java.util.stream.Collectors;

public class FilterEvenNumbers_1 {
    public static void main(String[] args){
        List<Integer> list = List.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15);
        List<Integer> evenNumber = list.stream()
                .filter(no -> no%2 == 0)
                .collect(Collectors.toList());
        System.out.println("Original List : " + list);
        System.out.println("Even Numbers List : " + evenNumber);
    }
}
