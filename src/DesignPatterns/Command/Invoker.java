package DesignPatterns.Command;

import java.util.ArrayList;
import java.util.List;

public class Invoker {
  private final List<ICommand> commands;

  public Invoker() {
    commands = new ArrayList<>();
  }

  public void clickOn(ICommand command) {
    commands.add(command);
    command.execute();
  }

  public void clickOff(ICommand command) {
    commands.add(command);
    command.execute();
  }
}
