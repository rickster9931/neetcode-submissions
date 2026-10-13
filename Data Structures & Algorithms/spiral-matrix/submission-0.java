class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int[][] chart = new int[matrix.length][matrix[0].length];
        List<Integer> output = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (output.size() < (matrix.length * matrix[0].length)) {
            while ((j < matrix[0].length) && (chart[i][j] != 1)) {
                chart[i][j] = 1;
                output.add(matrix[i][j]);
                j++;
            }
            j--;
            i++;
            while ((i < matrix.length) && (chart[i][j] != 1)) {
                chart[i][j] = 1;
                output.add(matrix[i][j]);
                i++;
            }
            i--;
            j--;
            while ((j >= 0) && (chart[i][j] != 1)) {
                chart[i][j] = 1;
                output.add(matrix[i][j]);
                j--;
            }
            j++;
            i--;
            while ((i >= 0) && (chart[i][j] != 1)) {
                chart[i][j] = 1;
                output.add(matrix[i][j]);
                i--;
            }
            i++;
            j++;
        }
        return output;
    }
}
