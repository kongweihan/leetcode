public class Solution {
    public int searchInsert(int[] A, int target) {
        if (A.length == 0) return 0;
        if (target <= A[0]) return 0;
        if (target == A[A.length-1]) return A.length - 1;
        if (target > A[A.length-1]) return A.length;
        int left = 0, right = A.length - 1;
        // target is sure to be in open interval (left, right)
        while (left < right - 1) {
            int mid = (left + right) / 2;
            if (A[mid] == target) return mid;
            if (A[mid] < target) left = mid;
            else right = mid;
        }
        return right;
    }
}
