public class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 0;
        digits[digits.length - 1]++;
        for (int i = digits.length - 1; i >= 0; i--) {
            int nextCarry = 0;
            nextCarry = (digits[i] + carry) / 10;
            digits[i] = (digits[i] + carry) % 10;
            carry = nextCarry;
            if (carry == 0) break;
        }
        if (carry == 1) {
            int[] num = new int[digits.length + 1];
            num[0] = 1;
            for (int i = 0; i < digits.length; i++) num[i+1] = digits[i];
            return num;
        } else return digits;
    }
}
