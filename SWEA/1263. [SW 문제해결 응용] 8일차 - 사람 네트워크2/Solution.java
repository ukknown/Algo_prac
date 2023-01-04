
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static final int INF = 9999999;
	static int[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());

			int N = Integer.parseInt(st.nextToken());

			arr = new int[N][N];

			for (int i = 0; i < N; i++) { //거리 입력
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if (i != j && arr[i][j] == 0) { //자기 자신은 제외하고, 연결되있지않은 정점 거리는 INF
						arr[i][j] = INF;
					}
				}
			}

			for (int k = 0; k < N; ++k) { // 플로이드 워샬
				for (int i = 0; i < N; ++i) {
					if (k == i)
						continue;
					for (int j = 0; j < N; ++j) {
						if (i == j || k == j)
							continue;
						arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
					}
				}
			}

			int min = Integer.MAX_VALUE;

			for (int i = 0; i < N; i++) { //정점에서 갈 수 있는 정점들의 합
				 int sum = 0;
				 for(int j = 0 ; j < N; j++) {
					sum += arr[i][j];
				 }
				 min = Math.min(min, sum); //합들의 최솟값
			 }

			 
			 System.out.println("#" + tc + " " + min);
			 
			 
		 }

	}

}
