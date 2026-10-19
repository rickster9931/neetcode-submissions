class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (!(edges.length == (n-1))) {
            return false;
        }
        int[] visited = new int[n];
        helper(0, edges, visited);
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 0) {
                return false;
            }
        }
        return true;
    }

    public void helper(int n, int[][] edges, int[] visited) {
        if (visited[n] == 1) {
            return;
        }
        visited[n] = 1;
        for (int i = 0; i < edges.length; i++) {
            if (edges[i][0] == n) {
                helper(edges[i][1], edges, visited);
            }
            if (edges[i][1] == n-1) {
                helper(edges[i][0], edges, visited);
            }
        }
    }
}
