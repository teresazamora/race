package com.foxminded;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RacerParser {
    static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss.SSS");

    public List<Racer> racersTable(List<String> startFile, List<String> endFile, List<String> abbreviationFile) {
        Map<String, LocalDateTime> startTime = getTimeList(startFile);
        Map<String, LocalDateTime> endTime = getTimeList(endFile);

        return abbreviationFile.stream().map(lines -> lines.split("_")).map(
                line -> new Racer(line[1], line[2], Duration.between(startTime.get(line[0]), endTime.get(line[0]))))
                .collect(Collectors.toList());
    }

    private Map<String, LocalDateTime> getTimeList(List<String> timeFile) {
        return timeFile.stream().collect(Collectors.toMap(line -> line.substring(0, 3),
                line -> LocalDateTime.parse(line.substring(3), FORMATTER)));
    }

}