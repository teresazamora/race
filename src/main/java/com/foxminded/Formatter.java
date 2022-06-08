package com.foxminded;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class Formatter {
    public String format(List<Racer> racers, int topPilots) {
        StringBuilder result = new StringBuilder();

        List<Racer> sortedRacers = racers.stream().sorted(comparing(Racer::getTime)).collect(toList());

        int nameMaxLength = getMaxValue(sortedRacers, Racer::getName);
        int teamMaxLength = getMaxValue(sortedRacers, Racer::getTeam);
        int maxLengthLine = nameMaxLength + teamMaxLength + racers.size();
        String formatter = "%2d.%-" + nameMaxLength + "s|%-" + teamMaxLength + "s|%1d:%02d.%03d";

        for (int i = 0; i < sortedRacers.size(); i++) {
            if (i == topPilots) {
                result.append(repeat("-", maxLengthLine)).append(System.lineSeparator());
            }
            result.append(String.format(formatter, i + 1, sortedRacers.get(i).getName(), sortedRacers.get(i).getTeam(),
                    sortedRacers.get(i).getTime().toMinutes(), sortedRacers.get(i).getTime().getSeconds() % 60,
                    sortedRacers.get(i).getTime().toMillis() % 1000)).append(System.lineSeparator());
        }
        return result.toString();
    }

    public static String repeat(String str, int times) {
        return Stream.generate(() -> str).limit(times).collect(joining());
    }

    private int getMaxValue(List<Racer> racers, Function<Racer, String> func) {
        return racers.stream().map(func).mapToInt(String::length).max().getAsInt();
    }
}
