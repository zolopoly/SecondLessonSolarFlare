package com.msaggik.secondlessonsolarflare;

public class Computer {
    private final String computerName;
    private final int coreFrequency;
    private int runTime;
    private int operationCounter;


    public Computer(String computerName, int coreFrequency) {
        this.computerName = computerName;
        this.coreFrequency = coreFrequency;
    }

    public int getRunTime() {
        return runTime;
    }

    public int getOperationCounter() {
        return operationCounter;
    }

    public void operationCounterIncrement() {
        operationCounter++;
    }

    public void operationCounterDecrement() {
        operationCounter--;
    }

    public void runTimeIncrement() {
        runTime++;
    }

    protected void computeVolumeTime(Planet planet) {
        planet.setVolume((planet.getVolumeData() * planet.getSolarFlareTime() / coreFrequency) / 60);
    }
}
