package com.foxminded;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Formatter {

    public List<String> finalPrint(Racer racer, int topPilots) {
        List<String> racers = racers(racer);
        String addDashes = addLine("-", racers.get(0).length());
        racers.add(topPilots, addDashes);
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
        return racer.getRacer().stream().sorted(Comparator.comparing(Racer::getTime))
                .map(racerList -> "|" + racerList.getTime()).map(time -> time.replaceAll("[PTS]", ""))
                .map(time -> time.replace("M", ":")).collect(Collectors.toList());

    }

    private List<String> formatCars(Racer racer) {
        List<String> carFormat = cars(racer);
        int lineLength = carFormat.stream().mapToInt(String::length).max().getAsInt();
        return carFormat.stream().map(car -> String.format("%-" + lineLength + "s", car)).collect(Collectors.toList());
    }

    private List<String> formatNames(Racer racer) {
        List<String> pilots = pilotName(racer);
        int lineLength = pilots.stream().mapToInt(String::length).max().getAsInt();
        return pilots.stream().map(name -> String.format("%-" + lineLength + "s", name)).collect(Collectors.toList());
    }

    private List<String> pilotName(Racer racer) {

        return racer.getRacer().stream().sorted(Comparator.comparing(Racer::getTime)).map(Racer::getName)
                .collect(Collectors.toList());
    }

    private List<String> cars(Racer racer) {
        return racer.getRacer().stream().sorted(Comparator.comparing(Racer::getTime))
                .map(racerList -> "|" + racerList.getTeam() + " ").collect(Collectors.toList());
    }

    private String addLine(String format, int number) {
        return IntStream.range(0, number).mapToObj(i -> format).collect(Collectors.joining());
    }
}