

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringTokenizer st;
	static int K,W,H, min;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int[] jx = {-2,-1,1,2,2,1,-1,-2};
	static int[] jy = {1,2,2,1,-1,-2,-2,-1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		K = Integer.parseInt(br.readLine()); //원숭이가 말의 움직임을 할 수 있는 횟수
		
		st = new StringTokenizer(br.readLine());
		
		W = Integer.parseInt(st.nextToken()); //격자판 가로길이
		H = Integer.parseInt(st.nextToken()); //격자판 세로길이
		
		arr = new int[H][W];
		visited = new boolean[H][W];
		
		for(int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < W; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		min = Integer.MAX_VALUE;
		
		dfs(0,0,0, K);
		
		if(min == Integer.MAX_VALUE) {
			System.out.println(-1); //도착점 도착 못할 때
		}else {
			System.out.println(min);
		}
		
		

	}

	private static void dfs(int x, int y, int dep, int jump) {
		if(x == H-1 && y == W-1) {
			min = Math.min(min, dep);
			
			return;
		}
		
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || nx >= H || ny < 0 || ny >= W || visited[nx][ny])continue; //범위 확인
			
			if(arr[nx][ny] == 1 && jump != 0) { //원숭이가 말 이동 방식 사용
				for(int j = 0; j < 8; j++) {
					int njx = x + jx[j];
					int njy = y + jy[j];
					
					//범위 확인
					if(njx < 0 || njx >= H || njy < 0 || njy >= W || visited[njx][njy] || arr[njx][njy] == 1)continue;
					
					visited[njx][njy] = true;
					dfs(njx,njy,dep+1,jump-1);
					visited[njx][njy] = false;
				}
						
			}
			
			if(arr[nx][ny] == 0) {
				//일반적인 이동
				visited[nx][ny] = true;
				dfs(nx,ny,dep+1,jump);
				visited[nx][ny] = false;
			}
			
			
		}
		
	}

}
