import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int l = answers.length;
      
      //학생들의 찍는 방식
        int[] first = {1,2,3,4,5};
        int[] second = {2,1,2,3,2,4,2,5};
        int[] third = {3,3,1,1,2,2,4,4,5,5};
        
        int[] score = new int[3];
       
        //정답과 학생들의 답 비교
        for(int i = 0; i < l; i++){
            if(answers[i] == first[i%5]){ //첫번째 학생은 5개씩 반복된다.
                score[0]++;
            }
            
            if(answers[i] == second[i%8]){ //두번 째 학생은 8개씩 반복
                score[1]++;
            }
            
            if(answers[i] == third[i%10]){ //세번째 학생은 10번씩 반복
                score[2]++;
            }
        }
        
        int max = Math.max(score[0], Math.max(score[1], score[2])); // 가장 많이 맟춘 학생의 정답 갯수

        List<Integer> list = new ArrayList<Integer>();
        
        for(int i = 0; i < 3; i++){ //가장 높은 갯수와 동일한 학생 리스트 추가
            if(max == score[i]){
                list.add(i+1);
            }
        }
        int[] answer = new int[list.size()]; // 최종 제출용
        
        
        for(int i = 0; i < list.size(); i++){
           answer[i] = list.get(i);
        }
        

        return answer;
    }
}
