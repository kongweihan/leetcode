public class Solution {
    public List<String> anagrams(String[] strs) {
        HashMap<String, Integer> hash = new HashMap<String, Integer>();
        HashMap<String, String> sorted = new HashMap<String, String>();
        for (String str : strs) {
            String s = sort(str);
            sorted.put(str, s);
            if (hash.containsKey(s)) hash.put(s, hash.get(s) + 1);
            else hash.put(s, 1);
        }
        List<String> list = new ArrayList<String>();
        for (String str : strs) {
            if (hash.get(sorted.get(str)) > 1) list.add(str);
        }
        return list;
    }
    
    public String sort(String s) {
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }
}
