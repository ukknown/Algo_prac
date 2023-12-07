import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < prices.length; i++){
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]){ // stack에 넣는 중 주식 가격이 떨어진다면
                answer[stack.peek()] = i - stack.peek(); //현재 시점에서 stack 저장된 주식의 시점을 빼줌
                stack.pop(); //주식 유지시간 계산 완료됬으니 제거
            }
            stack.push(i); // 스택에 주식의 index(주식 입력 시점)의 값을 넣는다.
        }
        
        while(!stack.isEmpty()){ //스택 빌 때까지
            answer[stack.peek()] = prices.length - stack.peek() -1; 
            stack.pop();
        }
        
        return answer;
    }
}
