import java.util.*;
class Solution {
    public String solution(int n) {
        String answer = "";
        
        int num = n;
        
        while(num > 0){
            int cal = num%3;
            
            if(cal == 0){ //3으로 나눈 결과가 0이면 4
                answer += String.valueOf(4);
                num--; //딱 나누어 떨어지므로 탈출조건 맞추기
            }else if(cal == 1){ //3으로 나눈 결과가 1이면 1
                answer += String.valueOf(1);
            }else if(cal == 2){ //3으로 나눈 결과가 2이면 2
                answer += String.valueOf(2);
            }
            
            num /= 3; //2자릿수일 경우 or 탈출조건만들기
        }
        
        StringBuffer sb = new StringBuffer(answer); //문자열 뒤집기 안뒤집으면 숫자가 반대로 출력됨
        String result = sb.reverse().toString();
        
       
        return result;
    }
}
