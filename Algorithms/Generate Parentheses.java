public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        dfs(sb, n, n, result);
        return result;
    }
    
    private void dfs(StringBuilder sb, int left, int right, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(sb.toString());
            return;
        }
        if (left > 0) {
            sb.append('(');
            dfs(sb, left-1, right, result);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (left < right) {
            sb.append(')');
            dfs(sb, left, right-1, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
