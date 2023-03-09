import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        long[] dp = new long[101];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;

        for(int i = 6; i < dp.length; i++){
            dp[i] = dp[i-1] + dp[i-5];
        }

        for(int tc = 0; tc < T; tc++){
            int N = Integer.parseInt(br.readLine());

            System.out.println(dp[N]);
        }
    }
}
