package com.foxminded;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacerParser {

    private Racer racer;

    public RacerParser() {
        this.racer = new Racer(null, null, null);
    }

    public Racer inputRacerList(Stream<String> startFile, Stream<String> endFile, Stream<String> abbreviationsFile) {
        racer.setRacers(racersTable(startFile, endFile, abbreviationsFile));
        return racer;
    }

    private Map<String, LocalTime> abbreviationTime(Stream<String> startFile) {
        return startFile.map(part -> part.replace("2018-05-24", "")).map(parts -> parts.split("_"))
                .collect(Collectors.toMap(abb -> abb[0], time -> LocalTime.parse(time[1])));
    }

    private List<Racer> racersTable(Stream<String> startFile, Stream<String> endFile, Stream<String> abbreviationFile) {
        Map<String, LocalTime> startTime = abbreviationTime(startFile);
        Map<String, LocalTime> endTime = abbreviationTime(endFile);

        return abbreviationFile.map(lines -> lines.split("_")).map(
                line -> new Racer(line[1], line[2], Duration.between(startTime.get(line[0]), endTime.get(line[0]))))
                .collect(Collectors.toList());
    }
}