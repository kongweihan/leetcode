public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {
        dict.add(end);
        LinkedList<String> thisLevel = new LinkedList<String>();
        LinkedList<String> nextLevel = new LinkedList<String>();
        HashSet<String> visited = new HashSet<String>();
        thisLevel.addLast(start);
        visited.add(start);
        int level = 1;
        while (!thisLevel.isEmpty()) {
            String node = thisLevel.removeFirst();
            List<String> neighbors = getNeighbors(node, dict);
            for (String neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    if (neighbor.equals(end)) return level + 1;
                    visited.add(neighbor);
                    nextLevel.addLast(neighbor);
                }
            }
            if (thisLevel.isEmpty()) {
                thisLevel = nextLevel;
                nextLevel = new LinkedList<String>();
                level++;
            }
        }
        return 0;
    }
    
    private List<String> getNeighbors(String node, Set<String> dict) {
        StringBuilder sb = new StringBuilder(node);
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < sb.length(); i++) {
            char original = sb.charAt(i);
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (ch != original) {
                    sb.setCharAt(i, ch);
                    if (dict.contains(sb.toString())) {
                        list.add(sb.toString());
                    }
                }
            }
            sb.setCharAt(i, original);
        }
        return list;
    }
}
