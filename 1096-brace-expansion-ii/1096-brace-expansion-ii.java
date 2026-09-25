class Solution {
    private TreeSet<String> result = new TreeSet<>();

    public List<String> braceExpansionII(String expression) {
        dfs(expression);
        return new ArrayList<>(result);
    }

    private void dfs(String exp) {
        int j = exp.indexOf('}');
        if (j == -1) {
            result.add(exp);
            return;
        }

        int i = exp.lastIndexOf('{', j);
        String prefix = exp.substring(0, i);
        String suffix = exp.substring(j + 1);

        String inside = exp.substring(i + 1, j);
        String[] options = inside.split(",");

        for (String option : options) {
            dfs(prefix + option + suffix);
        }
    }
}