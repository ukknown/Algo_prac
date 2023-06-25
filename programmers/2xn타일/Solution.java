class Solution {
    public int solution(int n) {
        
        int[] dp = new int[n];
        
        dp[0] = 1;
        dp[1] = 2;
        
        for(int i = 2; i < n; i++){
            int num = dp[i-1] + dp[i-2];
            dp[i] = num%1000000007;
        }
        
        
        return dp[n-1];
    }
}
