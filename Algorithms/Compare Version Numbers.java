public class Solution {
    public int compareVersion(String version1, String version2) {
        version1 = version1 + ".0";
        version2 = version2 + ".0";
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        for (int i = 0; i < v1.length && i < v2.length; i++) {
            int n1 = Integer.parseInt(v1[i]);
            int n2 = Integer.parseInt(v2[i]);
            if (n1 > n2) return 1;
            if (n1 < n2) return -1;
        }
        return 0;
    }
}
