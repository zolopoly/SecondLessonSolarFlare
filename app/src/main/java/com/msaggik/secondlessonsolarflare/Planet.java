package com.msaggik.secondlessonsolarflare;

public class Planet {
    private final String planetName;
    private int delaySeconds;
    private final int solarFlareTime;
    private final int volumeData;
    private int volume;

    public Planet(String planetName, int delayMinute, int solarFlareTime, int volumeData) {
        this.planetName = planetName;
        this.delaySeconds = delayMinute * 60;
        this.solarFlareTime = solarFlareTime;
        this.volumeData = volumeData;
    }

    public int getDelay() {
        return delaySeconds;
    }

    public int getSolarFlareTime() {
        return solarFlareTime;
    }

    public int getVolumeData() {
        return volumeData;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void volumeDecrement() {
        volume--;
    }

    public void delayDecrement() {
        delaySeconds--;
    }
}
