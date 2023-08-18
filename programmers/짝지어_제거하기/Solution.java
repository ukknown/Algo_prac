import java.util.*;
class Solution
{
    public int solution(String s)
    {

        Stack<Character> st = new Stack<>();
        char[] arr = s.toCharArray();
        
        for(int i = 0; i < arr.length; i++){
            char c = arr[i];
            
            if(st.isEmpty()){
                st.push(c);
            }else{
                if(st.peek() == c){
                    st.pop();
                }else{
                    st.push(c);
                }
                
            }                      
        }
        
        if(st.isEmpty())return 1;
        else return 0;
        

    }
}
