import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[][] arr = new int[9][9];
	static boolean possible;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 9; i++) {
			String[] str = br.readLine().split("");
			for (int j = 0; j < 9; j++) {
				arr[i][j] = Integer.parseInt(str[j]);
			}
		}

		dfs(0);

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}

	}

	private static void dfs(int d) {

		if (d == 81) {
			possible = true;
			return;
		}

		int r = d / 9; // row
		int c = d % 9; // column

		if (arr[r][c] != 0) // 값이 존재하면 다음으로
			dfs(d + 1);
		else {
			for (int i = 1; i < 10; i++) {
				if (!isValid(r, c, i))
					continue;//
				arr[r][c] = i;
				dfs(d + 1);

				if (possible)
					return;
				arr[r][c] = 0;

			}
		}

	}

	private static boolean isValid(int r, int c, int n) {

		for (int i = 0; i < 9; i++) { // 가로 세로 각 줄에 동일값이 존재하는 지 확인
			if (arr[i][c] == n || arr[r][i] == n)
				return false;
		}

		int sr = r / 3 * 3;
		int sc = c - c % 3;
		for (int row = sr; row < sr + 3; row++) { // 3*3칸 안에 동일값 있는지 확인
			for (int col = sc; col < sc + 3; col++) {
				if (arr[row][col] == n)
					return false;
			}
		}

		return true;

	}

}
