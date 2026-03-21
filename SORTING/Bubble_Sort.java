class Solution {
    public void bubbleSort(int[] arr) {
        // code here
        int n = arr.length;
        for (int k=0; k<n-1; k++) {
            int flag = 0;
            for (int i=0; i<n-1; i++) {
                if (arr[i] > arr[i+1]) {
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    flag = 1;
                }
            }
            if(flag == 0) break;
        }
    }
}
