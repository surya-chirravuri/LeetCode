class Solution {
    int dp(int n, int[] memo) {
        if(n == 0) {
            return 0;
        }
        if(n < 3) {
            return 1;
        }
        
        if(memo[n] > 0) {
            return memo[n];
        }
        
        return memo[n] = dp(n-3, memo) + dp(n-2, memo) + dp(n-1, memo);
    }
    
    public int tribonacci(int n) {
        int[] memo = new int[n+1];
        return dp(n, memo);
    }
}