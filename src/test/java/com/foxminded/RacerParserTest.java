package com.foxminded;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class RacerParserTest {

    RacerParser racerParser = new RacerParser();

    @Test
    void givenLists_whenGetRacers_thenListOfRacers() {
        List<String> startFile = new ArrayList<>();
        startFile.add("SVF2018-05-24_12:02:58.917");
        startFile.add("FAM2018-05-24_12:13:04.512");
        startFile.add("NHR2018-05-24_12:02:49.914");

        List<String> endFile = new ArrayList<>();
        endFile.add("SVF2018-05-24_12:04:03.332");
        endFile.add("FAM2018-05-24_12:14:17.169");
        endFile.add("NHR2018-05-24_12:04:02.979");

        List<String> abbreviations = new ArrayList<>();
        abbreviations.add("SVF_Sebastian Vettel_FERRARI");
        abbreviations.add("FAM_Fernando Alonso_MCLAREN RENAULT");
        abbreviations.add("NHR_Nico Hulkenberg_RENAULT");

        List<Racer> actualResult = racerParser.getRacers(startFile, endFile, abbreviations);

        List<Racer> expectedResult = new ArrayList<>();

        Racer racer1 = new Racer("Sebastian Vettel", "FERRARI", 64415L);
        Racer racer2 = new Racer("Fernando Alonso", "MCLAREN RENAULT", 72657L);
        Racer racer3 = new Racer("Nico Hulkenberg", "RENAULT", 73065L);

        expectedResult.add(racer1);
        expectedResult.add(racer2);
        expectedResult.add(racer3);

        assertEquals(expectedResult,actualResult);
    }
}
