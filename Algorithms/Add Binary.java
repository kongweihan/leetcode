public class Solution {
    public String addBinary(String a, String b) {
        String sum = "";
        int carry = 0;
        for (int i = 0; i < a.length() || i < b.length(); i++) {
            int ad = 0, bd = 0;
            if (i < a.length()) {
                ad = a.charAt(a.length() - i - 1) - '0';
            }
            if (i < b.length()) {
                bd = b.charAt(b.length() - i - 1) - '0';
            }
            sum = new Character((char)((ad + bd + carry) % 2 + '0')).toString() + sum;
            carry = (ad + bd + carry) / 2;
        }
        if (carry == 1) sum = "1" + sum;
        return sum;
    }
}
