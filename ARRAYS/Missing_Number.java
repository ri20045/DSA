class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum1 = 0;
        int sum2 = 0;
        for (int i=0; i<n; i++) {
            sum1 += nums[i];
        }
        for (int i=0; i<n+1; i++) {
            sum2 += i;
        }
        int res = sum2 - sum1;
        return res;
    }
}
