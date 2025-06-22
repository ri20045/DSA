class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        return Math.max(robLinear(nums, 0, n-2), robLinear(nums, 1, n-1));
    }

    private int robLinear(int[] nums, int start, int end) {
        int prev = nums[start];
        int prev2 = 0;

        for (int i = start+1; i <= end; i++) {
            int pick = nums[i];
            if (i > start+1) pick += prev2;

            int notPick = prev;
            int curr = Math.max(pick, notPick);

            prev2 = prev;
            prev = curr;
        }
        return prev;       
    }
}
