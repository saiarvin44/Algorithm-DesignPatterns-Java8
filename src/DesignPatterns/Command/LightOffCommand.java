package DesignPatterns.Command;

public class LightOffCommand implements ICommand {

  private Light light;

  public LightOffCommand(Light l) {
    this.light = l;
  }

  @Override
  public void execute() {
    this.light.off();
  }

  @Override
  public void undo() {
    this.light.on();
  }
}
