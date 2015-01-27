public class Solution {
    public List<List<String>> partition(String s) {
        boolean[][] pal = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            // odd pal
            for (int j = i, k = i; j >= 0 && k < s.length(); j--, k++) {
                if (s.charAt(j) == s.charAt(k)) pal[j][k] = true;
                else break;
            }
            // even pal
            for (int j = i, k = i + 1; j >= 0 && k < s.length(); j--, k++) {
                if (s.charAt(j) == s.charAt(k)) pal[j][k] = true;
                else break;
            }
        }
        
        List<List<List<String>>> listlist = new ArrayList<List<List<String>>>();
        List<List<String>> lists = new ArrayList<List<String>>();
        List<String> list = new ArrayList<String>();
        list.add(s.substring(0,1));
        lists.add(list);
        listlist.add(lists);
        
        for (int i = 1; i < s.length(); i++) {
            List<List<String>> newLists = new ArrayList<List<String>>();
            for (int c = 0; c <= i; c++) {
                if (pal[c][i]) {
                    String newPal = s.substring(c, i+1);
                    if (c == 0) {
                        List<String> newList = new ArrayList<String>();
                        newList.add(newPal);
                        newLists.add(newList);
                    } else {
                        for (List<String> oldList : listlist.get(c-1)) {
                            List<String> newList = new ArrayList<String>(oldList);
                            newList.add(newPal);
                            newLists.add(newList);
                        }
                    }
                }
            }
            listlist.add(newLists);
        }
        
        return listlist.get(s.length()-1);
    }
}
