import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      int N = sc.nextInt();

      int[] dp = new int[16];

      dp[0] = 2;

      int num = 1;
      for(int i = 1; i < dp.length; i++){
        dp[i] = dp[i-1] + num;
        num *= 2;
      }

      System.out.println(dp[N]*dp[N]);
      
    }
}
