import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        
        int idx = 0; //택배기사님 요청 택배 번호 위치 index
        for(int i = 1; i <= order.length; i++){
            if(i == order[idx]){ // 1번 컨테이너 밸트에서 나온 택배 번호가 요청사항과 동일하면 상차
                answer++;
                idx++;
            }else{ //동일하지 않으면 2번 컨테이너 밸트로(stack으로 구현)
                stack.push(i);
            }
            
            if(!stack.isEmpty()){ // 2번 컨테이너 밸트에 택배가 있으면 그 번호를 확인해서 요청과 동일하면 상차
                int num1 = stack.peek();
                if(num1 == order[idx]){
                    answer++;
                    idx++;
                    stack.pop();
                }
            }
        }
        
        while(!stack.isEmpty()){ //1번 컨테이너 밸트를 모두 확인하고 2번에 남은 택배 상자 확인
            int num2 = stack.peek();
            
            if(num2 == order[idx]){ // 나오는 값이 요청사항과 동일하면 상차
                answer++;
                idx++;
                stack.pop();
            }else{ //동일하지 않으면 상차 불가 종료
                break;
            }
        }
        
        return answer;
    }
}
