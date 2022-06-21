package com.foxminded;

import java.util.Objects;

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
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Racer racer = (Racer) o;
        return Objects.equals(name, racer.name) && Objects.equals(team, racer.team) && Objects.equals(time, racer.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, team, time);
    }
}
