class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        backtrack(map, new ArrayList<>(), ans, nums.length);
        return ans;
    }
    public static void backtrack(HashMap<Integer, Integer>map, List<Integer>current, List<List<Integer>> ans, int n) {
        if (current.size() == n) {
            ans.add(new ArrayList<>(current));
            return;
        }
        for (int num : map.keySet()) {
            int count = map.get(num);
            if (count == 0) {
                continue;
            }
            current.add(num);
            map.put(num, count-1);

            backtrack(map, current, ans, n);

            map.put(num, count);
            current.remove(current.size()-1);
        }
    }
}
