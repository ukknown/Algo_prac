
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static class micro implements Comparable<micro>{
		int x,y,count,dir,no;

		public micro(int x, int y, int count, int dir,int no){
			super();
			this.x = x;
			this.y = y;
			this.count = count;
			this.dir = dir;
			this.no = no;
		}

		@Override
		public int compareTo(micro o) {
			// TODO Auto-generated method stub
			return this.count - o.count;
		}
		
	}
	static StringTokenizer st;
	static int N,M,K;//셀의 수, 격리시간, 미생물 군집 개수
	static micro[] info;
	static ArrayList<micro> list;
	
	static int round = 0;
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());//셀의 수
			M = Integer.parseInt(st.nextToken());//격리 시간
			K = Integer.parseInt(st.nextToken());//군집의 수
			
			info = new micro[K];
			
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());//가로
				int c = Integer.parseInt(st.nextToken());//세로
				int n = Integer.parseInt(st.nextToken());//군집 내 미생물 수
				int d = Integer.parseInt(st.nextToken()); //이동방향
				
				info[i] = new micro(r,c,n,d,i); //미생물군집 정보			
			}
			int result = 0;
			for(int i = 0; i <K; i++) {
				result += info[i].count;
			}
			
//			System.out.println("시작 세포개수 : "+ result);
			
			
			for(int i = 0; i < M; i++) { //M시간 동안 진행
				round = i;
				move();			
			}
			
			int sum = 0;
			for(int i = 0; i <K; i++) {
				sum += info[i].count;
			}
			
			System.out.println("#" + tc + " " + sum);			
		}
	}


	private static void move() {		
		for(int i = 0; i < K; i++) {
			if(info[i].count != 0) {
				switch(info[i].dir) {
				case 1: //상
					info[i].x -= 1;				
					break;
				case 2: //하
					info[i].x += 1;				
					break;
				case 3: //좌
					info[i].y -= 1;				
					break;
				case 4: //우
					info[i].y += 1;				
					break;
				}
			}		
		}
		
		renew();//군집 재설정
		
	}


	private static void renew() {
		for(int i = 0; i < K; i++) {
			if(info[i].count == 0) {
				continue;//없어진 군집이면 넘어감
			}
			//약품구역에 도달
			else if(info[i].x == 0 || info[i].x == N-1 || info[i].y == 0 || info[i].y == N-1) {
				info[i].count = info[i].count/2; //절반 제거
				switch(info[i].dir) { //방향 반대방향
				case 1:
					info[i].dir = 2;
					break;
				case 2:
					info[i].dir = 1;
					break;
				case 3:
					info[i].dir = 4;
					break;
				case 4:
					info[i].dir = 3;
					break;
					
				}
			}
			micro cell = info[i];
			list = new ArrayList<>();
			for(int j = i+1; j < K; j++) {
				if(info[j].count == 0)continue;
				//동일한 위치에 군집이 모임
				if((info[i].x == info[j].x) && (info[i].y == info[j].y)) {
					if(list.size() == 0) {
						list.add(info[i]);
						list.add(info[j]);	
					}else {
						list.add(info[j]);
					}
				}
			}
			
			microsum();//동일한 지점에 모이는 군체 합침
		}
		
	}


	private static void microsum() {
		Collections.sort(list);//오름차순 정렬
		int resultsum = 0;
		for(int i = 0; i < list.size(); i++) { //가장 많은 군체에게 모두 흡수
			resultsum += list.get(i).count;
			if(i < list.size()-1) { 
				info[list.get(i).no].count = 0;
			}else {
				info[list.get(i).no].count = resultsum;
			}
		}
		
	}

}
