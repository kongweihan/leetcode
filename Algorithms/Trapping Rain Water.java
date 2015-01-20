public class Solution {
    public int trap(int[] A) {
        // the basic idea is to add the water by level, from bottom to top, in each "trap"
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        int water = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[stack.peek()]) {
                int base = A[stack.pop()];
                if (!stack.empty()) { // 3 different cases
                    if (A[i] == A[stack.peek()]) {
                        water += (A[i] - base) * (i - stack.peek() - 1);
                        stack.pop();
                        stack.push(i);
                    } else if (A[i] > A[stack.peek()]) {
                        water += (A[stack.peek()] - base) * (i - stack.peek() - 1);
                        i--;
                    } else {
                        water += (A[i] - base) * (i - stack.peek() - 1);
                        stack.push(i);
                    }
                } else {
                    stack.push(i);
                }
            } else if (A[i] < A[stack.peek()]) {
                stack.push(i);
            } else {
                stack.pop();
                stack.push(i);
            }
        }
        return water;
    }
}
