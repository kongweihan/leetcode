public class Solution {
    public int atoi(String str) {
        str = str.trim(); // remove spaces
        if (str.length() == 0) return 0; // not empty
        if (!Character.isDigit(str.charAt(0)) && str.charAt(0) != '-' && str.charAt(0) != '+') return 0; // start with sign or digit
        boolean neg = str.charAt(0) == '-'; // is negative number
        if (!Character.isDigit(str.charAt(0))) str = str.substring(1, str.length()); // remove sign if needed
        long x = 0;
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) break;
            if (x > Integer.MAX_VALUE) break; // too big, no need go further and overflow `x` (a long var)
            x = x*10 + (c - '0');
        }
        
        if (neg) x = -x;
        if (x > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (x < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int)x;
    }
}
