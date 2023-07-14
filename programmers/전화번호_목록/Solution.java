import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        Arrays.sort(phone_book); //접두어의 일치여부를 확인하니 sort()로 정렬하면 접두어가 같다면 앞뒤 접두어가 일치하게 됨
                     
        boolean answer = true;
        
        for(int i = 1; i < phone_book.length; i++){
            if(phone_book[i].startsWith(phone_book[i-1])){ //앞뒤 접두어를 확인해서 일치하면 false
                answer = false;
                break;
            }
        }
        
        return answer;
    }
}
