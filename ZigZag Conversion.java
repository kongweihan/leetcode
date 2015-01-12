public class Solution {
    public String convert(String s, int nRows) {
        int period = (nRows - 2) * 2 + 2;
        if (nRows == 1) period = 1;
        StringBuilder sb = new StringBuilder();
        // row 1
        for (int i = 0; i < s.length(); i += period)
            sb.append(s.charAt(i));
        // row 2 ~ nRows - 1
        for (int row = 1; row < nRows - 1; row++) {
            for (int i = 0; i < s.length(); i += period) {
                if (i + row < s.length()) sb.append(s.charAt(i + row));
                if (i + period - row < s.length()) sb.append(s.charAt(i + period - row));
            }
        }
        // last row
        if (nRows > 1) {
            for (int i = nRows - 1; i < s.length(); i += period) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
