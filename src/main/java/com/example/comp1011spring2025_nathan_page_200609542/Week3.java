package com.example.comp1011spring2025_nathan_page_200609542;
import java.util.ArrayList;
import java.util.stream.IntStream;

public class Week3 {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum += i;
        }
        System.out.println("The sum of all numbers is: " + sum);

        int sum1 = IntStream.range(0, 11).sum();
        System.out.println("The sum of all numbers is: " + sum1);

        ArrayList<String> names = new ArrayList<>();
        names.add("John");
        names.add("Jane");
        names.add("Bob");
        names.add("Mary");
        names.add("Jack");
        names.add("Smith");
        names.add("Alex");
        names.add("Bob");
        names.add("Mary");

        names.stream().filter(name -> name.contains("o")).map(String::toUpperCase)
    //.forEach(s-> System.out.println(s));
                .forEach(System.out::println);
    }
}
