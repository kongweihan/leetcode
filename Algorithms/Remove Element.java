public class Solution {
    public int removeElement(int[] A, int elem) {
        int length = A.length;
        int left = 0;
        int right = A.length-1;
        while (left <= right) {
            if (A[left] == elem) {
                // find first elem that should be kept in the end of array
                while (left < right && A[right] == elem) {
                    right--;
                    length--;
                }
                if (left == right) return length - 1;
                A[left] = A[right];
                right--;
                length--;
            }
            left++;
        }
        return length;
    }
}
