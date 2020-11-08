package DesignPatterns.Observer;

public interface IObserver<T extends IObservable> {
    public void update();

    public void setObservable(T obj);
}
