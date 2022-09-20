package Algorithms.graph;

public class NumberOfIslands {
    public boolean isSafe(int M[][], int row, int col, boolean visited[][]) {
        return (row >= 0) && (row < 5) && (col >= 0) && (col < 5) && (M[row][col] == 1 && !visited[row][col]);
    }

    public void DFS(int M[][], int row, int col, boolean visited[][]) {
        int rowItr[] = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
        int colItr[] = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};
        visited[row][col] = true;

        for (int k = 0; k < 8; k++)
            if (isSafe(M, row + rowItr[k], col + colItr[k], visited))
                DFS(M, row + rowItr[k], col + colItr[k], visited);
    }

    public int countIslands(int M[][]) {
        boolean visited[][] = new boolean[5][5];
        int count = 0;
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                if (M[i][j] == 1 && !visited[i][j]) {
                    DFS(M, i, j, visited);
                    count++;
                }
        return count;
    }

    public static void main(String[] args) {
        int M[][] = new int[][]
                {{1, 1, 0, 0, 0},
                        {0, 1, 0, 0, 1},
                        {1, 0, 0, 1, 1},
                        {0, 0, 0, 0, 0},
                        {1, 0, 1, 0, 1}};

        NumberOfIslands island = new NumberOfIslands();
        System.out.println("Number of Islands : " + island.countIslands(M));
    }
}

