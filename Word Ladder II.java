public class Solution {
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        LinkedList<String> thisLevel = new LinkedList<String>();
        LinkedList<String> nextLevel = new LinkedList<String>();
        HashMap<String, List<String>> parents = new HashMap<String, List<String>>();
        HashSet<String> nextLevelSet = new HashSet<String>();
        dict.add(end);
        // level BFS
        // a node in next level may be points to multiple node in this level
        thisLevel.add(start);
        parents.put(start, null);
        boolean found = false;
        while (!thisLevel.isEmpty()) {
            String node = thisLevel.removeFirst();
            if (node.equals(end)) {
                found = true;
                break;
            }
            Set<String> mutations = mutate(node, dict);
            for (String neighbor : mutations) {
                if (!parents.containsKey(neighbor)) {
                    parents.put(neighbor, new ArrayList<String>());
                    parents.get(neighbor).add(node);
                    nextLevel.addLast(neighbor);
                    nextLevelSet.add(neighbor);
                } else {
                    // a node in next level, visited, but should add another parent
                    if (nextLevelSet.contains(neighbor)) {
                        parents.get(neighbor).add(node);
                    }
                }
            }
            if (thisLevel.isEmpty()) {
                thisLevel = nextLevel;
                nextLevel = new LinkedList<String>();
                nextLevelSet = new HashSet<String>();
            }
        }
        
        List<List<String>> result = new ArrayList<List<String>>();
        if (!found) return result;
        // DFS build path, start from end
        buildPath(end, parents, new LinkedList<String>(), result);
        return result;
    }
    
    private void buildPath(String node, HashMap<String, List<String>> parents, LinkedList<String> path, List<List<String>> result) {
        path.addFirst(node);
        if (parents.get(node) == null) {
            List<String> newPath = new ArrayList<String>(path);
            result.add(newPath);
        } else {
            for (String parent : parents.get(node)) {
                buildPath(parent, parents, path, result);
            }
        }
        path.removeFirst();
    }
    
    private HashSet<String> mutate(String s, Set<String> dict) {
        HashSet<String> mutation = new HashSet<String>();
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            char original = sb.charAt(i);
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (ch != original) {
                    sb.setCharAt(i, ch);
                    if (dict.contains(sb.toString())) {
                        mutation.add(sb.toString());
                    }
                }
            }
            sb.setCharAt(i, original);
        }
        return mutation;
    }
}
