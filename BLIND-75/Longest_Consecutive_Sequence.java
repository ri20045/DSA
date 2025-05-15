class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int longest = 1;
        HashSet<Integer> set = new HashSet<>();
        for (int i=0; i<n; i++) {
            set.add(nums[i]);
        }
        for (Integer num : set) {
            if (!set.contains(num-1)) {
                int currentNum = num;
                int count = 1;
                while (set.contains(currentNum+1)) {
                    currentNum += 1;
                    count ++;
                }
                longest = Math.max(longest, count);
            }
        }
        return longest;
    }
}    
