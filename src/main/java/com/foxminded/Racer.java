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
    public int hashCode() {
        return Objects.hash(name, team, time);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Racer other = (Racer) obj;

        if (team == null) {
            if (other.team != null)
                return false;
        } else if (!team.equals(other.team))
            return false;
        if (time == null) {
            if (other.time != null)
                return false;
        } else if (!time.equals(other.time))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }
}
