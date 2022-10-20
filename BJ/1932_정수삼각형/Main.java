
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[n][n];
		int[][] dp = new int[n][n];
		
		int size = 1;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < size; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
			size+= 1;
		}
		dp[0][0] = arr[0][0];
		for(int i = 1; i < n; i++) {			
			for(int j = 0; j < n; j++) {
				if(j == 0) {
					dp[i][0] = dp[i-1][0] + arr[i][0];
				}else {
					int max = Math.max(dp[i-1][j-1], dp[i-1][j]);		
					dp[i][j] = max + arr[i][j];
				}
				
			}
		}

		
		
		int result = dp[n-1][0];
		for(int i = 1; i < n; i++) {
			 result = Math.max(result, dp[n-1][i]);
		}
		
		System.out.println(result);

	}

}
