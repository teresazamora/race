package com.foxminded;

import java.io.IOException;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter how many pilots will be classificated: ");
        int topPilots = scanner.nextInt();

        RacerParser racerParser = new RacerParser();
        FileReader fileReader = new FileReader();

        Stream<String> startFile = (fileReader.readFile("start.log")).stream();
        Stream<String> endFile = (fileReader.readFile("end.log")).stream();
        Stream<String> abbreviationFile = (fileReader.readFile("abbreviations.txt")).stream();

        Racer racer = racerParser.inputRacerList(startFile, endFile, abbreviationFile);
        Formatter formatter = new Formatter();
        formatter.finalPrint(racer, topPilots).forEach(System.out::println);
    }
}
