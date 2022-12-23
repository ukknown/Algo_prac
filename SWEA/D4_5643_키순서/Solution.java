import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N,M, tall_st, short_st, total;
	static int[][] arr;
	static boolean[] visited;
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(bf.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(bf.readLine()); //학생 수
			M = Integer.parseInt(bf.readLine()); // 키 비교
			
			arr = new int[N+1][N+1];
			
			for(int i = 0 ; i < M; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				arr[a][b] = 1;	//비교한 학생 조합 행렬에 표시			
			}

			total = 0;//본인보다 작은 학생과 큰 학생 수를 입력할 변수 
			for(int i = 1; i <= N; i++) {//본인보다 작은 학생과 큰 학생 수를 구하고 학생수와 비교
				tall_st = 0; 
				short_st = 0;
				taller(i, new boolean[N+1]);
				shorter(i, new boolean[N+1]);
				
				if(tall_st + short_st == N-1) {
					total += 1;
				}
			}
			System.out.println("#"+ tc + " "+total);
			
			
		}
	}

	private static void shorter(int cnt, boolean[] visited) { //본인보다 작은 사람 수 계산
		visited[cnt] = true;
		
		for(int i = 0; i <= N; i++ ) {
			if(!visited[i] && arr[i][cnt] == 1) { //column을 기준으로 row를 보면 본인보다 작은 사람
				shorter(i, visited);
				short_st += 1;
			}
		}
		
	}

	private static void taller(int cnt, boolean[] visited) { //본인보다 큰 사람 수 계산
		visited[cnt] = true;
		
		for(int i = 0; i <= N; i++ ) {
			if(!visited[i] && arr[cnt][i] == 1) { //row를 기준으로 column을 보면 본인보다 큰사람
				taller(i, visited);
				tall_st += 1;
			}
		}
		
		
	}

}
