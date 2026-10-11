class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);

        backtrack(result, new ArrayList<>(), candidates, target, 0);
        
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> currentPath, 
                           int[] candidates, int remainTarget, int startIndex) {
        
        if (remainTarget == 0) {
            result.add(new ArrayList<>(currentPath));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            if (candidates[i] > remainTarget) {
                break;
            }
            currentPath.add(candidates[i]);
            backtrack(result, currentPath, candidates, remainTarget - candidates[i], i);
            currentPath.remove(currentPath.size() - 1);
        }
    }
}
