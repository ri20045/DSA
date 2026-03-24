class Solution {
    // Please change the array in-place
    public void insertionSort(int arr[]) {
        // code here
        int n = arr.length;
        for (int i=1; i<n; i++) {
            int value = arr[i];
            int hole = i;
            while (hole > 0 && arr[hole-1] > value) {
                arr[hole] = arr[hole-1];
                hole = hole-1;
            }
            arr[hole] = value;
        }
    }
}
