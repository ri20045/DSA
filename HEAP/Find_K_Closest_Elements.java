class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> {
                    if (a[0] != b[0]) {
                        return b[0] - a[0]; //larger distance 
                    }
                    return b[1] - a[1]; //and if equal distance then largest value
                });
        for (int i = 0; i < arr.length; i++) {
            int diff = Math.abs(arr[i] - x);
            pq.offer(new int[] { diff, arr[i] });
            if (pq.size() > k) {
                pq.poll();
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll()[1]);
        }
        Collections.sort(result);
        return result;
    }
}
