package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RadioTest {

    @Test
    void shouldIncreaseVolume() {
        Radio radio = new Radio();
        int volume = radio.getVolume();
        radio.increaseVolume();
        int volumeAfterIncrease = radio.getVolume();
        assertEquals(volume + 1, volumeAfterIncrease);
    }

    @Test
    void shouldNotExceedMaxVolume() {
        Radio radio = new Radio();
        for (int i = 0; i < 100; i++) {
            radio.increaseVolume();
        }
        assertEquals(radio.getVolume(), Radio.MAX_VOLUME);
    }

    @Test
    void shouldDecreaseVolume() {
        Radio radio = new Radio();
        int volume = radio.getVolume();
        radio.decreaseVolume();
        int volumeAfterDecrease = radio.getVolume();
        assertEquals(volume - 1, volumeAfterDecrease);
    }

    @Test
    void shouldNotExceedDecreaseVolume() {
        Radio radio = new Radio();
        for (int i = 0; i < 100; i++) {
            radio.decreaseVolume();
        }
        assertEquals(radio.getVolume(), Radio.MIN_VOLUME);
    }

    @Test
    void shouldNextStation() {
        Radio radio = new Radio();
        radio.setStation(Radio.MIN_STATION);
        int station = radio.getStation();
        radio.nextStation();
        assertEquals(station + 1, radio.getStation());
    }

    @Test
    void shouldPreviousStation() {
        Radio radio = new Radio();
        radio.setStation(Radio.MAX_STATION);
        int station = radio.getStation();
        radio.previousStation();
        assertEquals(station - 1, radio.getStation());
    }

    @Test
    void shouldSwitchToStartStation(){
        Radio radio = new Radio();
        radio.setStation(Radio.MAX_STATION);
        radio.nextStation();
        assertEquals(Radio.MIN_STATION, radio.getStation());
    }

    @Test
    void shouldSwitchToEndStation(){
        Radio radio = new Radio();
        radio.setStation(Radio.MIN_STATION);
        radio.previousStation();
        assertEquals(Radio.MAX_STATION, radio.getStation());
    }

    @Test
    void shouldSetStation() {
        Radio radio = new Radio();
        int testStation = 5;
        radio.setStation(testStation);
        assertEquals(testStation,radio.getStation());
    }

    @Test
    void shouldSetStationWithError(){
        Radio radio = new Radio();
        assertThrows(IllegalArgumentException.class, () -> radio.setStation(777));
    }
}