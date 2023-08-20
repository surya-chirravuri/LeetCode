class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder prefix = new StringBuilder("");
        int minSize = 200;
        for(int i = 0; i < strs.length; i++) {
            minSize = Math.min(minSize, strs[i].length());
        }
        for(int i = 0; i < minSize; i++) {
            char prefixLetter = strs[0].charAt(i);
            int j = 1;
            for(; j < strs.length; j++) {
                if(strs[j].charAt(i) != prefixLetter ) {
                    break;
                }
            }  
            if(j == strs.length) {
                prefix.append(prefixLetter);
            } else {
                break;
            }
        }
        return prefix.toString();
    }
}