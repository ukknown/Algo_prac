import java.util.*;
class Solution {
    public String solution(String s) {
        String[] str = s.split(" ");
       
        int[] arr = new int[str.length];
      
        for(int i = 0; i < str.length; i++){
            arr[i] = Integer.parseInt(str[i]);
        }
      
        Arrays.sort(arr);
  
        String answer = Integer.toString(arr[0]) + " " + Integer.toString(arr[arr.length-1]);
        return answer;
    }
}
