class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0; int right = 0;
        int res = 0; long total = 0;
        int length = nums.length;
        while (right < length) {
            total += nums[right];
            while ((long) nums[right]*(right-left+1) > (total + k)) {
                total -= nums[left];
                left += 1;
            }
            res = Math.max(res, right-left+1);
            right += 1;
        }
        return res;
    }
}
