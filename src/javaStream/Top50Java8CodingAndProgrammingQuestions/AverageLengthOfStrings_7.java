package javaStream.Top50Java8CodingAndProgrammingQuestions;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//Question 7: Write a Java 8 program to find the average length of strings in a list of strings?
public class AverageLengthOfStrings_7 {
    public static void main(String[] args){
        List<String> str = List.of("Hello", "world", "and", "my", "name", "virendra", "chauhan");

        double lengths = str.stream()
                .mapToInt(a -> a.length()) // Maps each string to its length
                .average()
                .orElse(0.0);

        System.out.println("Average Length of a string list : " + lengths);
    }
}
