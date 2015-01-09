public class Solution {
    public int findMin(int[] num) {
        int left = 0, right = num.length - 1;
        while (left < right - 1) {
            if (num[left] < num[right]) return num[left];
            int mid = (left + right) / 2;
            // make sure num[mid] != num[left] or num[right]
            if (num[left] == num[left + 1]) {
                left++;
                continue;
            }
            if (num[right] == num[right - 1]) {
                right--;
                continue;
            }
            if (num[mid] > num[left]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return num[left] < num[right] ? num[left] : num[right];
    }
}
