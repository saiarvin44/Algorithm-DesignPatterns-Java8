package DesignPatterns.Command;

public class Test {
  public static void main(String[] args) {
    Light light = new Light();
    ICommand lightsOnCommand = new LightOnCommand(light);
    ICommand lightsOffCommand = new LightOffCommand(light);
    Invoker invoker = new Invoker();
    invoker.clickOn(lightsOnCommand);
    invoker.clickOn(lightsOffCommand);
  }
}
