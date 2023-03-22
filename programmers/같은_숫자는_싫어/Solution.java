import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = new int[arr.length];
        int n = 1;
        answer[0] = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] != arr[i-1]) {
                answer[n] = arr[i];
                n++;
            }
        }

        int[] result = Arrays.copyOfRange(answer, 0 , n);

        return result;
    }
}
