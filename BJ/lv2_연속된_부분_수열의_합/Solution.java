class Solution {
    public int[] solution(int[] sequence, int k) {
        int size = sequence.length;
        int start = 0;
        int end = 0;
        
        int s = 0;
        int e = 0;
        
        int sum = 0;
        for(end = 0; end < sequence.length; end++){// 부분수열 끝부분 계속 이동
            sum += sequence[end]; // 이동할 때 마다 값 최신화
            
            while(sum > k){ // 합이 k를 넘을 경우 
                    sum -= sequence[start]; //앞부분 값 제거
                    start += 1; //앞부분 위치 최신화
                }
            
           if(sum == k){ // 합이 k값과 동일
                if(size > (end - start)){ // 현재 길이가 size보다 작으면
                    size = (end - start ); //size 값 최신화
                    s = start; //가장 짧은 부분수열 앞부분 최신화
                    e = end; // 가장 짧은 부분수열 뒷부분 최신화
                }
               
            }                
        }
        
        int[] answer = {s, e};
        return answer;
    }
}
