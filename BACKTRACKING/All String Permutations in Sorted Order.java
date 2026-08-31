class Solution {
	public ArrayList<String> permutation(String s) {
		// code here
		ArrayList<String> result = new ArrayList<>();
		char[] arr = s.toCharArray();
		solve(arr, 0, result);
		Collections.sort(result);
		return result;
	}
	private void solve(char[]arr, int index, ArrayList<String> result) {
		if (index == arr.length) {
			result.add(new String(arr));
			return;
		}
		for (int i = index; i<arr.length; i++) {
			// swap
			char temp = arr[index];
			arr[index] = arr[i];
			arr[i] = temp;
			
			solve(arr, index + 1, result);
			
			// backtrack...swap to original
			temp = arr[index];
			arr[index] = arr[i];
			arr[i] = temp;
		}
	}
}
