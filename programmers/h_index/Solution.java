import java.util.*;
class Solution {
    public int solution(int[] citations) {
        
        Arrays.sort(citations); //배열을 정렬
        int bottom = 0; //배열의 가장 작은 값 h번의 시작
        int top = citations[citations.length - 1]; // 배열의 가장 큰 값 h번의 끝
        
        
        int answer = 0;
        int up = 0;
        int down = 0;
        
        for(int h = bottom; h <= top; h++){
            up = 0; // h이상 값 초기화
            down = 0; // h이하 값 초기화
            for(int j = 0; j < citations.length; j++){      
                if(citations[j] >= h){ // h번 이상 인용됬으면 up+1
                    up += 1;
                }
                if(citations[j] <= h){ //h번 이하 인용됬으면 down+1
                    down += 1;
                }
                
                // if(j == citations.length-1){ //마지막 논문까지 확인했다면
                //     if(up >= h && down <= h){
                //         answer = Math.max(answer, h);
                //     }
                // }                
            }
            if(up >= h && down <= h){
                        answer = Math.max(answer, h);
                    }
        }
        
        return answer;
    }
}
