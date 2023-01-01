import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	static StringTokenizer st;
	static int N, minline, maxCore;
	static int[][] map;
	static ArrayList<Point> list;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine()); //렉시노스 길이
			
			map = new int[N][N]; //렉시노스
			list = new ArrayList<Point>();
			
			for(int i = 0; i < N ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N ; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(i == 0 || i == N-1 || j == 0 || j == N-1)continue;
					
					list.add(new Point(i,j));
				}
			}
			
			
			minline = Integer.MAX_VALUE;
			maxCore = Integer.MIN_VALUE;
			line(0,0,0);
			
			System.out.println("#" + tc + " "+ minline);
			
			
			
		}

	}

	private static void line(int idx, int core, int line) {
		if(idx == list.size()) {
			if(maxCore < core) {
				maxCore = core;
				minline = line;
			}else if(maxCore == core){
				minline = Math.min(line, minline);
			}
			return;
		}
		
		//코어좌표
		int x = list.get(idx).x;
		int y = list.get(idx).y;
		
		//4방 탐색
		for(int dir = 0 ; dir < 4; dir++) {
			int count = 0;
			int nx = x; 
			int ny = y;
			
			while(true) {
				nx += dx[dir];
				ny += dy[dir];
				
				//범위에 있는지 확인
				if(nx < 0|| nx >= N || ny < 0 || ny >= N)break;
				
				//가는 길에 다른 코어 혹은 전선 존재하면 다른 방향으로
				if(map[nx][ny] == 1) {
					count = 0;
					break;
				}
				//아무것도 없으면 +1
				count += 1;
			}
			
			
			//count 수 만큼 1로 바꿔줌
			int fill_x = x;
			int fill_y = y;
			
			for(int i = 0; i < count; i++) {
				fill_x += dx[dir];
				fill_y += dy[dir];				
				map[fill_x][fill_y] = 1;
			}
			
			if(count == 0)line(idx+1, core, line);
			else {
				
				line(idx+1, core+1, line+count);
				
				fill_x = x;
				fill_y = y;
				for(int i = 0; i < count; i++) {
					fill_y += dy[dir];
					fill_x += dx[dir];
					map[fill_x][fill_y] = 0;
				}
			}
			
			
		}
		
	}

}
