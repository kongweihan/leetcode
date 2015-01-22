public class Solution {
    public int majorityElement(int[] num) {
        Integer cur = null;
        int count = 0;
        for (int n : num) {
            if (cur == null) {
                cur = n;
            }
            if (cur == n) {
                count++;
            } else {
                count--;
                if (count == 0) cur = null;
            }
        }
        return cur;
    }
}
