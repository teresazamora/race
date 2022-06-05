package com.foxminded;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class RacerParserTest {
    @Test
    public void containsTimeTest() throws IOException {
        List<String> actualTime = racersTest().stream().map(Racer::getTime).map(String::valueOf)
                .collect(Collectors.toList());
        List<String> expected = Arrays.asList("PT1M12.013S", "PT1M4.415S", "PT1M12.46S", "PT1M12.639S", "PT1M12.434S",
                "PT1M13.028S", "PT1M12.657S", "PT1M12.95S", "PT1M12.848S", "PT1M12.941S", "PT1M13.065S", "PT1M12.463S",
                "PT1M12.706S", "PT1M12.829S", "PT1M12.93S", "PT1M13.179S", "PT1M13.265S", "PT1M13.323S", "PT1M13.393S");
        assertEquals(actualTime, expected);
    }

    @Test
    public void containsCarsTest() throws IOException {
        List<String> actualCars = racersTest().stream().map(Racer::getTeam).collect(Collectors.toList());
        List<String> expected = Arrays.asList("RED BULL RACING TAG HEUER", "FERRARI", "MERCEDES", "FERRARI", "MERCEDES",
                "FORCE INDIA MERCEDES", "MCLAREN RENAULT", "RENAULT", "FORCE INDIA MERCEDES",
                "SCUDERIA TORO ROSSO HONDA", "RENAULT", "MCLAREN RENAULT", "WILLIAMS MERCEDES", "SAUBER FERRARI",
                "HAAS FERRARI", "SCUDERIA TORO ROSSO HONDA", "SAUBER FERRARI", "WILLIAMS MERCEDES", "HAAS FERRARI");
        assertEquals(actualCars, expected);
    }

    @Test
    public void containsNamesTest() throws IOException {
        List<String> actualNames = racersTest().stream().map(Racer::getName).collect(Collectors.toList());
        List<String> expected = Arrays.asList("Daniel Ricciardo", "Sebastian Vettel", "Lewis Hamilton",
                "Kimi Raikkonen", "Valtteri Bottas", "Esteban Ocon", "Fernando Alonso", "Carlos Sainz", "Sergio Perez",
                "Pierre Gasly", "Nico Hulkenberg", "Stoffel Vandoorne", "Sergey Sirotkin", "Charles Leclerc",
                "Romain Grosjean", "Brendon Hartley", "Marcus Ericsson", "Lance Stroll", "Kevin Magnussen");
        assertEquals(actualNames, expected);
    }

    public List<Racer> racersTest() throws IOException {
        FileReader readerFile = new FileReader();
        Stream<String> startFile = (readerFile.readFile("start.log")).stream();
        Stream<String> endFile = (readerFile.readFile("end.log")).stream();
        Stream<String> abbreviationFile = (readerFile.readFile("abbreviations.txt")).stream();
        RacerParser racerParser = new RacerParser();
        Racer racer = racerParser.inputRacerList(startFile, endFile, abbreviationFile);
        return racer.getRacer();
    }
}
