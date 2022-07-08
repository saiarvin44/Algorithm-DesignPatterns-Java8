package Interviews;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/**
 * rollDice() : 1-6
 * calculatePlayerPosition() : calculate the position of player after rolling dice,
 * if position > winning point, reset to old position
 * check if snake or ladder at new position, if yes change accordingly
 */
public class SnakeLadder {

  final static int winningPoint = 100;
  static Map<Integer, Integer> snakes = new HashMap<>();
  static Map<Integer, Integer> ladders = new HashMap<>();

  static {
    snakes.put(62, 5);
    snakes.put(33, 6);
    snakes.put(49, 9);
    snakes.put(88, 16);
    snakes.put(41, 20);
    snakes.put(56, 53);
    snakes.put(98, 64);
    snakes.put(93, 73);
    snakes.put(95, 75);

    ladders.put(2, 37);
    ladders.put(27, 46);
    ladders.put(10, 32);
    ladders.put(51, 68);
    ladders.put(61, 79);
    ladders.put(65, 84);
    ladders.put(71, 91);
    ladders.put(81, 100);
  }

  public static int rollDice() {
    int n = 0;
    Random random = new Random();
    n = random.nextInt(7);
    return (n == 0 ? 1 : n);
  }

  public static int calculatePlayerPosition(int playerPosition, int diceValue) {
    int newPlayerPosition = playerPosition + diceValue;
    if (newPlayerPosition > winningPoint) return playerPosition;
    if (null != snakes.get(newPlayerPosition)) {
      newPlayerPosition = snakes.get(newPlayerPosition);
    }
    if (null != ladders.get(newPlayerPosition)) {
      newPlayerPosition = ladders.get(newPlayerPosition);
    }
    return newPlayerPosition;
  }

  public static boolean isWin(int position) {
    return winningPoint == position;
  }

  public static void main(String[] args) {
    int player1Position = 0, player2Position = 0;
//    Scanner scan = new Scanner(System.in);
//    String roll;
    int currentPlayer = -1;
    int diceValue = 0;
    int winFlag = 0;
    do {
      System.out.println(currentPlayer == -1 ? "\n First player's turn" : "\n Second player's turn");
//      System.out.println("Press 'r' to roll dice");
//      roll = scan.next();
      diceValue = rollDice();
      System.out.println("Dice value : " + diceValue);
      if (currentPlayer == -1) {
        player1Position = calculatePlayerPosition(player1Position, diceValue);
        System.out.println("First player's position : " + player1Position);
        System.out.println("Second player's position : " + player2Position);
        System.out.println("************************");
        if (isWin(player1Position)) {
          System.out.println("Player 1 won");
          winFlag = 1;
          return;
        }
      } else {
        player2Position = calculatePlayerPosition(player2Position, diceValue);
        System.out.println("First player's position : " + player1Position);
        System.out.println("Second player's position : " + player2Position);
        System.out.println("************************");
        if (isWin(player2Position)) {
          System.out.println("Player 2 won");
          winFlag = 1;
          return;
        }
      }
      currentPlayer = -currentPlayer;
    } while (winFlag == 0);
  }

}
