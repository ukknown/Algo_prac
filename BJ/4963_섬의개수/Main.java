import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static StringTokenizer st;
	static int w,h,count;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = {-1,-1,0,1,1,1,0,-1}; //8방 탑색(대각선도 연결된 섬으로 본다)
	static int[] dy = {0,1,1,1,0,-1,-1,-1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		while(true) { 
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if(w == 0 && h == 0)break;// 0 0이 입력될 때 까지
			
			arr = new int[h][w];//섬 정보 입력 받을 필드
			visited = new boolean[h][w]; //방문여부
			count = 0; //섬의 개수
			

				
		
				for(int i = 0 ; i < h; i++) { //섬 정보 입력
					st = new StringTokenizer(br.readLine());
					for(int j = 0; j < w; j++) {
						arr[i][j] = Integer.parseInt(st.nextToken());
					}		
				}
										
				for(int i = 0; i < h; i++) { //연결된 섬 확인
					for(int j = 0; j < w; j++) {
						if(arr[i][j] == 1 && !visited[i][j]) { //섬이고 방문한 적 없다면
							bfs(i,j);
						}
						
					}
				}
				
				System.out.println(count);
								
			}			
		}

	private static void bfs(int x, int y) {
		Queue<Point> que = new LinkedList<Point>();
		que.add(new Point(x,y));
		visited[x][y] = true;
		
		while(!que.isEmpty()) {
			Point q = que.poll();
			
			for(int i = 0; i < 8; i++) { //8방 탐색
				int nx = q.x + dx[i];
				int ny = q.y + dy[i];
				
				if(nx < 0 || nx >= h || ny < 0 || ny >= w || arr[nx][ny] == 0 || visited[nx][ny])continue; //필드 범위 확인
				
				que.add(new Point(nx,ny)); //연결된 섬 추가
				visited[nx][ny] = true;
			}
		}
		
		count += 1; //while을 끝내면 섬 1개
		
		
		
	}

}
