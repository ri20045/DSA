class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(1, k, n, new ArrayList<>(), ans);
        return ans;
    }

    public static void solve(int start, int k, int target, List<Integer> current, List<List<Integer>> ans) {
        if (current.size() == k) {
            if (target == 0) {
                ans.add(new ArrayList<>(current));
            }
            return;
        }
        for (int i=start; i<=9; i++) {
            if (i > target) {
                break;
            }
            current.add(i);
            solve(i+1, k, target-i, current, ans);
            current.remove(current.size()-1);
        }
    }
}
