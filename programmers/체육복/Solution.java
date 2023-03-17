import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length; //전체 학생의 수에서 체육복을 잃어버린 학생 수를 빼서 확실하게 들을 수 있는 학생 수를 구함
        
      //순차적으로 비교할 수 있게 정렬
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        //여벌이 있는 학생이 도난 당했을 경우
        for(int i = 0; i < lost.length; i++) {
          for(int j = 0; j < reserve.length; j++) {
            if(lost[i] == reserve[j]) {  //여벌이 있는 학생이 도난
              answer += 1; //수업을 들을 수 있는 학생 수 + 1
              lost[i] = -1; //잃어버린 학생 명단에서 제거
              reserve[j] = -1; //여벌 있는 학생 명단에서 제거
               break;
            }
          }
        }

        //여벌이 없는 학생이 도난을 당했을 경우
        for(int i = 0; i < lost.length; i++) {
          for(int j = 0; j < reserve.length; j++) {
            if(reserve[j] == lost[i] - 1 || reserve[j] == lost[i] + 1) {
              reserve[j] = -1;  //여벌 제거
              answer += 1;  //수업들을 수 잇는 학생 추가
              break;
            }
          }
        }
        return answer;
    }
}
