public class Solution {
    public boolean search(int[] A, int target) {
        int left = 0, right = A.length - 1;
        if (target == A[0]) return true;
        if (target == A[A.length-1]) return true;
        // target in open interval (A[0], +inf) & (-inf, A[A.length-1]) or (A[0], A[A.length-1])
        while (left < right - 1) {
            int mid = (left + right) / 2;
            if (A[mid] == target) return true;
            if (A[left] == A[left+1]) {
                left++;
                continue;
            }
            if (A[right] == A[right-1]) {
                right--;
                continue;
            }
            if (A[left] < A[mid]) {
                if (A[left] < target && target < A[mid]) right = mid;
                else left = mid;
            } else {
                if (A[mid] < target && target < A[right]) left = mid;
                else right = mid;
            }
        }
        return false;
    }
}
