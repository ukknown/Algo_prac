import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SW_4013_특이한자석_최종욱 {
	static int n, m, sum;
	static int K;
	static ArrayList<Integer>[] magnet;
	static ArrayList<Integer>[] magnet2;
	static ArrayList<Point> turn;

	static void copy() {//변화된 톱니 위치 저장
		for (int i = 1; i <= n; i++) {
			magnet[i] = (ArrayList<Integer>) magnet2[i].clone();
		}
	}

	static void count() {//빨간 화살표 위치 값들의 합 
		for (int i = 1; i <= n; i++) {
			if (i == 1) {
				switch (magnet[i].get(0)) {
				case 0:
					sum += 0;
					break;
				case 1:
					sum += 1;
					break;
				}
			} else if (i == 2) {
				switch (magnet[i].get(0)) {
				case 0:
					sum += 0;
					break;
				case 1:
					sum += 2;
					break;
				}
			} else if (i == 3) {
				switch (magnet[i].get(0)) {
				case 0:
					sum += 0;
					break;
				case 1:
					sum += 4;
					break;
				}
			} else if (i == 4) {
				switch (magnet[i].get(0)) {
				case 0:
					sum += 0;
					break;
				case 1:
					sum += 8;
					break;
				}
			}
		}
		return;
	}

	static void Rotation(int num, int dir) {
		switch (dir) {
		case 1:
			spin(num);
			break;
		case -1:
			reverse_spin(num);
			break;

		}
	}
	static void spin(int num) {//첫 시계 시계 회전
		int two = 0, three = 0;
		switch (num) {
		case 1:
			right(1);
			if (magnet[1].get(2) != magnet[2].get(6)  ) {
				left(2);
				two = 1;
			}

			if (magnet[2].get(2) != magnet[3].get(6) && two == 1) {
				right(3);
				three = 1;
			}

			if (magnet[3].get(2) != magnet[4].get(6) && three == 1) {
				left(4);
			}
			break;
		case 2:
			right(2);
			if(magnet[2].get(6) != magnet[1].get(2)) {
				left(1);
			}
			
			if (magnet[2].get(2) != magnet[3].get(6)) {
				left(3);
				three = 1;
			}

			if (magnet[3].get(2) != magnet[4].get(6) && three == 1) {
				right(4);
			}
			break;
		case 3:
			right(3);
			if (magnet[3].get(2) != magnet[4].get(6)) {
				left(4);
			}			
			if (magnet[2].get(2) != magnet[3].get(6) ) {
				left(2);
				two = 1;
			}			
			if(magnet[1].get(2) != magnet[2].get(6)  && two == 1) {
				right(1);
			}			
			break;
		case 4:
			right(4);
			if (magnet[3].get(2) != magnet[4].get(6)) {
				left(3);
				three = 1;
			}
			if (magnet[2].get(2) != magnet[3].get(6) && three == 1) {
				right(2);
				two = 1;
			}
			if (magnet[1].get(2) != magnet[2].get(6) && two == 1) {
				left(1);
			}
			break;
		}
		return;
	}
	
	static void reverse_spin(int num) {//첫 톱니 반시계 회전
		int two = 0, three = 0;
		switch (num) {
		case 1:
			left(1);
			if (magnet[2].get(6) != magnet[1].get(2)) {
				right(2);
				two = 1;
			}

			if (magnet[2].get(2) != magnet[3].get(6) && two == 1) {
				left(3);
				three = 1;
			}

			if (magnet[3].get(2) != magnet[4].get(6) && three == 1) {
				right(4);
			}
			break;
		case 2:
			left(2);
			if( magnet[1].get(2) != magnet[2].get(6) ) {
				right(1);
			}
			
			if (magnet[2].get(2) != magnet[3].get(6)) {
				right(3);
				three = 1;
			}
			
			if (magnet[3].get(2) != magnet[4].get(6) && three == 1) {
				left(4);
			}
			break;
		case 3:
			left(3);
			if (magnet[3].get(2) != magnet[4].get(6)) {
				right(4);
			}			
			if (magnet[2].get(2) != magnet[3].get(6)) {
				right(2);
				two = 1;
			}			
			if(magnet[2].get(6) != magnet[1].get(2) && two == 1) {
				left(1);
			}			
			break;
		case 4:
			left(4);
			if (magnet[3].get(2) != magnet[4].get(6)) {
				right(3);
				three = 1;
			}
			if (magnet[2].get(2) != magnet[3].get(6) && three == 1) {
				left(2);
				two = 1;
			}
			if (magnet[1].get(2) != magnet[2].get(6) && two == 1) {
				right(1);
			}
			break;		
		}
		return;
	}

	static void right(int num) {//시계방향 회전
		int temp = magnet2[num].get(m - 1);
		magnet2[num].remove(m - 1);
		magnet2[num].add(0, temp);
		return;
	}

	static void left(int num) {//반시계방향 회전
		int temp = magnet2[num].get(0);
		magnet2[num].remove(0);
		magnet2[num].add(temp);

		return;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(bf.readLine());
			K = Integer.parseInt(st.nextToken());

			n = 4;//톱니 개수
			m = 8;//톱니 날 개수
			sum = 0;//마무리 후 빨간색 화살표에 있는 날 값들의 합
			magnet = new ArrayList[n + 1];//톱니 날 자석 정보
			magnet2 = new ArrayList[n + 1];

			for (int i = 0; i < n + 1; i++) {
				magnet[i] = new ArrayList<Integer>();
				magnet2[i] = new ArrayList<Integer>();
			}

			for (int i = 1; i <= n; i++) {//자석 정보 입력 - N = 0; S = 1;
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < m; j++) {
					int num = Integer.parseInt(st.nextToken());
					magnet[i].add(num);
					magnet2[i].add(num);
				}
			}

			turn = new ArrayList<Point>();

			for (int i = 0; i < K; i++) {//움직일 톱니 번호와 방향 저장할 배열
				st = new StringTokenizer(bf.readLine());
				int mag = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());

				turn.add(new Point(mag, dir));
			}

			for (int i = 0; i < K; i++) {//톱니 회전
				Rotation(turn.get(i).x, turn.get(i).y);
				copy();
			}
			
			count();

			System.out.println("#" + tc + " " + sum);

		}

	}
}
