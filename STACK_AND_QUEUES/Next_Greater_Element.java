class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        int[] ans = new int[n1];

        for (int i=0; i<n1; i++) {
            int idx = -1;

            for (int j=0; j<n2; j++) {
                if (nums1[i] == nums2[j]) {
                    idx = j;
                    break;
                }
            }
            ans[i] = -1;
            for (int j=idx+1; j<n2; j++) {
                if (nums2[j] > nums1[i]) {
                    ans[i] = nums2[j];
                    break;
                }
            }
        }
        return ans;
    }
}
