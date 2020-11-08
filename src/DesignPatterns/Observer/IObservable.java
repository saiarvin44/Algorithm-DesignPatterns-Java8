package DesignPatterns.Observer;

public interface IObservable<T extends IObserver> {
    public void add(T obj);

    public void remove(T obj);

    public void notifyObservers();

    public <T> T getUpdate(T obj);
}
