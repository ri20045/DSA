class Solution {
    public boolean containsDuplicate(int[] nums) {
        //TC = O(n^2) SC = O(1)
        // int n = nums.length;
        // for (int i=0; i<n; i++) {
        //     for (int j=i+1; j<n; j++) {
        //         if (nums[i] == nums[j]) return true;
        //     }
        // }
        // return false;

        //using hashset
        HashSet<Integer> map = new HashSet<>();
        int n = nums.length;
        for (int i=0; i<n; i++) {
            if (map.contains(nums[i])) return true;
            map.add(nums[i]);
        }
        return false;
    }
}
