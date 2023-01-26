import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M, result;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static class info {
		int x;
		int y;
		int count;
		public info(int x, int y, int count) {
			super();
			this.x = x; //
			this.y = y;
			this.count = count; //지나야하는 칸
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); //미로의 크기
		M = Integer.parseInt(st.nextToken()); 
		
		arr = new int[N][M]; //미로
		visited = new boolean[N][M]; //방문처리로 갔던 곳 또 안가도록 
		
		for(int i = 0; i < N; i++) {  //미로 설정
			String[] str = br.readLine().split("");
			for(int j = 0; j < str.length; j++) {
				arr[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		
		bfs(0,0,1);
		
		System.out.println(result);
		

	}

	private static void bfs(int r, int c, int n) {
		Queue<info> que = new LinkedList<info>();
		visited[r][c] = true;
		que.add(new info(r,c,n));
		
		while(!que.isEmpty()) {
			info q = que.poll();
			
			if(q.x == N-1 && q.y == M-1) { //목적지 도착
				result = q.count;
			}
			for(int i = 0; i < 4; i++) { //4방 탐색
				int nx = q.x + dx[i];
				int ny = q.y + dy[i];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M || arr[nx][ny] == 0 || visited[nx][ny])continue; //범위 체크
				
				que.add(new info(nx, ny, q.count +1)); //다음 칸 이동
				visited[nx][ny] = true; //방문처리
				
			}
			
		}
		
		
		
		
	}

}
