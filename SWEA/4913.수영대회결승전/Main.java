
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static class info{
		int x;
		int y;
		int time;
		public info(int x, int y, int time) {
			super();
			this.x = x;
			this.y = y;
			this.time = time;
		}
		
	}
	static int N;
	static int[][] sea;
	static StringTokenizer st;
	static Point start, arrive;
	static boolean[][] visited;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
		
			sea = new int[N][N];
			visited = new boolean[N][N];
		
			for(int i = 0 ; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					sea[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			start = new Point(x,y); //출발점
	
			
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			arrive = new Point(x,y); //도착점
			
			int result = bfs();
			
			System.out.println("#"+ tc + " " + result);
		}		
	}

	private static int bfs() {
		Queue<info> que = new LinkedList<>();
		que.add(new info(start.x,start.y,0));
		visited[start.x][start.y] = true;
		
		while(!que.isEmpty()) {
			info q = que.poll();
			
			if(q.x == arrive.x && q.y == arrive.y) {
				return q.time;
			}
			
			for(int i = 0; i < 4; i++) {
				int nx = q.x + dx[i];
				int ny = q.y + dy[i];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= N)continue; //범위 밖이면 넘어감
				
				if(sea[nx][ny] == 1 )continue; //장애물은 그냥 넘어감
				
				if(sea[nx][ny] == 2 && !visited[nx][ny]) { //소용돌이 확인
					if(q.time%3 == 2) { // 2 5 8 .... 일 경우 이동 가능
						que.add(new info(nx,ny,q.time+1));
						visited[nx][ny] = true;
					}else { //그 외 이동 불가 대기
						que.add(new info(q.x, q.y, q.time+1));
					}					
				}else if(sea[nx][ny] == 0 && !visited[nx][ny]) { //바다면 이동
					que.add(new info(nx, ny, q.time+1));
					visited[nx][ny] = true;
				}
				
				
				
				
			}
		}
		
		return -1; //최종적으로 갈수없을 경우 
		
		
		
	}

}
