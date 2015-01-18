public class Solution {
    public List<String> fullJustify(String[] words, int L) {
        List<String> result = new ArrayList<String>();
        List<String> line = new ArrayList<String>();
        int numChar = -1;
        for (String word : words) {
            if (numChar + word.length() + 1 <= L) {
                line.add(word);
                numChar += word.length() + 1;
            } else {
                result.add(getNewLine(line, numChar, L));
                line = new ArrayList<String>();
                line.add(word);
                numChar = word.length();
            }
        }
        // last line
        result.add(lastLine(line, L));
        return result;
    }
    
    private String getNewLine(List<String> words, int numChar, int L) {
        if (words.size() == 1) {
            String str = words.get(0);
            for (int i = str.length(); i < L; i++) str = str + " ";
            return str;
        }
        int extraSpaceEachGap = (L - numChar) / (words.size() - 1);
        int remainSpace = (L - numChar) % (words.size() - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.size() - 1; i++) {
            sb.append(words.get(i));
            sb.append(" ");
            for (int j = 0; j < extraSpaceEachGap; j++) sb.append(" ");
            if (i < remainSpace) sb.append(" ");
        }
        sb.append(words.get(words.size() - 1));
        return sb.toString();
    }
    
    private String lastLine(List<String> words, int L) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.size() - 1; i++) {
            sb.append(words.get(i));
            sb.append(" ");
        }
        sb.append(words.get(words.size() - 1));
        for (int i = sb.length(); i < L; i++) sb.append(" ");
        return sb.toString();
    }
}
