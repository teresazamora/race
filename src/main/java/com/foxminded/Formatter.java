package com.foxminded;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Formatter {

    private static final String REGEX = "[PTS]";
    private static final String ALLM = "M";

    public List<String> finalPrint(Racer racer) {
        List<String> racers = racers(racer);
        int dashCount = racers.get(15).length();
        String addDashes = addLine("-", dashCount);
        racers.add(15, addDashes);
        return racers;
    }

    private List<String> racers(Racer racer) {
        List<String> pilotName = formatNames(racer);
        List<String> carTeam = formatCars(racer);
        List<String> time = formatTime(racer);

        return IntStream.range(0, pilotName.size())
                .mapToObj(i -> String.format("%2d.", (i + 1)) + pilotName.get(i) + carTeam.get(i) + time.get(i))
                .collect(Collectors.toList());
    }

    private List<String> formatTime(Racer racer) {
        return racer.getRacer().stream().map(racerList -> "|" + racerList.getTime())
                .map(time -> time.replaceAll(REGEX, "")).map(time -> time.replace(ALLM, ":"))
                .collect(Collectors.toList());
    }

    private List<String> formatCars(Racer racer) {
        List<String> carFormat = cars(racer);
        return carFormat.stream().map(car -> String.format("%-29s", car)).collect(Collectors.toList());
    }

    private List<String> formatNames(Racer racer) {
        List<String> pilots = pilotName(racer);
        return pilots.stream().map(name -> String.format("%-19s", name)).collect(Collectors.toList());
    }

    private List<String> pilotName(Racer racer) {
        return racer.getRacer().stream().map(RacerView::getNames).collect(Collectors.toList());
    }

    private List<String> cars(Racer racer) {
        return racer.getRacer().stream().map(racerList -> "|" + racerList.getCars() + " ").collect(Collectors.toList());
    }

    private String addLine(String format, int number) {
        return IntStream.range(0, number).mapToObj(i -> format).collect(Collectors.joining());
    }
}
