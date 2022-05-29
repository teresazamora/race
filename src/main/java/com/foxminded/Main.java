package com.foxminded;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        Stream<String> start = Files.lines(Paths.get("src/main/resources/start.log"));
        Stream<String> end = Files.lines(Paths.get("src/main/resources/end.log"));
        Stream<String> abbreviated = Files.lines(Paths.get("src/main/resources/abbreviations.txt"));

        RacerParser racerParser = new RacerParser();
        Racer racer = racerParser.list(start, end, abbreviated);
        Formatter formatter = new Formatter();
        formatter.finalPrint(racer).forEach(System.out::println);
    }
}
