package DesignPatterns.Command;

public class LightOnCommand implements ICommand {

  private Light light;

  public LightOnCommand(Light l) {
    this.light = l;
  }

  @Override
  public void execute() {
    this.light.on();
  }

  @Override
  public void undo() {
    this.light.off();
  }
}
