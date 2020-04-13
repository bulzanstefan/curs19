package ro.fasttrackit.mvnbase.curs19;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class MainStream {
    public static void main(String[] args) {
        streamOnNames();
    }

    private static void streamOnNames() {
        List<String> names = List.of("Dragos", "Darius", "Ana", "Marius", "Tudor", "Carmen", "Catherine");

        //obtineti lista de nume mai lungi de 3 caractere cu toate literele mari
        List<String> upperNames = names.stream()
                .filter(name -> name.length() > 3)
                .map(String::toUpperCase)
                .collect(toList());
        System.out.println(upperNames);

        //obtineti lista de nume mai lungi de 3 caractere, care incep cu litera D cu toate litere mari si - in fata
        System.out.println(names.stream()
                .filter(name -> name.length() > 3)
                .filter(name -> name.startsWith("D"))
                .map(String::toUpperCase)
                .map(e -> "- " + e)
                .collect(toList()));

        //obtineti Setul de nume de femei cu * inainte si dupa
        Set<String> result = names.stream()
                .filter(MainStream::nameIsFemale)
                .map(name -> "* " + name + " *")
                .collect(toSet());
        System.out.println(result);

        //obtineti lista sortata alfabetic
        System.out.println(names.stream()
                .sorted()
                .collect(toList()));
        //lista initiala NU se modifica!
        System.out.println(names);

        //obtineti lista sortata invers-alfabetic
        System.out.println(names.stream()
                .sorted(Comparator.reverseOrder())
                .collect(toList()));

        //obtineti lista ordonata dupa lungimea numelor
        System.out.println(names.stream()
                .sorted(comparingInt(String::length))
                .collect(toList()));

        //obtineti lista ordonata dupa lungimea numerelor si apoi alfaabetic
        System.out.println(names.stream()
                .sorted(comparingInt(String::length).thenComparing(s -> s))
                .collect(toList()));

        //sortati lista dupa ultima litera
        System.out.println(names.stream()
                .sorted(Comparator.comparing(s -> s.charAt(s.length() - 1)))
                .collect(toList()));
    }

    private static boolean nameIsFemale(final String name) {
        return name.endsWith("a") || name.endsWith("n") || name.endsWith("e");
    }
}
