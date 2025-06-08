class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
      
        List<int[]> merged = new ArrayList<>();
        int[] current = intervals[0];
        merged.add(current); //first interval
      
        for (int[] next : intervals) {
            //no overlap
            if (current[1] < next[0]) {
                current = next;
                merged.add(current);
            }
            else {
                current[1] = Math.max(current[1], next[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
