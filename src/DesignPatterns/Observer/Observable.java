package DesignPatterns.Observer;

import java.util.ArrayList;
import java.util.List;

public class Observable implements IObservable {

    private List<IObserver> observers;
    private String message;
    private boolean changed;

    public Observable() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void add(IObserver obj) {
        if (obj == null) throw new NullPointerException("Null Observer");
        if (!observers.contains(obj)) observers.add(obj);
    }

    @Override
    public void remove(IObserver obj) {
        observers.remove(obj);
    }

    @Override
    public void notifyObservers() {
        List<IObserver> observersLocal;
        if (!changed)
            return;
        observersLocal = new ArrayList<>(this.observers);
        this.changed = false;
        for (IObserver obj : observersLocal)
            obj.update();
    }

    @Override
    public Object getUpdate(Object obj) {
        return this.message;
    }

    public void postMessage(String msg) {
        System.out.println("Message posted to Topic : " + msg);
        this.message = msg;
        this.changed = true;
        notifyObservers();
    }
}
