package ru.netology;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Radio {

    private int stationsAmount = 10;
    private int minStation = 0;
    private int maxStation = stationsAmount - 1;
    private int minVolume = 0;
    private int maxVolume = 100;
    private int currentStation;
    private int currentVolume;

    public Radio(int stationsAmount, int currentStation, int currentVolume) {
        this.stationsAmount = stationsAmount;
        this.currentStation = currentStation;
        this.currentVolume = currentVolume;
        this.maxStation = stationsAmount - 1;
    }

    public void setCurrentStation(int currentStation) {
        if (currentStation >= minStation && currentStation <= maxStation) {
            this.currentStation = currentStation;
        }
    }

    public void increaseVolume() {
        if (currentVolume < maxVolume) {
            currentVolume++;
        }
    }

    public void decreaseVolume() {
        if (currentVolume > minVolume) {
            currentVolume--;
        }
    }

    public void nextStation() {
        if (currentStation == maxStation) {
            currentStation = minStation;
        } else {
            currentStation++;
        }
    }

    public void previousStation() {
        if (currentStation == minStation) {
            currentStation = maxStation;
        } else {
            currentStation--;
        }
    }
}
