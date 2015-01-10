public class Solution {
    public String simplifyPath(String path) {
        String[] tokens = path.split("/");
        LinkedList<String> queue = new LinkedList<String>();
        for (int i = 1; i < tokens.length; i++) { // 0 th token is ""
            if (tokens[i].equals(".") || tokens[i].equals("")) continue;
            else if (tokens[i].equals("..")) {
                if (!queue.isEmpty()) queue.removeLast();
            } else {
                queue.addLast(tokens[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String token : queue) {
            sb.append("/");
            sb.append(token);
        }
        if (sb.toString().equals("")) return "/";
        return sb.toString();
    }
}
