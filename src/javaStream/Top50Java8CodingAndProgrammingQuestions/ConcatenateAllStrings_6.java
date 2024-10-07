package javaStream.Top50Java8CodingAndProgrammingQuestions;


//Question 6: Write a Java 8 program to concatenate all strings in a list ?

import java.util.List;
import java.util.stream.Collectors;

public class ConcatenateAllStrings_6 {

    public static void main(String[] args){
        List<String> names = List.of("Hello"," ","World", "!");

        String concatNames = names.stream()
                .collect(Collectors.joining());

        System.out.println("Concatenate All names in single string : " + concatNames);
    }
}
