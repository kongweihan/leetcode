public class Solution {
    public int[] searchRange(int[] A, int target) {
        int[] range = new int[2];
        range[0] = -1;
        range[1] = -1;
        // search start
        int left = 0, right = A.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (A[mid] == target) {
                if (mid > 0 && A[mid - 1] == target) {
                    right = mid - 1;
                } else {
                    range[0] = mid;
                    break;
                }
            } else if (A[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // not found
        if (range[0] == -1) return range;
        // search end
        left = 0;
        right = A.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (A[mid] == target) {
                if (mid < A.length - 1 && A[mid + 1] == target) {
                    left = mid + 1;
                } else {
                    range[1] = mid;
                    break;
                }
            } else if (A[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return range;
    }
}
