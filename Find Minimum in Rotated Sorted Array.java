public class Solution {
    public int findMin(int[] num) {
        int left = 0, right = num.length - 1;
        while (left < right - 1) {
            if (num[left] < num[right]) return num[left];
            int mid = (left + right) / 2;
            if (num[left] < num[mid]) left = mid + 1;
            else right = mid;
        }
        return num[left] < num[right] ? num[left] : num[right];
    }
}
