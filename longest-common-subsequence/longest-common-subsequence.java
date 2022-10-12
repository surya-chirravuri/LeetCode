class Solution {
    private Map<String, Integer> memo = new HashMap<String, Integer>();
    
    int dp(String text1, String text2, int i, int j ) {
        if(i < 0 || j < 0 ||i > text1.length() - 1 || j > text2.length() - 1)
            return 0;
        String key = i + " " + j;
        if(memo.containsKey(key)) 
            return memo.get(key);
        int value = text1.charAt(i) == text2.charAt(j) ?
            dp(text1, text2, i-1, j-1) + 1 :
            Math.max(dp(text1, text2, i-1, j), dp(text1, text2, i, j-1));
     
        memo.put(key, value);
        return memo.get(key);
    }
    
    public int longestCommonSubsequence(String text1, String text2) {
    
        return dp(text1, text2, text1.length() - 1, text2.length() - 1);
    }
}