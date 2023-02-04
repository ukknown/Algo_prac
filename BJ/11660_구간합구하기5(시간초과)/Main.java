//시간초과 발생
//N^2(1024*1024) * M(10만)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); //표의 크기
		M = Integer.parseInt(st.nextToken()); //합을 구할 회수
		
		arr = new int[N][N];
		
		for(int i = 0; i < N; i++) { //표 
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int count = 0;
			
			for(int j = x1-1; j < x2; j++) { //제시된 구간 합 계산
				for(int k = y1-1; k < y2; k++) {
					count += arr[j][k];
				}
			}
			
			System.out.println(count);
			
			
		}
		
		

	}

}
