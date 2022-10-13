class Solution {
    private int[][] memo;
    
    int dp(String text1, String text2, int i, int j ) {
        if(i < 0 || j < 0)
            return 0;
        if(memo[i][j] != -1) 
            return memo[i][j];
        int value = text1.charAt(i) == text2.charAt(j) ?
            dp(text1, text2, i-1, j-1) + 1 :
            Math.max(dp(text1, text2, i-1, j), dp(text1, text2, i, j-1));
     
        memo[i][j] = value;
        return memo[i][j];
    }
    
    public int longestCommonSubsequence(String text1, String text2) {
        memo = new int[text1.length() + 1][text2.length() + 1];
        for(int i = 0; i < text1.length() + 1; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dp(text1, text2, text1.length() - 1, text2.length() - 1);
    }
}