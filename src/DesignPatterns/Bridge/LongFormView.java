package DesignPatterns.Bridge;

public class LongFormView extends View {

  public LongFormView(IResource resource) {
    super(resource);
  }

  @Override
  public String show() {
    return this.resource.snippet() + " html content";
  }
}
