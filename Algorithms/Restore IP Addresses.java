public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        List<String> ip = new ArrayList<String>();
        findIp(s, 0, ip, result);
        return result;
    }
    
    private void findIp(String s, int idx, List<String> ip, List<String> result) {
        if (idx > 3) {
            if (s.equals("")) 
                result.add(ip.get(0) + "." + ip.get(1) + "." + ip.get(2) + "." + ip.get(3));
            return;
        }
        if (s.length() > 0 && s.charAt(0) == '0') {
            ip.add(idx, "0");
            findIp(s.substring(1), idx + 1, ip, result);
            ip.remove(idx);
            return;
        }
       
        for (int i = 1; i <= 3 && i <= s.length(); i++) {
            if (Integer.parseInt(s.substring(0,i)) <= 255) {
                ip.add(idx, s.substring(0,i));
                findIp(s.substring(i), idx + 1, ip, result);
                ip.remove(idx);
            }
        }
    }
}
