import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        if(arr.length == 1){
            int[] result = {-1};
            return result;
        }
        int[] arr2 = new int[arr.length];
        
        for(int i = 0; i < arr.length; i++){
            arr2[i] = arr[i];
        }
        int[] answer = new int[arr.length-1];
        
        Arrays.sort(arr2);
        int min = arr2[0];
        
        
        int idx = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != min){
                answer[idx] = arr[i];
                idx++;
            }
        }
            
        return answer; 
        
        
    }
}
