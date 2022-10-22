import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] dp = new int[n + 1];
		int[] arr = new int[n + 1];

		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + 1;
			arr[i] = i - 1;
			if (i % 2 == 0) {
				if (dp[i] > dp[i / 2] + 1) {
					arr[i] = i / 2;
				}
				dp[i] = Math.min(dp[i], dp[i / 2] + 1);

			}
			if (i % 3 == 0) {
				if (dp[i] > dp[i / 3] + 1) {
					arr[i] = i / 3;
				}
				dp[i] = Math.min(dp[i], dp[i / 3] + 1);

			}
		}

		if (n == 1) {
			System.out.println(0);
			System.out.println(1);
		} else {
			System.out.println(dp[n]);

			System.out.print(n + " ");

			int a = arr[n];
			int b = 0;

			if (n == 1) {
				System.out.println(0);
				System.out.println(1);
			}
			while (true) {
				if (a == 1) {
					System.out.println(a);
					break;
				}
				System.out.print(a + " ");

				b = arr[a];

				a = b;

			}
		}

	}

}
