package org.example.observer.pattern;

import java.util.List;

public class WeatherData implements Subject{
    public List<Observer> displays;

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    private float temperature, humidity, pressure;

    public WeatherData(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
    }

    public void addObserver(Observer observer) {
        displays.add(observer);
    }
    public void removeObserver(Observer observer) {
        displays.remove(observer);
    }
    public void notifyObservers() {
        // This is Push Based
        for(Observer display: displays) display.update(temperature, humidity, pressure);
        // OR. Pull based is more correct!
        for(Observer display: displays) display.update(); // just notify there is an update
    }

    public void modifyWeatherData() {
        // on each modify --> Observers should be notified --> Publish - Subscribe model
        notifyObservers();
    }
}
