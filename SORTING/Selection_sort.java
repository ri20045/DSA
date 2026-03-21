class Solution {
    void selectionSort(int[] arr) {
        // code here
        int n = arr.length;
        for (int i=0; i<n-1; i++) {
            int iMin = i;
            for (int j=i+1; j<n; j++) {
                if (arr[j] < arr[iMin]){
                    iMin = j;
                }
            }
                int temp = arr[i];
                arr[i] = arr[iMin];
                arr[iMin] = temp;
        }
    }
}
