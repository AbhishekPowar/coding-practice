package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 51. N-Queens
 *
 * Input: 4
 * Output: [
 *  [".Q..","...Q","Q...","..Q."],
 *  ["..Q.","Q...","...Q",".Q.."]
 * ]
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
 * Accepted
 */
public class NQueens {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> answer = new ArrayList<>();
        helper(answer, new ArrayList<>(), 0, 0, 0, 4);
        return answer;
    }

    private boolean helper(List<List<String>> solution, List<String> s, int row,int col, int queensPlaced, int n) {
        if(queensPlaced == n) {
            solution.add(s);
            return true;
        }

        for(int i=0; i<=row; i++) {
            for(int j=0; j<=col; j++) {
                if(!validPlacement(s, i,j, n))
                    break;
                s.set(i, s.get(i)+"Q");
                if(helper(solution, s, row, col, queensPlaced-1, n))
                    return true;
                s.set(i, s.get(i).substring(0, col-1)+".");
            }
        }
        return false;
    }

    private boolean validPlacement(List<String> s, int row, int col, int n) {
        if(s.get(row) == null) {
            s.set(row, "");
            return true;
        }
        if(s.get(row).contains("Q"))
            return false;

        for(int i=0; i<n; i++)
            if(s.get(i).charAt(col) == 'Q')
                return false;
        int j = col;
        for(int i=row; i<n && j< n; i++)
            if(s.get(i).charAt(j--) == 'Q')
                return false;
            j = col;
        for(int i=row; i<n && j < n; i++)
            if(s.get(i).charAt(j++) == 'Q')
                return false;
        j = col;
        for(int i=row; i>=0 && j>=0; i--)
            if(s.get(i).charAt(j--) == 'Q')
                return false;
        j = col;
        for(int i=row; i>=0 && j<n; i--)
            if(s.get(i).charAt(j++) == 'Q')
                return false;

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new NQueens().solveNQueens(4));
    }
}
