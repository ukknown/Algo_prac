import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] arr = new int[progresses.length];
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < progresses.length; i++){
            int day = 0;
            while(progresses[i] + (speeds[i] * day) < 100){
                day++;
            }
            arr[i] = day;
        }
        
        // for(int i = 0; i < arr.length; i++){
        //     System.out.print(arr[i] + " ");
        // }
        // System.out.println();
        
        
        int flag = arr[0];
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] <= flag){
                count += 1;
            }else{
                flag = arr[i];
                list.add(count);
                count = 1;
            }
        }
        list.add(count);    
        int[] answer = new int[list.size()];
        
        // for(int i = 0; i < list.size(); i++){
        //     System.out.print(list.get(i) + " ");
        // }
        
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
