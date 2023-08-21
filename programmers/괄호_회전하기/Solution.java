import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for(int i = 0; i < s.length(); i++){
            Stack<Character> st = new Stack<>();
            String str = s.substring(i,s.length()) + s.substring(0, i); //회전한 문자열 생성
            
            for(int j = 0; j < str.length(); j++){
                char c = str.charAt(j);
                if(st.isEmpty()){ //stack이 비어있으면 값을 넣는다.
                    st.push(c);
                }else if(c ==')' && st.peek() == '('){ //넣을 값이 )이고 stack제일 위의 값이 ( 면 stack에서 제거
                    st.pop();
                }else if(c =='}' && st.peek() == '{'){ //넣을 값이 }이고 stack제일 위의 값이 { 면 stack에서 제거
                    st.pop();
                }else if(c ==']' && st.peek() == '['){ //넣을 값이 ]이고 stack제일 위의 값이 [ 면 stack에서 제거
                    st.pop(); 
                }else{ // 넣을 값이 ( { [ 라면 stack에 추가
                    st.push(c);
                }
            }
            
            if(st.isEmpty())answer++; //스택이 모두 비었으면 올바른 괄호o 아니면 올바른 괄호x
        }
        return answer;
    }
}
