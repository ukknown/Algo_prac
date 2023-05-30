import java.util.*;

class Solution {
    public int solution(int[] nums) {
        //고를 수 있는 포켓몬 수
        int choice = nums.length/2;
        
      //set함수 사용해서 중복된 값을 제거
        HashSet<Integer> set = new HashSet<Integer>();
        
        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }
        
        int answer = 0;        
        
      //고를 수 있는 포켓몬보다 set에 있는 값이 작으면 고를 수 있는 폰켓몬 종류의 최대는 set의 크기
        if(set.size() <= choice){
            answer = set.size();
        }else{ // 고를 수 있는 포켓몬보다 set에 있는 값이 크면 고를 수 있는 폰켓몬의 최대는 전체 마릿 수의 절반 
            answer = choice;
        }
        
        
        return answer;
    }
}
