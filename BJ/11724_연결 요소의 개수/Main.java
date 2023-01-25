

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] arr;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(st.nextToken()); //정점의 갯수
		M = Integer.parseInt(st.nextToken()); //간선의 갯수
		
		arr = new int[N+1][N+1]; //간선 연결정보 저장할 배열
		visited = new boolean[N+1]; //간선 연결 여부 확인
		
		for(int i = 0 ; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			arr[r][c] = 1;
			arr[c][r] = 1;
		}
		
		int count = 0;
		
		for(int i = 1; i <= N; i++) { 
			if(!visited[i]) {//방문하지 않은 정점 확인
				dfs(i);
				count++;
			}
			
		}
		
		System.out.println(count);
		

	}

	private static void dfs(int r) {
		visited[r] = true;	
				
		for(int i = 1; i <= N; i++) {
			if(arr[r][i] == 1 && !visited[i]) {
				dfs(i);
			}
		}
		
	}

}
