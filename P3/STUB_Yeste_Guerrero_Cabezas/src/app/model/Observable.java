package app.model;

public interface Observable {

    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers(Series s, User u);
}
