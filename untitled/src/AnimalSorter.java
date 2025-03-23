package org.example;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AnimalSorter {

    public static List<String> sortAnimalsByLengthDescending(List<String> animals) {


        return animals.stream().sorted((a1,a2)->a2.length()-a1.length())
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> animals = Arrays.asList("zebra", "lion", "tiger", "elephant", "giraffe");
        List<String> sortedAnimals = sortAnimalsByLengthDescending(animals);
        System.out.println(sortedAnimals);

        animals = Arrays.asList("cat","dog","animal-x","elephant","mouse");
        sortedAnimals = sortAnimalsByLengthDescending(animals);
        System.out.println(sortedAnimals);

        animals = Arrays.asList();
        sortedAnimals = sortAnimalsByLengthDescending(animals);
        System.out.println(sortedAnimals);

        animals = Arrays.asList("a","b","d","c","a");
        sortedAnimals = sortAnimalsByLengthDescending(animals);
        System.out.println(sortedAnimals);
    }
}