class Solution {
    public int hammingWeight(int n) {
        // int count = 0;
        // String binary = Integer.toBinaryString(n);
        // for (int i=0; i<binary.length(); i++) {
        //     if (binary.charAt(i) == '1') count++;
        // }
        // return count;

        int count = 0;
        while (n != 0) {
            count += (n & 1);
            n >>>= 1;
        }
        return count;
    }
}
