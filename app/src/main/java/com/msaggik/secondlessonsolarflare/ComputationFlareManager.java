package com.msaggik.secondlessonsolarflare;

public class ComputationFlareManager {
    private boolean isRun;
    private final Computer computer;
    private final Planet[] planetArr;

    private ComputationFlareManager(Computer computer, Planet... planetArr) {
        this.computer = computer;
        this.planetArr = planetArr;
    }

    public int getCoreTime() {
        adjustPlanetVolumeTime();
        isRun = true;
        return computeData();
    }

    private void adjustPlanetVolumeTime() {
        for (Planet planet : planetArr) {
            computer.computeVolumeTime(planet);
        }
    }

    private int computeData() {
        while (isRun) {
            computer.runTimeIncrement();
            isRun = false;
            for (Planet planet : planetArr) {
                if (planet.getDelay() > 0) {
                    planet.delayDecrement();
                    isRun = true;
                } else {
                    if (planet.getVolume() > 0) {
                        planet.volumeDecrement();
                        computer.operationCounterIncrement();
                        isRun = true;
                        if (computer.getOperationCounter() > 1) {
                            computer.runTimeIncrement();
                            computer.operationCounterDecrement();
                        }
                    }
                }
            }
        }
        return computer.getRunTime();
    }

    public static class Builder {
        private Computer computer;
        private Planet[] planetsMass;

        public Builder setComputer(Computer computer) {
            this.computer = computer;
            return this;
        }

        public Builder setPlanets(Planet... planets) {
            planetsMass = planets;
            return this;
        }

        public ComputationFlareManager build() {
            return new ComputationFlareManager(computer, planetsMass);
        }
    }
}
