package javaStream.Top50Java8CodingAndProgrammingQuestions;


//Question 4: Write a Java 8 program to check if a list contains a specific element ?

import java.util.List;

public class ContainsSpecificElement_4 {
    public static void main(String[] args){
        List<Integer> list = List.of(10,11,25,13,45);
        int number = 45;
        boolean value = list.stream()
                .anyMatch(a -> a == number);

        if (value){
            System.out.println(number + " exists.");
        }else {
            System.out.println(number + " does not exists.");
        }
    }
}
