package com.foxminded;

import java.time.Duration;

import java.util.List;

public class Racer {
    private final String name;
    private final String team;
    private final Duration time;
    private List<Racer> racers;

    public List<Racer> getRacers() {
        return racers;
    }

    public void setRacers(List<Racer> racers) {
        this.racers = racers;
    }

    public Racer(String name, String team, Duration time) {
        this.name = name;
        this.team = team;
        this.time = time;
    }

    public Duration getTime() {
        return time;
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }
}
