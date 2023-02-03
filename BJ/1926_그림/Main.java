import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int M,N,K,count, max, count_size;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static class info{
		int x;
		int y;
		int size;
		public info(int x, int y, int size) {
			super();
			this.x = x;
			this.y = y;
			this.size = size;
		}		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());//세로
		M = Integer.parseInt(st.nextToken());//가로
		
		arr = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) { //도화지 그림
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		count = 0;
		max = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(arr[i][j] == 1 && !visited[i][j]) { //그림이고 방문하지 않았다면
					count_size = 0; //사이즈 측정을 위해 0초기화
					count += 1; //그림 개수 + 1
					bfs(i,j,1);
				}
			}
		}
		
		System.out.println(count);
		System.out.println(max);		
	}

	private static void bfs(int x, int y, int size) {
		Queue<info> que = new LinkedList<info>();
		que.add(new info(x,y,size)); //그림 첫 값 추가
		visited[x][y] = true; //방문 처리
		count_size += 1; //그림 사이즈 추가
		
		while(!que.isEmpty()) {
			info q = que.poll();
			
			for(int i = 0; i < 4; i++) { //4방 탐색으로 그림 크기 확인
				int nx = q.x + dx[i];
				int ny = q.y + dy[i];
				
				//범위 체크
				if(nx < 0 || nx >= N || ny < 0 || ny >= M || arr[nx][ny] == 0 || visited[nx][ny])continue;
				
				que.add(new info(nx, ny, q.size + 1)); //연결된 그림 값 추가
				count_size += 1; //그림 사이즈 추가
				visited[nx][ny] = true; //방문처리
			}
		}
		
		max = Math.max(max, count_size); //그림 크기 최댓값 구하기
	}
}
