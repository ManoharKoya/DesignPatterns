package org.example.observer.pattern;

public class MainScreen implements Display, Observer {
    private float temperature, humidity, pressure;
    private WeatherData weatherData;
    public void display() {
        System.out.printf(
                "Main Screen display\nTemperature: %f, Humidity: %f, Pressure: %f\n",
                temperature, humidity, pressure);
    }
    public void update(float temp, float humid, float pres) {
        this.temperature = temp;
        this.humidity = humid;
        this.pressure = pres;
    }
    public void update() {
        // just a notification of state change from subject
        // just PULL what is needed from Subject
        this.humidity = this.weatherData.getHumidity();
        // display
        this.display();
    }
}
