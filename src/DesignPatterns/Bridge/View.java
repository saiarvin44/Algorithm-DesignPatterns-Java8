package DesignPatterns.Bridge;

public abstract class View {

    protected IResource resource;
    public View(IResource resource){
        this.resource=resource;
    }

    public abstract String show();
}
