package com.foxminded;

import java.time.Duration;

public class RacerView {
    private String names;
    private String cars;
    private Duration time;

    public RacerView (String names, String cars, Duration time) {
        this.names = names;
        this.cars = cars;
        this.time = time;
    }

    public Duration getTime() {
        return time;
    }

    public String getNames() {
        return names;
    }

    public String getCars() {
        return cars;
    }
}
