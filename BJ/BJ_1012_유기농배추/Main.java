
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int M,N,K,fx,fy;
	static int[][] field;
	static boolean[][] visited;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static StringTokenizer st;
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			M = Integer.parseInt(st.nextToken());//배추밭 가로 길이
		    N = Integer.parseInt(st.nextToken()); //배추밭 세로 길이
			K = Integer.parseInt(st.nextToken()); //배추의 수
			
			field = new int[M][N];
			visited = new boolean[M][N];
			
			for(int i = 0; i < K; i++) { //배추 위치 설정
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				
				field[x][y] = 1;
			}
			
			
			int count = 0;
			for(int i = 0; i < M; i++) {
				for(int j = 0; j < N; j++) {
					if(field[i][j] == 1 && !visited[i][j]) {
						count++; //배추흰지렁이 추가
						BFS(i,j);
					}
				}
			}
			
			System.out.println(count);
			
					
		}
		

	}


	private static void BFS(int x, int y) {
		Queue<Point> que = new LinkedList<>();
		que.add(new Point(x,y));
		visited[x][y] = true;
		
		while(!que.isEmpty()) {
			Point q = que.poll();
			
			for(int i = 0; i < 4; i++) { //4방 탐색
				int nx = q.x + dx[i];
				int ny = q.y + dy[i];
				
				if(nx < 0 || nx >= M || ny < 0 || ny >= N || field[nx][ny] == 0 || visited[nx][ny])continue; //범위 확인
				
				que.add(new Point(nx,ny));
				visited[nx][ny] = true;
				
				
			}
			
		}
		//count++; //배추흰지렁이 수 추가
 		
	}

}
