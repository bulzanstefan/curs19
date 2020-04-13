package ro.fasttrackit.mvnbase.curs19;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MainPerson {
    public static void main(String[] args) {
        List<Person> persons = List.of(
                new Person("Ana", 33),
                new Person("Mircea", 52),
                new Person("Rafael", 43),
                new Person("Dragos", 21),
                new Person("Ecaterina", 65),
                new Person("Serban", 63),
                new Person("Albert", 13),
                new Person("Bogdan", 39)
        );

        //toate persoanele > 25 ani, ordonate alfabetic, cu * in fata, care au nume cu litera 'r'
        System.out.println(persons.stream()
                .filter(p -> p.getAge() > 25)
                .filter(p -> p.getName()
                        .toLowerCase()
                        .contains("r"))
                .map(p -> new Person("*" + p.getName(), p.getAge()))
                .sorted(Comparator.comparing(Person::getName))
                .collect(Collectors.toList()));
        System.out.println(persons);


    }
}
