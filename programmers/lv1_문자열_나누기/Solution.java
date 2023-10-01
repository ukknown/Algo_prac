import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        int loc = 0;
        boolean flag = true;
        String[] str = s.split("");
        
        while(flag){
            if(loc == str.length-1){
                answer++;
                break;
            }

            String x = str[loc];
            int same = 1;
            int diff = 0;
            
          
            for(int i = loc+1; i < str.length; i++){
                if(i == str.length-1){
                    flag=false;
                    answer++;
                    break;
                }
                
                
                if(x.equals(str[i])){
                    same++;
                }else{
                    diff++;
                }
                                
                if(same == diff){
                    loc = i+1;
                    answer++;
                    break;
                }
                
                
            }
            
        }
        
        return answer;
    }
}
