import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder()); 
        
        for(int i = 0; i < priorities.length; i++){
            que.add(priorities[i]);
        }
        
        int answer = 0;
        
        while(!que.isEmpty()){
            for(int i = 0; i < priorities.length; i++){
                if(priorities[i] == que.peek()){
                    if(i == location){
                        answer++;
                        return answer;
                    }
                    que.poll();
                    answer++;
                        
                }
            }          
        }
        
        
        return -1;
    }
}
