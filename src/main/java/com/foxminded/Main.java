package com.foxminded;

import java.io.IOException;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {

        RacerParser racerParser = new RacerParser();
        ReaderFile readerFile = new ReaderFile();

        Stream<String> startFile = (readerFile.readFile("start.log")).stream();
        Stream<String> endFile = (readerFile.readFile("end.log")).stream();
        Stream<String> abbreviationFile = (readerFile.readFile("abbreviations.txt")).stream();

        Racer racer = racerParser.inputRacerList(startFile, endFile, abbreviationFile);
        Formatter formatter = new Formatter();
        formatter.finalPrint(racer).forEach(System.out::println);
    }
}
