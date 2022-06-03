package com.foxminded;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class FormatterTest {
    @Test
    public void testPrettyFormat() throws IOException {
        Formatter formatter = new Formatter();
        List<String> actual = formatter.finalPrint(racersTest());
        List<String> expected = Arrays.asList(" 1.Sebastian Vettel |FERRARI                   |1:4.415",
                " 2.Daniel Ricciardo |RED BULL RACING TAG HEUER |1:12.013",
                " 3.Valtteri Bottas  |MERCEDES                  |1:12.434",
                " 4.Lewis Hamilton   |MERCEDES                  |1:12.46",
                " 5.Stoffel Vandoorne|MCLAREN RENAULT           |1:12.463",
                " 6.Kimi Raikkonen   |FERRARI                   |1:12.639",
                " 7.Fernando Alonso  |MCLAREN RENAULT           |1:12.657",
                " 8.Sergey Sirotkin  |WILLIAMS MERCEDES         |1:12.706",
                " 9.Charles Leclerc  |SAUBER FERRARI            |1:12.829",
                "10.Sergio Perez     |FORCE INDIA MERCEDES      |1:12.848",
                "11.Romain Grosjean  |HAAS FERRARI              |1:12.93",
                "12.Pierre Gasly     |SCUDERIA TORO ROSSO HONDA |1:12.941",
                "13.Carlos Sainz     |RENAULT                   |1:12.95",
                "14.Esteban Ocon     |FORCE INDIA MERCEDES      |1:13.028",
                "15.Nico Hulkenberg  |RENAULT                   |1:13.065",
                "-------------------------------------------------------",
                "16.Brendon Hartley  |SCUDERIA TORO ROSSO HONDA |1:13.179",
                "17.Marcus Ericsson  |SAUBER FERRARI            |1:13.265",
                "18.Lance Stroll     |WILLIAMS MERCEDES         |1:13.323",
                "19.Kevin Magnussen  |HAAS FERRARI              |1:13.393");
        assertEquals(actual, expected);
    }

    public Racer racersTest() throws IOException {
        ReaderFile readerFile = new ReaderFile();
        Stream<String> startFile = (readerFile.readFile("start.log")).stream();
        Stream<String> endFile = (readerFile.readFile("end.log")).stream();
        Stream<String> abbreviationFile = (readerFile.readFile("abbreviations.txt")).stream();
        RacerParser racerParser = new RacerParser();
        Racer racer = racerParser.inputRacerList(startFile, endFile, abbreviationFile);
        return racer;
    }
}
