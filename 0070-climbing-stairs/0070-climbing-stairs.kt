class Solution {
    private val memo = Array<Int>(46) {0}
    fun dp(n: Int): Int {
        if(n <= 2) {
            return n
        }
        if( memo[n] > 0) {
            return memo[n]
        }
    
        memo[n] = dp(n-1) + dp(n-2)
        return memo[n]
    }
    fun climbStairs(n: Int): Int {
        return dp(n)
    }
}