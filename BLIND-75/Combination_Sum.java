class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(candidates, target, 0, new ArrayList<>(), 0, result);
        return result;
    }
    private void dfs(int[] candidates, int target, int i, List<Integer> current, int total, List<List<Integer>> result) {
        if (total == target) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (i >= candidates.length || total > target) return;

        current.add(candidates[i]);
        dfs(candidates, target, i, current, total+candidates[i], result);
        current.remove(current.size() - 1);
        dfs(candidates, target, i + 1, current, total, result);
    }
}
