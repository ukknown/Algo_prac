import java.util.*;

class Solution {
    public String solution(int[] food) {        
        String str = "";
        String r_str = "";
        String answer = "";
        
        
        for(int i = 1; i < food.length; i++){
            food[i] /= 2;
        }
        
        for(int i = 1; i < food.length; i++){
            for(int j = 0; j < food[i]; j++){
                str += i;
            }
        }

      //역순 방법 1
        // StringBuffer sb = new StringBuffer(str);
        // r_str = sb.reverse().toString();

      //역순 방법 2
        for(int i = str.length()-1; i >= 0; i--){
            r_str += str.charAt(i);
        }
        
        str += 0;
             
        // System.out.println(str);
        // System.out.println(r_str);
           
        answer = str+r_str;
        return answer;
    }
}
