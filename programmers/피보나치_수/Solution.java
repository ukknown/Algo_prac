class Solution {
    public int solution(int n) {
        
        int[] dp = new int[n+1];
        
        dp[0] = 0;
        dp[1] = 1;
               
        
        for(int i = 2; i <= n; i++){
            dp[i] = (dp[i-1] + dp[i-2])%1234567; 
        }  
                
        return dp[n];
    }
}
//나머지 넣는 계산을 for문 밖에 하면 실패로 나온다. 
//for문 안에 작성하면 모듈로 한번 연산하지만 밖에 작성할 경우 for문 모듈 연산과 %결과 넣는 모듈 연산을 두번 수행해야하기 때문
