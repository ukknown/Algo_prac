class Solution {
    static int answer;
    public int solution(int n) {
        answer = 0;
        for(int i = 1; i <= n; i++){ //숫자를 1 ~ n까지 쌓아가면서 더한다.
            plus(i,n,0);
        }    
        return answer;
    }
    public void plus(int cnt, int dep, int sum){
        if(sum == dep){ // 쌓아진 합 값이 dep(=n)과 같으면 answer + 1
            answer += 1 ;
            return;
        }else if(sum > dep){ // 쌓아진 합 값이 dep을 넘기면 넘긴다.
            return;
        }else{
            plus(cnt+1, dep, sum + cnt); //수를 계속 쌓음
        }
    }
}
