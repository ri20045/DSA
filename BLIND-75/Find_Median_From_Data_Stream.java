class MedianFinder {

    private PriorityQueue <Integer> small; //maxHeap
    private PriorityQueue <Integer> large; //minHeap

    public MedianFinder() {
        small = new PriorityQueue<>(Collections.reverseOrder()); //maxHeap
        large = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        small.offer(num);
        large.offer(small.poll());

        if (small.size() < large.size()) {
            small.offer(large.poll());
        }
    }
    
    public double findMedian() {
        if (small.size() > large.size()) {
            return small.peek();
        }
        else {
            return (small.peek() + large.peek()) / 2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
