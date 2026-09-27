class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> map = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            map.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int prereq = prerequisites[i][1];
            map.get(prereq).add(course);
        }
        int[] inDeg = new int[numCourses];
        for (int i = 0; i < map.size(); i++) {
            for (int j = 0; j < map.get(i).size(); j++) {
                inDeg[map.get(i).get(j)]++;
            }
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < inDeg.length; i++) {
            if (inDeg[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int ques = queue.poll();
            for (int j = 0; j < map.get(ques).size(); j++) {
                inDeg[map.get(ques).get(j)]--;
                if (inDeg[map.get(ques).get(j)] == 0) {
                    queue.offer(map.get(ques).get(j));
                }
            } 
        }
        for (int i = 0; i < inDeg.length; i++) {
            if (inDeg[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
