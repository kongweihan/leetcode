public class Solution {
    public void nextPermutation(int[] num) {
        // if num[i] to num[end] is not reversely sorted
        // that means there exists a greater permutation within num[i] to num[end]
        // and we don't need to touch numbers before num[i]
        // now we can see whether num[i+1] to num[end] is reversely sorted
        // if yes, then the same principle applies
        // if not, we should just take the smallest number from num[i+1] to num[end] that is bigger than num[i]
        // swap it with num[i], and sort num[i+1] to num[end]
        int i = num.length - 1;
        while (i > 0 && num[i-1] >= num[i]) i--;
        if (i == 0) {
            Arrays.sort(num);
            return;
        }
        int min = Integer.MAX_VALUE;
        int minI = -1;
        for (int j = i; j < num.length; j++) {
            if (num[j] > num[i-1] && num[j] < min) {
                min = num[j];
                minI = j;
            }
        }
        int tmp = num[i-1];
        num[i-1] = num[minI];
        num[minI] = tmp;
        
        Arrays.sort(num, i, num.length);
    }
}
