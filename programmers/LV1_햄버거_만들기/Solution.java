import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        
        Stack<Integer> st = new Stack<>();
        int sz = 0;
        int answer = 0;
        
        for(int i = 0; i < ingredient.length; i++){
            st.push(ingredient[i]); //스택에 값을 넣는다.
            if(st.size() >= 4){ // 스택이 4를 넘어가면 내부값 확인
                sz = st.size();
                if(st.get(sz - 1) == 1 //스택 최상위 4개가 햄버거 조합이면
                   && st.get(sz - 2) == 3
                   && st.get(sz - 3) == 2
                   && st.get(sz - 4) == 1
                ){
                    answer++;
                    for(int j = 0; j < 4; j++){ //완성된 햄버거 재료 제거
                        st.pop();
                    }
                }
            }
        }
        
        return answer;
    }
}
