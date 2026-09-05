class Solution {
	public static ArrayList<Integer> increasingNumbers(int n) {
		// code here
		ArrayList<Integer> result = new ArrayList<>();
		if (n == 1) {
			for (int i = 0; i <= 9; i++) {
				result.add(i);
			}
			return result;
		}
		solve(0, n, 0, result);
		return result;
	}
	public static void solve (int index, int n, int num, ArrayList<Integer> result) {
		if (index == n) {
			result.add(num);
			return;
		}
		int start;
		if (index == 0) {
			start = 1;
		} else {
			start = (num % 10) + 1;
		}
		for (int digit = start; digit <= 9; digit++) {
			solve(index + 1, n, num * 10 + digit, result);
		}
	}
}
