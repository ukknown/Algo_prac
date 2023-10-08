class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        //a : 가져온 빈병 b : 주는 병 n : 내가 가져간 병
        
        while(n >= a){            
            answer += (n/a)*b;
            
            int remainder = n%a;

            n = ((n/a)*b)+remainder;
        }

        return answer;
    }
}
