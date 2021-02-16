package algorithms.Backtracking;

public class RatInAMaze {
  private boolean[][] maze, solution;

  RatInAMaze(int N) {
    maze = new boolean[N][N];
    solution = new boolean[N][N];
  }

  public boolean solveMaze(int n) {
    if (solveMazeRec(0, 0, n) == false) return false;
    else return true;
  }

  private boolean solveMazeRec(int i, int j, int N) {
    if (i == N - 1 && j == N - 1) {
      solution[i][j] = true;
      return true;
    }
    if (isSafe(i, j, N) == true) {
      solution[i][j] = true;
      if (solveMazeRec(i + 1, j, N)) return true;
      else if (solveMazeRec(i, j + 1, N)) return true;
      solution[i][j] = false;
    }
    return false;
  }

  private boolean isSafe(int i, int j, int n) {
    return (i < n && j < n && maze[i][j] == true);
  }
}
