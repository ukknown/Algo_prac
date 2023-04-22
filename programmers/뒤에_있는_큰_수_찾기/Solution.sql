import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {        
        int[] answer = new int[numbers.length];
        Stack<Integer> st = new Stack<>();
        
        for(int i = numbers.length -1; i >= 0; i--){
            while(!st.isEmpty()){
                if(st.peek() > numbers[i]){
                    answer[i] =st.peek();
                    break;
                }else{
                    st.pop();
                }
            }
            if(st.isEmpty()){
                    answer[i] = -1;
                }
                
            st.push(numbers[i]);
        }
        
       
        
        
        return answer;
    }
}
