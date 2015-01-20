public class Solution {
    public int findPeakElement(int[] num) {
        int left = 0, right = num.length - 1;
        while (left < right - 1) {
            int mid = (left + right) / 2;
            if (increase(num, mid - 1, mid) && !increase(num, mid, mid + 1)) return mid;
            if (!increase(num, mid - 1, mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return num[left] > num[right] ? left : right;
    }
    
    public boolean increase(int[] num, int left, int right) {
        if (left == -1) return true;
        if (right == num.length) return false;
        return num[left] < num[right];
    }
}
