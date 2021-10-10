package ru.netology;

public class Radio {

    public static int MIN_VOLUME = 0;
    public static int MAX_VOLUME = 10;
    public static int MIN_STATION = 0;
    public static int MAX_STATION = 9;
    private int volume = 5;
    private int station = 5;


    public void increaseVolume() {
        if (volume < MAX_VOLUME) {
            volume++;
        }
    }

    public void decreaseVolume() {
        if (volume > MIN_VOLUME) {
            volume--;
        }
    }

    public void setStation(int station) {
        if (station >= MIN_STATION && station <= MAX_STATION) {
            this.station = station;
        } else {
            throw new IllegalArgumentException("Wrong station number");
        }
    }

    public void nextStation() {
        if (station == MAX_STATION) {
            station = MIN_STATION;
        } else {
            station++;
        }
    }

    public void previousStation() {
        if (station == MIN_STATION) {
            station = MAX_STATION;
        } else {
            station--;
        }
    }

    public int getVolume() {
        return volume;
    }

    public int getStation() {
        return station;
    }

}
