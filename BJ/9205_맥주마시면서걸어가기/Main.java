

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static Point mans, destin;
	static Point[] store;
	static boolean flag;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));	
		int T = Integer.parseInt(bf.readLine());
		
		for(int tc = 0; tc < T; tc++) {
			n = Integer.parseInt(bf.readLine());//편의점 수
			store = new Point[n];
			visited = new boolean[n];
			flag = false;
			
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int xmans = Integer.parseInt(st.nextToken());
			int ymans = Integer.parseInt(st.nextToken());
			mans = new Point(xmans, ymans); //상근이네
			
			for(int i = 0; i < n; i ++) { 
				st = new StringTokenizer(bf.readLine());
				int xstore = Integer.parseInt(st.nextToken());
				int ystore = Integer.parseInt(st.nextToken());
				store[i] = new Point(xstore, ystore); //편의점 위치
			}
			
			st = new StringTokenizer(bf.readLine());
			int xdestin = Integer.parseInt(st.nextToken());
			int ydestin = Integer.parseInt(st.nextToken());
			
			destin = new Point(xdestin, ydestin); //축제위치
			
			search(mans.x, mans.y);
			
			if(flag) {
				System.out.println("happy");
			}else {
				System.out.println("sad");
			}
			
		}
	}

	private static void search(int curX, int curY) {
		if(flag) return; //이미 가는게 가능하면 끝냄
		
		if(Math.abs(curX - destin.x) + Math.abs(curY - destin.y) <= 1000) { // 상근이네에서 축제까지 맥주 20병으로 가능하면 끝
			flag =true;
			return;
		}
		
		for(int i = 0; i < n; i++) { //상근이네 -> 상점 -> 축제 계산
			if(visited[i]) continue;
			
			if(Math.abs(curX - store[i].x) + Math.abs(curY - store[i].y) > 1000)continue;
			
			visited[i] =true; //방문한 상점 처리
			search(store[i].x, store[i].y);
			
		}
		
	}

}
