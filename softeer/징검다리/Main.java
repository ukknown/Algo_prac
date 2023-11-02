import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
      BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));

      int N = Integer.parseInt(br.readLine());

      int[] arr = new int[N];

      int max = 0;
      int count = 0;
      
      StringTokenizer st = new StringTokenizer(br.readLine());      
      for(int i = 0; i < N; i++){
        arr[i] = Integer.parseInt(st.nextToken());
      }

      int[] dp = new int[N];

      for(int i = 0; i < N; i++){ //모든 돌다리는 최초로 밟으면 1
        dp[i] = 1;
      }

      for(int i = 0; i < N; i++){
        for(int j = 0; j <= i; j++){
          if(arr[i] > arr[j]){ //arr[i] 값이 arr[j]보다 크면
            dp[i] = Math.max(dp[i], dp[j]+1); //arr[j]의 값에 +1(arr[i]로 돌다리 건넌 횟수)값과 arr[i]값 최대값 비교
          }
        }
      }
      int result = 0;
      for(int i = 0; i < N; i++){ //가장 높은 값 저장
        result = Math.max(result, dp[i]);
      }

      System.out.println(result);


    }
}
