package com.foxminded;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class FormatterTest {

    private final Formatter formatter = new Formatter();
    List<Racer> racersList = Arrays.asList(new Racer("Daniel Ricciardo", "RED BULL RACING TAG HEUER", 20000L),
            new Racer("Sebastian Vettel", "FERRARI", 10000L),
            new Racer("Stoffel Vandoorne", "MCLAREN RENAULT", 30000L));

    @Test
    void givenThreeRacers_whenFormatTime_thenReturnSorted() {
        String expected = " 1. Sebastian Vettel | FERRARI                  | 00:10.000" + System.lineSeparator()
                + " 2. Daniel Ricciardo | RED BULL RACING TAG HEUER| 00:20.000" + System.lineSeparator()
                + " 3. Stoffel Vandoorne| MCLAREN RENAULT          | 00:30.000" + System.lineSeparator();
        String actual = formatter.format(racersList, 5);
        assertEquals(actual, expected);
    }

    @Test
    void givenThreeRacers_whenFormatData_thenReturSortedWithHush() {
        String expected = " 1. Sebastian Vettel | FERRARI                  | 00:10.000" + System.lineSeparator()
                + " 2. Daniel Ricciardo | RED BULL RACING TAG HEUER| 00:20.000" + System.lineSeparator()
                + "-----------------------------------------------------------" + System.lineSeparator()
                + " 3. Stoffel Vandoorne| MCLAREN RENAULT          | 00:30.000" + System.lineSeparator();
        String actual = formatter.format(racersList, 2);
        assertEquals(actual, expected);
    }
}
