package graphs;

import java.util.ArrayDeque;
import java.util.Queue;

public class RottenOranges {

    private static class Pair<U, V> {
        public U first;
        public V second;
        public Pair(U first, V second) {
            this.first = first;
            this.second = second;
        }
    }

    public int orangesRotting(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        boolean[][] rotten = new boolean[r][c];

        int freshOranges = 0;

        Queue<Pair<Integer, Integer>> q = new ArrayDeque<>();

        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(grid[i][j] == 2) {
                    q.offer(new Pair<>(i, j));
                } else if(grid[i][j] == 1)
                    freshOranges++;
            }
        }

        q.offer(new Pair<>(-1, -1)); // Adding this to define a layer. Once we encounter -1 that means layer has been completed
        int ans = -1;
        int[][] directions = { {-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        while(!q.isEmpty()) {
            Pair<Integer, Integer> p = q.poll();
            int row = p.first;
            int col = p.second;

            if(row == -1)  {
                ans++;
                if(!q.isEmpty())
                    q.offer(new Pair<>(-1, -1));
            } else {
                for(int[] d: directions) {
                    int nRow = row + d[0];
                    int nCol = col + d[1];

                    if(nRow >= 0 && nRow < r && nCol >=0 && nCol < c) {
                        if(grid[nRow][nCol] == 1) {
                            grid[nRow][nCol] = 2;
                            freshOranges--;
                            q.offer(new Pair<>(nRow, nCol));
                        }
                    }
                }
            }
        }
        return freshOranges == 0 ? ans : -1;
    }

}
