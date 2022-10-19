
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[][] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < T; tc++) {
			int n = Integer.parseInt(br.readLine());
			
			dp = new int[41][2];
			
			dp[0][0] = 1;
			dp[0][1] = 0;
			
			dp[1][0] = 0;
			dp[1][1] = 1;
			
			
			
			if(n>1) {
				for(int i = 2; i <= n; i++) {
					dp[i][0] = dp[i-1][0] + dp[i-2][0];
					dp[i][1] = dp[i-1][1] + dp[i-2][1];
				}
				
				System.out.println(dp[n][0] + " " + dp[n][1]);
			}else {
				System.out.println(dp[n][0] + " " + dp[n][1]);
			}
			
			
			
		}
	}

}
