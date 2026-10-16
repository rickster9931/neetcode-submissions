class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] map = new boolean[grid.length][grid[0].length];
        int counter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if ((grid[i][j] == '1') && (map[i][j] == false)) {
                    dfs(grid, map, i, j);
                    counter++;
                }
            }
        }
        return counter;
    }
    public void dfs(char[][] grid, boolean[][] map, int a, int b) {
        map[a][b] = true;
        if ((a+1 < grid.length) && (grid[a+1][b] == '1') && (!map[a+1][b])) {
            dfs(grid, map, a+1, b);
        }
        if ((a-1 >= 0) && (grid[a-1][b] == '1') && (!map[a-1][b])) {
            dfs(grid, map, a-1, b);
        }
        if ((b+1 < grid[0].length) && (grid[a][b+1] == '1') && (!map[a][b+1])) {
            dfs(grid, map, a, b+1);
        }
        if ((b-1 >= 0) && (grid[a][b-1] == '1') && (!map[a][b-1])) {
            dfs(grid, map, a, b-1);
        }
    }
}
