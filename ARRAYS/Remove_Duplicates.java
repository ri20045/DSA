class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int left = 1;
        int right = 1;
        for (right=1; right<n; right++) {
            if(nums[right] != nums[right-1]) {
                nums[left] = nums[right];
                left ++;
            }
        }
        return left;
    }
}
