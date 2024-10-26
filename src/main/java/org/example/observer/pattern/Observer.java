package org.example.observer.pattern;

public interface Observer {
    public void update(float temp, float humid, float pressure);
    public void update();
}
