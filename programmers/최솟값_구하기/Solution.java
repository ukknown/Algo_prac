import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {        
        Arrays.sort(A); //오름차순 정렬
        Arrays.sort(B);
                
        int answer = 0;
      //배열원소 곱의 합이 최소가 되는 것을 한 배열의 최댓값과 다른 배열 최솟값을 곱하고 합하는 것
        for(int i = 0; i < A.length; i++){
            answer += A[i] * B[(B.length-1) - i];            
        }
  
        return answer;
    }
}
