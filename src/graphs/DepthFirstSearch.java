package graphs;

public class DepthFirstSearch {

    public void dfs(int[][] ar) {
        int row = ar.length;
        if(row == 0)
            return;
        int col = ar[0].length;

        boolean[][] visited = new boolean[row][col];
        dfsUtil(ar, 0, 0, visited);

    }

    private void dfsUtil(int[][] ar, int row, int col, boolean[][] visited) {
        int rows = ar.length;
        int cols = ar[0].length;

        if(row < 0  || col < 0 || row >= rows || col>= cols || visited[row][col])
            return ;

        visited[row][col] = true;

        System.out.println(ar[row][col]);
        dfsUtil(ar, row+1, col, visited);
        dfsUtil(ar, row, col+1, visited);
        dfsUtil(ar,  row-1, col, visited);
        dfsUtil(ar, row, col-1, visited);
    }

    public static void main(String[] args) {
        int[][] ar = new int[][] {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        new DepthFirstSearch().dfs(ar);
    }
}
