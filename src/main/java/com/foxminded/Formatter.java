package com.foxminded;

import static java.util.stream.Collectors.joining;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Stream;

public class Formatter {

    public String format(List<Racer> racers, int topRacers) {
        StringBuilder result = new StringBuilder();

        int nameMaxLength = getMaxValue(racers, Racer::getName);
        int teamMaxLength = getMaxValue(racers, Racer::getTeam);
        int maxLengthLine = nameMaxLength + nameMaxLength + teamMaxLength;

        String formatter = "%1$-" + nameMaxLength + "s| %2$-" + teamMaxLength + "s| %3$tM:%3$tS.%3$tL";
        String positionFormatter = "%2d";

        AtomicInteger counter = new AtomicInteger();
        racers.stream().sorted(Comparator.comparing(Racer::getTime)).forEach(racer -> {
            int position = counter.incrementAndGet();
            result.append(String.format(positionFormatter, position) + ". ")
                    .append(String.format(formatter, racer.getName(), racer.getTeam(), racer.getTime())
                            + System.lineSeparator());
            if (position == topRacers) {
                result.append(repeat("-", maxLengthLine) + System.lineSeparator());
            }
        });
        return result.toString();
    }

    public static String repeat(String str, int times) {
        return Stream.generate(() -> str).limit(times).collect(joining());
    }

    private int getMaxValue(List<Racer> racers, Function<Racer, String> func) {
        return racers.stream().map(func).mapToInt(String::length).max().getAsInt();
    }
}
