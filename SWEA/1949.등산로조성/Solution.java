
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static class top{
		int x,y,h;
		public top(int x, int y, int h) {
			super();
			this.x = x;
			this.y = y;
			this.h = h;

		}
		
	}
	static StringTokenizer st;
	static int N,K;
	static ArrayList<top> start;
	static int[][] field;
	static boolean[][] visited;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int max;
	static int track;
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); //지도 한변 길이
			K = Integer.parseInt(st.nextToken()); //깎을 수 있는 깊이
			
			
			field = new int[N][N];
			visited = new boolean[N][N];
			track = Integer.MIN_VALUE;
			max = Integer.MIN_VALUE;
			
			for(int i = 0; i< N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {					
					field[i][j] = Integer.parseInt(st.nextToken());
					max = Math.max(max, field[i][j]);//최고 봉우리 찾기
				}
			}

			for(int i = 0; i< N; i++) {
				for(int j = 0; j < N; j++) {					
					if(field[i][j]==max) { //최고 봉우리에서 시작
						visited[i][j] = true;
						dfs(new top(i,j,field[i][j]),1,1);
						visited[i][j] = false;
					}
				}
			}
			
			System.out.println("#"+tc+" "+track);
			
		}
	}

	private static void dfs(top start, int cut, int length) {	
		track = Math.max(track, length); //최장거리 결정
		
		for(int i = 0; i < 4; i++) {
			int nx = start.x+dx[i];
			int ny = start.y+dy[i];
			//범위 밖이면 
			if(nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) continue; 
			
			visited[nx][ny] = true;
			
			if (field[nx][ny] < start.h) { //낮은 곳
				dfs(new top(nx, ny, field[nx][ny]), cut , length+1);
			}
			else { //산을 자른 적 없으면
				if (cut == 1 && (field[nx][ny] - start.h) < K)
                			dfs(new top(nx, ny, start.h-1), cut-1, length+1);
			}
			visited[nx][ny] = false;
		}
		
	}


}
