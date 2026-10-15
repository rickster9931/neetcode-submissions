class Solution {
    public boolean exist(char[][] board, String word) {
        int[][] visit = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean result = helper(board, visit, word, i, j, 0);
                if (result) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean helper(char[][] board, int[][] visit, String word, int m, int n, int ind) {
        if (m >= board.length) {
            return false;
        }
        if (n >= board[0].length) {
            return false;
        }
        if (m < 0) {
            return false;
        }
        if (n < 0) {
            return false;
        }
        if (ind >= word.length()) {
            return false;
        }
        if (visit[m][n] == 1) {
            return false;
        }
        if (board[m][n] != word.charAt(ind)) {
            return false;
        }
        if ((board[m][n] == word.charAt(ind)) && (ind == (word.length() - 1))) {
            return true;
        }
        visit[m][n] = 1;
        boolean found = helper(board, visit, word, m+1, n, ind+1) || helper(board, visit, word, m, n+1, ind+1) || helper(board, visit, word, m-1, n, ind+1) || helper(board, visit, word, m, n-1, ind+1);
        visit[m][n] = 0;
        return found;
    }
}
