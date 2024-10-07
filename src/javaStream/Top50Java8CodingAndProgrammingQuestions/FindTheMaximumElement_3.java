package javaStream.Top50Java8CodingAndProgrammingQuestions;


//Question 3: Write a Java 8 program to find the maximum element from a list ?

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class FindTheMaximumElement_3 {
    public static void main(String[] args){
        List<Integer> list = List.of(12,15,4,1,11,13);

        Optional<Integer> max = list.stream()
                .max((a,b) -> a.compareTo(b));

        System.out.println("Maximum Value : "+max.orElse(Integer.MAX_VALUE));
    }



}
