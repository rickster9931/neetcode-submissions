class MedianFinder {

    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;
    
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        if (minHeap.size() == 0 && maxHeap.size() == 0) {
            minHeap.offer(num);
            return;
        }
        if (num > findMedian()) {
            minHeap.offer(num);
            if (minHeap.size() > (maxHeap.size() + 1)) {
                int change = minHeap.poll();
                maxHeap.offer(change);
            }
        }
        else {
            maxHeap.offer(num);
            if (maxHeap.size() > (minHeap.size() + 1)) {
                int change = maxHeap.poll();
                minHeap.offer(change);
            }
        }
    }
    
    public double findMedian() {
        if (minHeap.size() > maxHeap.size()) {
            return minHeap.peek();
        }
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }
        return (minHeap.peek() + maxHeap.peek()) / 2.0;
    }
}
