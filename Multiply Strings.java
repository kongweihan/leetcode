public class Solution {
    public String multiply(String num1, String num2) {
        if (num1.charAt(0) == '0' || num2.charAt(0) == '0') return "0";
        if (num1.length() < num2.length()) {
            String tmp = num1;
            num1 = num2;
            num2 = tmp;
        }
        String prod = "";
        for (int i = 0; i < num2.length(); i++) {
            prod = prod + "0";
            prod = add(prod, singleMultiply(num1, num2.charAt(i) - '0'));
        }
        return prod;
    }
    
    private String singleMultiply(String num, int factor) {
        String result = "";
        int carry = 0;
        for (int i = num.length() - 1; i >= 0; i--) {
            result = new Integer(((num.charAt(i) - '0') * factor + carry) % 10).toString() + result;
            carry = ((num.charAt(i) - '0') * factor + carry) / 10;
        }
        return carry != 0 ? new Integer(carry).toString() + result : result;
    }
    
    private String add(String a, String b) {
        int carry = 0;
        String result = "";
        for (int i = 0; i < a.length() || i < b.length(); i++) {
            int sum;
            if (i >= a.length()) {
                sum = b.charAt(b.length() - i - 1) - '0' + carry;
            } else if (i >= b.length()) {
                sum = a.charAt(a.length() - i - 1) - '0' + carry;
            } else {
                sum = a.charAt(a.length() - i - 1) - '0' + b.charAt(b.length() - i - 1) - '0' + carry;
            }
            result = new Integer(sum % 10) + result;
            carry = sum / 10;
        }
        return carry != 0 ? new Integer(carry).toString() + result : result;
    }
}
