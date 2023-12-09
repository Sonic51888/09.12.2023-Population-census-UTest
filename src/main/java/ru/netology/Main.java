package ru.netology;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }
        kidsCounter(persons);
        recruitSort(persons);
        workersSort(persons);


    }

    public static int kidsCounter(Collection<Person> persons) {
        int kidsCounter = (int) persons.stream()
                .filter(person -> person.getAge() < 18)
                .count();
        return kidsCounter;
    }

    public static List<String> recruitSort(Collection<Person> persons) {
        List<String> recruit = persons.stream()
                .filter(person -> (person.getAge() >= 18 && person.getAge() <= 27))
                .filter(person -> person.getSex().equals(Sex.MAN))
                .map(person -> person.getFamily())
                .collect(Collectors.toList());
        return recruit;
    }

    public static List<Person> workersSort(Collection<Person> persons) {
        List<Person> workers = persons.stream()
                .filter(person -> person.getEducation() == Education.HIGHER)
                .filter(person -> person.getAge() >= 18)
                .filter(person -> person.getSex() == Sex.WOMAN ? person.getAge() <= 60 : person.getAge() <= 65)
                .collect(Collectors.toList());
        return workers;
    }
}