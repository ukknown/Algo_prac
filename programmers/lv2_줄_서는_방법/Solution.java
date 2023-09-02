//다시 풀 것
import java.util.*;
class Solution {
    public int[] solution(int n, long k) {
        
        int[] answer = new int[n];
        List<Integer> people = new ArrayList<>();
        long fac = 1;
        int idx = 0;
        
        for(int i = 1; i <= n; i++){
            fac *= i;
            people.add(i);
        }
        
        k--;
        while(n > 0){
            fac /= n;
            int value = (int)(k/fac);
            answer[idx++] = people.get(value);
            people.remove(value);
            
            k %= fac;
            n--;
        }
        return answer;
    }
}
