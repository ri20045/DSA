
class Solution {
    public int minMeetingRooms(int[] start, int[] end) {
        // code here
        Arrays.sort(start);
        Arrays.sort(end);
        
        int res = 0;
        int count = 0;
        int s = 0;
        int e = 0;
        
        while (s < start.length) {
            if (start[s] < end[e]) {
                s++;
                count++;
            }
            else {
                e++;
                count--;
            }
            res = Math.max(res, count);
        }
        return res;
    }
}
