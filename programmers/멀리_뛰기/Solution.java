class Solution {
    public long solution(int n) {
        
        int[] dp = new int[n+1];
        
        dp[0] = 0;
        dp[1] = 1;
        
        if(n >= 2){
           dp[2] = 2; 
        }
        
        if(n >= 3){
           for(int i = 3; i <= n; i++){
                int num = dp[i-1] + dp[i-2];
               dp[i] = num % 1234567;
            } 
        }
        
        
               
       // long answer = 0;
        return dp[n];
    }
}
