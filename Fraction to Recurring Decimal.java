public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        boolean neg = numerator < 0 ^ denominator < 0;
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        StringBuilder sb = new StringBuilder();
        sb.append(num / den);
        int dotIdx = sb.length();
        if (num % den > 0) {
            sb.append('.');
            long remain = num % den;
            int dec = 1;
            HashMap<Long, Integer> hash = new HashMap<Long, Integer>();
            while (remain != 0 && !hash.containsKey(remain)) {
                hash.put(remain, dec);
                dec++;
                sb.append(remain * 10 / den);
                remain = (remain * 10) % den;
            }
            if (remain != 0) {
                sb.insert(dotIdx + hash.get(remain), '(');
                sb.append(')');
            }
        }
        if (neg) sb.insert(0, '-');
        return sb.toString();
    }
}
