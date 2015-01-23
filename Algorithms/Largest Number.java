public class Solution {
    public String largestNumber(int[] num) {
        ArrayList<String> list = new ArrayList<String>();
        for (int n : num) {
            list.add(new Integer(n).toString());
        }
        Collections.sort(list, new MyComparator());
        if (list.get(list.size()-1).equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }
    
    class MyComparator implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            for (int i = 0; i < s1.length() || i < s2.length(); i++) {
                if (i == s1.length()) {
                    return compare(s1, s2.substring(i));
                } else if (i == s2.length()) {
                    return compare(s1.substring(i), s2);
                } else {
                    if (s1.charAt(i) > s2.charAt(i)) return 1;
                    if (s1.charAt(i) < s2.charAt(i)) return -1;
                }
            }
            return 0;
        }
    }
}
