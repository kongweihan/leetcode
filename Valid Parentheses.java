public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '[' || c == '(' || c == '{') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.empty() || stack.pop() != '(') {
                    return false;
                }
            } else if (c == ']') {
                if (stack.empty() || stack.pop() != '[') {
                    return false;
                }
            } else if (c == '}') {
                if (stack.empty() || stack.pop() != '{') {
                    return false;
                }
            } else return false;
        }
        if (stack.empty()) return true;
        else return false;
    }
}
