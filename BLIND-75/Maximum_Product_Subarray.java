class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        for (int n : nums) {
            res = Math.max(res, n);
        }
        int curMin = 1;
        int curMax = 1;
        for (int i : nums) {
            if (i == 0){
                curMin = curMax = 1;
                continue;
            }
            int temp = curMax * i;
            curMax = Math.max(i * curMin, Math.max(temp, i));
            curMin = Math.min(i * curMin, Math.min(temp, i));
            res = Math.max(res, curMax);
        }
        return res;
    }
}
