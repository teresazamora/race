package com.foxminded;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter how many pilots will be classificated: ");
        int topPilots = scanner.nextInt();

        RacerParser racerParser = new RacerParser();
        FileReader fileReader = new FileReader();

        List<String> startFile = (fileReader.readFile("start.log"));
        List<String> endFile = (fileReader.readFile("end.log"));
        List<String> abbreviationFile = (fileReader.readFile("abbreviations.txt"));

        List<Racer> racer = racerParser.racersTable(startFile, endFile, abbreviationFile);
        Formatter formatter = new Formatter();
        System.out.println(formatter.format(racer, topPilots));
    }
}
