import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int day = 10;
        
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < want.length; i++){ //map에 사려는 물품과 그 수량 입력
            map.put(want[i], number[i]);
        }
        
        for(int i = 0; i < discount.length - day + 1; i++){ //할인행사하는 기간에서 확인해야하는 기간(10일)전까지 확인
            Map<String, Integer> cal = new HashMap<>();
            
            for(int j = 0; j < day; j++){ //10일기간 값 입력
                cal.put(discount[i+j], cal.getOrDefault(discount[i+j], 0) + 1); //할인행사하는 물품이 이미 map에 있으면 +1, 없으면 0
            }
            
            Boolean check = true;
            
            for(String key : map.keySet()){ //map과 cal이 동일하지 않으면 false
                if(map.get(key) != cal.get(key)){
                    check = false;
                    break;
                }
            }
            
            if(check){ //tuur면 회원가입 가능한 날 +1
                
                answer += 1;
            }
            
        }
        return answer;
    }
}
