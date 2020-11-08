package DesignPatterns.Observer;

public class Observer implements IObserver {

    private String name;
    private IObservable observable;

    public Observer(String name) {
        this.name = name;
    }

    @Override
    public void update() {
        String msg = (String) observable.getUpdate(this);
        if (msg == null)
            System.out.println(name + ":: No new message");
        else
            System.out.println(name + ":: Consuming message ::" + msg);
    }

    @Override
    public void setObservable(IObservable obj) {
        this.observable = obj;
    }
}
