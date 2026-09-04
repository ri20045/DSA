class Solution {
	// Function to find the largest number after k swaps.
	String max;
	public String findMaximumNum(String s, int k) {
		// code here.
		max = s;
		solve(s.toCharArray(), k, 0);
		return max;
	}
	void solve(char[]arr, int k, int index) {
	    int n = arr.length;
		if (k == 0 || index == n-1) {
			return;
		}
		char largest = arr[index];
		for (int i = index + 1; i < n; i++) {
			if (arr[i] > largest) {
				largest = arr[i];
			}
		}
		// if current char is largest so no need to swap, increment index by 1
		if (largest == arr[index]) {
			solve(arr, k, index + 1);
			return;
		}
		for (int i = index + 1; i<n; i++) {
			if (arr[i] == largest) {
				char temp = arr[index];
				arr[index] = arr[i];
				arr[i] = temp;
				
				String current = new String(arr);
				if (current.compareTo(max) > 0) {
					max = current;
				}
				solve(arr, k - 1, index + 1);
				// undo the swap
				temp = arr[index];
				arr[index] = arr[i];
				arr[i] = temp;
			}
		}
	}
}
