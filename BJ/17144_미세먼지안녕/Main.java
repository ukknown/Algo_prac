import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_17144_미세먼지안녕_최종욱 {
	static int R,C,T, sum;	
	static int[][] space;
	static int[][] arr;
	static ArrayList<Point> air;
	static boolean[][] visited;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};

	
	static void dust() {
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(visited[i][j]) {
					int d = arr[i][j]/5;
					for(int k = 0; k < 4; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];
						if(nx >= 0 && nx < R && ny >= 0 && ny < C && space[nx][ny] != -1) {
							space[nx][ny] += d;
							space[i][j] -= d; 	
						}
					}
					visited[i][j] = false;
				}
			}
		}
		return;
	}
	
	static void airclean() { //위쪽 청정기는 반시계, 아래 청정기는 시계 방향 공기 회전
		for(int i = 0; i < air.size(); i++) {
			if(i == 0) {
				int x = air.get(i).x;
				int y = air.get(i).y;
				
				space[x][y] = 0;	
				
				for(int j = x-1; j >= 0; j-- ) {
					space[j+1][0] = space[j][0];
				}
				for(int j = 1; j < C; j++) {
					space[0][j-1] = space[0][j];
				}
				for(int j = 1; j <= x; j++ ) {
					space[j-1][C-1] = space[j][C-1];
				}
				for(int j = C-2; j >= 0; j--) {
					space[x][j+1] = space[x][j];
				}
				
				space[x][y+1] = 0;
				space[x][y] = -1;
								
			}
			else if(i == 1) {
				int x = air.get(i).x;
				int y = air.get(i).y;
				
				space[x][y] = 0;
				
				for(int j = x+1; j < R; j++ ) {
					space[j-1][0] = space[j][0];
				}
				for(int j = 1; j < C; j++) {
					space[R-1][j-1] = space[R-1][j];
				}
				for(int j = R-2; j >= x; j--) {
					space[j+1][C-1] = space[j][C-1];
				}
				for(int j = C-2; j >= 0; j--) {
					space[x][j+1] = space[x][j];
				}
				
				space[x][y+1] = 0;	
				space[x][y] = -1;
			}
		}				
		return;
	}
	
	static void location() {
		for(int j = 0; j < R; j++) {
			for(int k = 0; k < C; k++) {
				if(space[j][k] != 0 && space[j][k] != -1) {
					visited[j][k] = true;
				}
			}
		}
		return;		
	}
	
	static void spacecopy() {
		for(int i = 0; i < R; i++) {
			arr[i] = space[i].clone();
		}
		return;
	}
	
	static void count() {
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(space[i][j] !=0 && space[i][j] != -1 ) {
					sum += space[i][j];
				}
			}
		}		
		return;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		//공간 크기와 진행될 초 값 입력
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		//공간 초기화
		space = new int[R][C];//집 크기
		arr = new int[R][C];  //미세먼지 양과 위치를 저장할 배열
		visited = new boolean[R][C]; //확장 전 미세먼지 위치 확인할 배열
		air = new ArrayList<Point>(); //공기정정기 위치 저장할 리스트
		
		//미세먼지 양 입력
		for(int i = 0; i < R; i++) { 
			st = new StringTokenizer(bf.readLine());
			for(int j = 0; j < C; j++) {
				space[i][j] = Integer.parseInt(st.nextToken());
				if(space[i][j] == -1) {
					air.add(new Point(i,j));
				}
			}
		}
		
		for(int i = 0; i < T; i++) {
			spacecopy(); //집 미세먼지 위치에 양 arr에 복사				
			location();  //미세먼지 위치
			dust();      //미세전지 확산
			airclean();  //공기정정기 가동
		}
		count();
		System.out.println(sum);	
		
	}
}
