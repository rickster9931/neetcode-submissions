class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> results = new ArrayList<>();
        int i = 1;
        results.add(intervals[0]);
        while (i < intervals.length) {
            if (intervals[i][0] <= results.get(results.size() - 1)[1]) {
                int[] create = new int[2];
                create[0] = results.get(results.size() - 1)[0];
                create[1] = Math.max(intervals[i][1], results.get(results.size() - 1)[1]);
                results.remove(results.size() - 1);
                results.add(create);
            }
            else {
                results.add(intervals[i]);
            }
            i++;
        }
        return results.toArray(new int[results.size()][]);
    }
}
