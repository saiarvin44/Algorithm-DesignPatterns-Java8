package DesignPatterns.Observer;

public class Main {
    public static void main(String[] args) {
        Observable observable = new Observable();
        IObserver observer1 = new Observer("Observer1");
        IObserver observer2 = new Observer("Observer2");
        IObserver observer3 = new Observer("Observer3");
        observable.add(observer1);
        observable.add(observer2);
        observable.add(observer3);

        observer1.setObservable(observable);
        observer2.setObservable(observable);
        observer3.setObservable(observable);

        observer1.update();
        observable.postMessage("New Message");
    }
}
