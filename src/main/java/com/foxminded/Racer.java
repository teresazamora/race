package com.foxminded;

import java.time.Duration;

public class Racer {

    private final String name;
    private String team;
    private Duration time;

    public Racer(String name, String team, Duration time) {
        this.name = name;
        this.team = team;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public Duration getTime() {
        return time;
    }
}
