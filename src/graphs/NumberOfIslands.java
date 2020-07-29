package graphs;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 * https://leetcode.com/problems/number-of-islands/
 * Example 1:
 *
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * Output: 1
 * Example 2:
 *
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * Output: 3
 */
public class NumberOfIslands {

    int rows = 0;
    int cols = 0;
    public int numIslands(char[][] grid) {
        int ans = 0;

        if(grid == null || grid.length == 0)
            return 0;
        this.rows = grid.length;
        this.cols = grid[0].length;

        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
                    ans++;
                }
            }
        }

        return ans;
    }

    private void dfs(char[][] grid, int r, int c) {
        if(r >= rows || c >= cols || r< 0 || c < 0)
            return ;
        if(grid[r][c] == '0')
            return ;

        grid[r][c] = '0';

        dfs(grid, r, c+1);
        dfs(grid, r, c-1);
        dfs(grid, r+1, c);
        dfs(grid, r-1, c);
    }
}
