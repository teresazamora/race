package com.foxminded;

public class Racer {

    private final String name;
    private String team;
    private Long time;

    public Racer(String name, String team, Long time) {
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

    public Long getTime() {
        return time;
    }
}
