class Solution {
    private Set<String> validStrings = new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {
        int leftRemove = 0;
        int rightRemove = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                leftRemove++;
            } else if (c == ')') {
                if (leftRemove > 0) {
                    leftRemove--; 
                } else {
                    rightRemove++; 
                }
            }
        }
        dfs(s, 0, leftRemove, rightRemove, 0, 0, new StringBuilder());
        return new ArrayList<>(validStrings);
    }

    private void dfs(String s, int index, int leftRemove, int rightRemove, int lcnt, int rcnt, StringBuilder sb) {
        if (index == s.length()) {
            if (leftRemove == 0 && rightRemove == 0) {
                validStrings.add(sb.toString());
            }
            return;
        }

        if (rcnt > lcnt) {
            return;
        }

        char c = s.charAt(index);
        int len = sb.length();
        if (c == '(' && leftRemove > 0) {
            dfs(s, index + 1, leftRemove - 1, rightRemove, lcnt, rcnt, sb);
        } else if (c == ')' && rightRemove > 0) {
            dfs(s, index + 1, leftRemove, rightRemove - 1, lcnt, rcnt, sb);
        }

        sb.append(c);
        if (c != '(' && c != ')') {
            dfs(s, index + 1, leftRemove, rightRemove, lcnt, rcnt, sb);
        } else if (c == '(') {
            dfs(s, index + 1, leftRemove, rightRemove, lcnt + 1, rcnt, sb);
        } else {
            dfs(s, index + 1, leftRemove, rightRemove, lcnt, rcnt + 1, sb);
        }

        sb.setLength(len);
    }
}
