import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] arr;
	static int[][] dp;
	static int max;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n+1];
		dp = new int[n+1][n+1];
       	
		for(int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		dp[0][1] = dp[1][1] = arr[1];
		
		max = Integer.MIN_VALUE;
		
		for(int i = 2; i <= n; i++) {
			//전 밟고 왔을 때
			int b = dp[1][i-1] + arr[i];
			 //전 안밟고 왔을 때
			int c = dp[0][i-2] + arr[i];
			int d = dp[1][i-2] + arr[i];
			
			
				dp[0][i] = b;
				dp[1][i] = Math.max(c, d);
				
		}
			
		int result = Math.max(dp[0][n], dp[1][n]);
		System.out.println(result);
		

	}



}
