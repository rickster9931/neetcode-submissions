class Solution {
    public int getSum(int a, int b) {
        int x = a ^ b;
        int y = (a & b) << 1;
        while (y != 0) {
            int temp = x;
            x = x ^ y;
            y = (temp & y) << 1;
        }
        return x;
    }
}
