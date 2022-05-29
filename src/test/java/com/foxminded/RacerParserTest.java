package com.foxminded;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class RacerParserTest {
    @Test
    public void containsTimeTest() throws IOException {
        List<String> actualTime = racersTest().stream().map(RacerView::getTime)
                .map(String::valueOf)
                .collect(Collectors.toList());
        List<String> expected = Arrays.asList("PT1M4.415S",
                "PT1M12.013S",
                "PT1M12.434S",
                "PT1M12.46S",
                "PT1M12.463S",
                "PT1M12.639S",
                "PT1M12.657S",
                "PT1M12.706S",
                "PT1M12.829S",
                "PT1M12.848S",
                "PT1M12.93S",
                "PT1M12.941S",
                "PT1M12.95S",
                "PT1M13.028S",
                "PT1M13.065S",
                "PT1M13.179S",
                "PT1M13.265S",
                "PT1M13.323S",
                "PT1M13.393S");
        assertEquals(actualTime, expected);
    }

    @Test
    public void containsCarsTest() throws IOException {
        List<String> actualCars = racersTest().stream().map(RacerView::getCars).collect(Collectors.toList());
        List<String> expected = Arrays.asList("FERRARI",
                "RED BULL RACING TAG HEUER",
                "MERCEDES",
                "MERCEDES",
                "MCLAREN RENAULT",
                "FERRARI",
                "MCLAREN RENAULT",
                "WILLIAMS MERCEDES",
                "SAUBER FERRARI",
                "FORCE INDIA MERCEDES",
                "HAAS FERRARI",
                "SCUDERIA TORO ROSSO HONDA",
                "RENAULT",
                "FORCE INDIA MERCEDES",
                "RENAULT",
                "SCUDERIA TORO ROSSO HONDA",
                "SAUBER FERRARI",
                "WILLIAMS MERCEDES",
                "HAAS FERRARI");
        assertEquals(actualCars, expected);
    }

    @Test
    public void containsNamesTest() throws IOException {
        List<String> actualNames = racersTest().stream().map(RacerView::getNames).collect(Collectors.toList());
        List<String> expected = Arrays.asList("Sebastian Vettel",
                "Daniel Ricciardo",
                "Valtteri Bottas",
                "Lewis Hamilton",
                "Stoffel Vandoorne",
                "Kimi Raikkonen",
                "Fernando Alonso",
                "Sergey Sirotkin",
                "Charles Leclerc",
                "Sergio Perez",
                "Romain Grosjean",
                "Pierre Gasly",
                "Carlos Sainz",
                "Esteban Ocon",
                "Nico Hulkenberg",
                "Brendon Hartley",
                "Marcus Ericsson",
                "Lance Stroll",
                "Kevin Magnussen");
        assertEquals(actualNames, expected);
    }

    public List<RacerView> racersTest() throws IOException {
        Stream<String> start = Files.lines(Paths.get("src/test/resources/start.log"));
        Stream<String> end = Files.lines(Paths.get("src/test/resources/end.log"));
        Stream<String> abbreviated = Files.lines(Paths.get("src/test/resources/abbreviations.txt"));
        RacerParser racerParser = new RacerParser();
        Racer racer = racerParser.list(start, end, abbreviated);
        return racer.getRacer();
    }
}
