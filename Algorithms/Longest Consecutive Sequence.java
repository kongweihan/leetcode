public class Solution {
    public int longestConsecutive(int[] num) {
        HashMap<Integer, Integer> left2Right = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> right2Left = new HashMap<Integer, Integer>();
        int max = 1;
        for (int n : num) {
            if (left2Right.containsKey(n) || right2Left.containsKey(n)) continue;
            if (right2Left.containsKey(n - 1)) {
                if (left2Right.containsKey(n + 1)) {
                    right2Left.put(left2Right.get(n + 1), right2Left.get(n - 1));
                    left2Right.put(right2Left.get(n - 1), left2Right.get(n + 1));
                    max = Math.max(max, left2Right.get(n + 1) - right2Left.get(n - 1) + 1);
                    left2Right.remove(n + 1);
                    right2Left.remove(n - 1);
                    
                } else {
                    right2Left.put(n, right2Left.get(n - 1));
                    left2Right.put(right2Left.get(n - 1), n);
                    right2Left.remove(n - 1);
                    max = Math.max(max, n - right2Left.get(n) + 1);
                }
            } else if (left2Right.containsKey(n + 1)) {
                left2Right.put(n, left2Right.get(n + 1));
                right2Left.put(left2Right.get(n + 1), n);
                left2Right.remove(n + 1);
                max = Math.max(max, left2Right.get(n) - n + 1);
            } else {
                left2Right.put(n, n);
                right2Left.put(n, n);
            }
        }
        return max;
    }
}
