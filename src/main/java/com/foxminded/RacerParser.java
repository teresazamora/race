package com.foxminded;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacerParser {
    private static final String DATA = "2018-05-24";

    private Racer racer;

    public RacerParser() {
        this.racer = new Racer();
    }

    public Racer list(Stream<String> start, Stream<String> end, Stream<String> abbreviations) {
        racer.setRacer(racersTable(start, end, abbreviations));
        return racer;
    }

    private Map<String, LocalTime> abbreviationTime(Stream<String> start) {
        return start.sorted(Comparator.naturalOrder()).map(part -> part.replace(DATA, ""))
                .map(parts -> parts.split("_"))
                .collect(Collectors.toMap(abb -> abb[0], time -> LocalTime.parse(time[1])));
    }

    private List<RacerView> racersTable(Stream<String> start, Stream<String> end, Stream<String> abbreviation) {
        Map<String, LocalTime> startTime = abbreviationTime(start);
        Map<String, LocalTime> endTime = abbreviationTime(end);

        return abbreviation.sorted(Comparator.naturalOrder()).map(lines -> lines.split("_")).map(
                line -> new RacerView(line[1], line[2], Duration.between(startTime.get(line[0]), endTime.get(line[0]))))
                .sorted(Comparator.comparing(RacerView::getTime)).collect(Collectors.toList());
    }
}
