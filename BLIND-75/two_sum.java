class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            int curr = nums[i];
            int x = target - curr;
            if (map.containsKey(x)) {
                return new int[]{i, map.get(x)};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
