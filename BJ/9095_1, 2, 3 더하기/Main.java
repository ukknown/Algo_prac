import java.util.Scanner;

public class Main {
	static int n,count;;
	static int[] num = {0,1,2,3};
	static int[] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc<=T; tc++) {
			n = sc.nextInt();
			
			dp = new int[11];
			
			dp[1] = 1;
			dp[2] = 2;
			dp[3] = 4;
			
			for(int i = 4; i < 11; i++) {
				dp[i] = dp[i-1] + dp[i-2] + dp[i-3]; //점화식
			}
			
			System.out.println(dp[n]);
					
		}

	}


}
