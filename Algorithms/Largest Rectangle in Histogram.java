public class Solution {
    public int largestRectangleArea(int[] height) {
        this.height = height;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);
        stack.push(0);
        int max = 0;
        for (int i = 1; i <= height.length; i++) {
            if (getH(i) > getH(stack.peek())) {
                stack.push(i);
            } else if (getH(i) == getH(stack.peek())) {
                stack.pop();
                stack.push(i);
            } else {
                int h = getH(stack.pop());
                max = Math.max(max, h * (i - stack.peek() - 1));
                i--;
            }
        }
        return max;
    }
    private int[] height;
    public int getH(int idx) {
        if (idx == -1 || idx == height.length) return 0;
        else return height[idx];
    }
}
