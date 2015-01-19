public class Solution {
    public List<String> letterCombinations(String digits) {
        String[] letters = new String[10];
        letters[2] = "abc";
        letters[3] = "def";
        letters[4] = "ghi";
        letters[5] = "jkl";
        letters[6] = "mno";
        letters[7] = "pqrs";
        letters[8] = "tuv";
        letters[9] = "wxyz";
        
        List<String> result = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        dfs(digits, 0, sb, letters, result);
        return result;
    }
    
    private void dfs(String digits, int idx, StringBuilder sb, String[] letters, List<String> result) {
        if (idx == digits.length()) {
            result.add(sb.toString());
        } else {
            int digit = digits.charAt(idx) - '0';
            for (char ch : letters[digit].toCharArray()) {
                sb.append(ch);
                dfs(digits, idx + 1, sb, letters, result);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
