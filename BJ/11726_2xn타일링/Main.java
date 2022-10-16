import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		int n = Integer.parseInt(br.readLine());
		
		int[] dp = new int[1001];
		
		dp[0] = 1;
		dp[1] = 1;
		
		for(int i = 2; i <=n; i++) {
			int a = dp[i-1]+dp[i-2];
			dp[i] = a%10007;
//			System.out.println(dp[i]);
		}
		
		System.out.println(dp[n]);
		
		

	}

}
