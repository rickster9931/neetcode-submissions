class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> overall = new ArrayList<>();
        int m = heights.length;
        int n = heights[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific(heights, i, j, new boolean[m][n])
                        && atlantic(heights, i, j, new boolean[m][n])) {
                    overall.add(Arrays.asList(i, j));
                }
            }
        }
        return overall;
    }

    public boolean pacific(int[][] heights, int a, int b, boolean[][] visited) {
        if (a == 0 || b == 0) {
            return true;
        }
        visited[a][b] = true;
        int m = heights.length;
        int n = heights[0].length;
        int h = heights[a][b];

        boolean left = false, right = false, up = false, down = false;
        if (b - 1 >= 0 && !visited[a][b - 1] && heights[a][b - 1] <= h) {
            left = pacific(heights, a, b - 1, visited);
        }
        if (b + 1 < n && !visited[a][b + 1] && heights[a][b + 1] <= h) {
            right = pacific(heights, a, b + 1, visited);
        }
        if (a - 1 >= 0 && !visited[a - 1][b] && heights[a - 1][b] <= h) {
            up = pacific(heights, a - 1, b, visited);
        }
        if (a + 1 < m && !visited[a + 1][b] && heights[a + 1][b] <= h) {
            down = pacific(heights, a + 1, b, visited);
        }
        return left || right || up || down;
    }

    public boolean atlantic(int[][] heights, int a, int b, boolean[][] visited) {
        int m = heights.length;
        int n = heights[0].length;
        if (a == m - 1 || b == n - 1) {
            return true;
        }
        visited[a][b] = true;
        int h = heights[a][b];

        boolean left = false, right = false, up = false, down = false;
        if (b - 1 >= 0 && !visited[a][b - 1] && heights[a][b - 1] <= h) {
            left = atlantic(heights, a, b - 1, visited);
        }
        if (b + 1 < n && !visited[a][b + 1] && heights[a][b + 1] <= h) {
            right = atlantic(heights, a, b + 1, visited);
        }
        if (a - 1 >= 0 && !visited[a - 1][b] && heights[a - 1][b] <= h) {
            up = atlantic(heights, a - 1, b, visited);
        }
        if (a + 1 < m && !visited[a + 1][b] && heights[a + 1][b] <= h) {
            down = atlantic(heights, a + 1, b, visited);
        }
        return left || right || up || down;
    }
}