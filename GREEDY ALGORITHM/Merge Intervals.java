class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int i = 0;
        int n = intervals.length;
        while (i < n) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            while (i < n-1 && end >= intervals[i+1][0]) {
                end = Math.max(end, intervals[i+1][1]);
                i++;
            }
            result.add(new int[]{start, end});
            i++;
        }
        return result.toArray(new int[result.size()][]);
    }
}
