class Solution {
    public void quickSort(int[] arr, int low, int high) {
        // code here
        if (low < high) {
            int pIndex = partition(arr, low, high);
            quickSort(arr, low, pIndex-1);
            quickSort(arr, pIndex+1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        // code here
        int pivot = arr[high];
        int pIndex = low;
        for (int i=low; i<high; i++) {
            if(arr[i] <= pivot) {
                // swap(arr[pIndex], arr[i])
                int temp = arr[pIndex];
                arr[pIndex] = arr[i];
                arr[i] = temp;
                pIndex += 1;
            }
        }
        // swap(arr[pIndex], arr[high]);
        int temp = arr[pIndex];
        arr[pIndex] = arr[high];
        arr[high] = temp;
        return pIndex;
    }
}
