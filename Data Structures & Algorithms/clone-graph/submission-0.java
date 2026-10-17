/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        HashMap<Integer, List<Integer>> chart = new HashMap<>();
        HashMap<Integer, Node> map = new HashMap<>();
        Node curr = node;
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            curr = queue.poll();
            if (map.containsKey(curr.val)) {
                continue;
            }
            Node create = new Node(curr.val);
            map.put(curr.val, create);
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < curr.neighbors.size(); i++) {
                queue.add(curr.neighbors.get(i));
                temp.add(curr.neighbors.get(i).val);
            }
            chart.put(curr.val, temp);
        }
        for (int key : chart.keySet()) {
            Node clone = map.get(key);
            for (int nVal : chart.get(key)) {
                clone.neighbors.add(map.get(nVal));
            }
        }
        return map.get(node.val);
    }
}