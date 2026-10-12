class Solution {
    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        return traverse(grid, 0, 0);
    }

    public int traverse(int[][] board, int m, int n) {
        if ((m == board.length - 1) && (n == board[0].length -1)) {
            return 1;
        }
        if ((m > board.length - 1) || (n > board[0].length -1)) {
            return 0;
        }
        if (board[m][n] != 0) {
            return board[m][n];
        }
        board[m][n] = traverse(board, m+1, n) + traverse(board, m, n+1);
        return board[m][n];
    }
}
