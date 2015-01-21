public class Solution {
    public boolean canJump(int[] A) {
        int reach = 0;
        for (int i = 0; i < A.length; i++) {
            if (reach >= i) reach = Math.max(reach, i + A[i]);
            else return false;
            if (reach >= A.length - 1) return true;
        }
        return false;
    }
}
