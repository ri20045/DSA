class Solution {
    public int[] countBits(int n) {

      //using dp

        int[] dp = new int[n+1];
        int offset = 1;

        for (int i=1; i<=n; i++) {
            if(offset * 2 == i) {
                offset = i;
            }
            dp[i] = 1 + dp[i - offset];
        }
        return dp;

    // iterative

    //     int[] arr = new int[n+1];
    //     for (int i=0; i<=n; i++) {
    //         arr[i] = i;
    //     }
    //     int[] onesCount = new int[n+1];
    //     for (int i=0; i<= n; i++) {
    //         onesCount[i] = countOnes(arr[i]);
    //     }
    //     return onesCount;
    // }

    // public int countOnes(int num) {
    //     int count = 0;
    //     while (num != 0) {
    //         count += (num & 1);
    //         num >>>= 1;
    //     }
    //     return count;

    }
}
