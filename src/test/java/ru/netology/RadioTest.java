package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {
    Radio radio = new Radio();

    @Test
    public void shouldIncreaseVolume() {
        int currentVolume = radio.getCurrentVolume();
        radio.increaseVolume();
        int volumeAfterIncrease = radio.getCurrentVolume();
        assertEquals(currentVolume + 1, volumeAfterIncrease);
    }

    @Test
    public void shouldNotExceedMaxVolume() {
        Radio radio = new Radio(20, 10, 95);
        for (int i = 0; i < 100; i++) {
            radio.increaseVolume();
        }
        assertEquals(radio.getCurrentVolume(), radio.getMaxVolume());
    }

    @Test
    public void shouldDecreaseVolume() {
        Radio radio = new Radio(20, 10, 50);
        int currentVolume = radio.getCurrentVolume();
        radio.decreaseVolume();
        int volumeAfterDecrease = radio.getCurrentVolume();
        assertEquals(currentVolume - 1, volumeAfterDecrease);
    }

    @Test
    public void shouldNotExceedMinVolume() {
        Radio radio = new Radio(20, 10, 5);
        for (int i = 0; i < 100; i++) {
            radio.decreaseVolume();
        }
        assertEquals(radio.getCurrentVolume(), radio.getMinVolume());
    }

    @Test
    public void shouldNextStation() {
        Radio radio = new Radio(20, 10, 50);
        int currentStation = radio.getCurrentStation();
        radio.nextStation();
        assertEquals(currentStation + 1, radio.getCurrentStation());
    }

    @Test
    public void shouldPreviousStation() {
        Radio radio = new Radio(20, 10, 50);
        int currentStation = radio.getCurrentStation();
        radio.previousStation();
        assertEquals(currentStation - 1, radio.getCurrentStation());
    }

    @Test
    public void shouldSwitchToStartStation() {
        Radio radio = new Radio(20, 19, 50);
        radio.nextStation();
        assertEquals(radio.getMinStation(), radio.getCurrentStation());
    }

    @Test
    public void shouldSwitchToEndStation() {
        Radio radio = new Radio(20, 0, 50);
        radio.previousStation();
        assertEquals(radio.getMaxStation(), radio.getCurrentStation());
    }

    @Test
    public void shouldSetStation() {
        int testStation = (radio.getMaxStation() - radio.getMinStation()) / 2;
        radio.setCurrentStation(testStation);
        assertEquals(testStation, radio.getCurrentStation());
    }

    @Test
    public void shouldSetMinStation() {
        int testStation = radio.getMinStation();
        radio.setCurrentStation(testStation);
        assertEquals(testStation, radio.getCurrentStation());
    }

    @Test
    public void shouldSetMaxStation() {
        int testStation = radio.getMaxStation();
        radio.setCurrentStation(testStation);
        assertEquals(testStation, radio.getCurrentStation());
    }

    @Test
    public void shouldNotSetStationBelowMinRange() {
        radio.setCurrentStation(radio.getMinStation() - 1);
        assertNotEquals(radio.getMinStation() - 1, radio.getCurrentStation());
    }

    @Test
    public void shouldNotSetStationAboveMaxRange() {
        Radio radio = new Radio(30, 5, 5);
        radio.setCurrentStation(radio.getMaxStation() + 1);
        assertNotEquals(radio.getMaxStation() + 1, radio.getCurrentStation());
    }
}