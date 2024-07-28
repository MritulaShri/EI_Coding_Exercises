package BehaviouralPatterns;

import java.util.ArrayList;
import java.util.List;

// Subject
class WeatherStation {
    private List<Observer> observers = new ArrayList<>();
    private int temperature;

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        notifyObservers();
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }
}

// Observer interface
interface Observer {
    void update(int temperature);
}

// Concrete observers
class Phone implements Observer {
    @Override
    public void update(int temperature) {
        System.out.println("Phone: Temperature updated to " + temperature + " degrees.");
    }
}

class Computer implements Observer {
    @Override
    public void update(int temperature) {
        System.out.println("Computer: Temperature updated to " + temperature + " degrees.");
    }
}

class Tablet implements Observer {
    @Override
    public void update(int temperature) {
        System.out.println("Tablet: Temperature updated to " + temperature + " degrees.");
    }
}

// Usage
public class ObserverPattern {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();
        Observer phone = new Phone();
        Observer computer = new Computer();
        Observer tablet = new Tablet();

        station.addObserver(phone);
        station.addObserver(computer);
        station.addObserver(tablet);

        station.setTemperature(25);
        station.setTemperature(30);
    }
}
