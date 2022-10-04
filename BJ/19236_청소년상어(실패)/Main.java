import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class info implements Comparable<info>{
		int x;
		int y;
		int num;
		int dir;
		public info(int x, int y, int num, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.num = num;
			this.dir = dir;
		}
		@Override
		public int compareTo(info o) {
			// TODO Auto-generated method stub
			return this.num - o.num;
		}
		
		
		
		
	}
	static info[][] field;
	static info[] turn;
	static info s;
	static int[][] d = {{0,0}, {-1,0},{-1,-1},{0,-1},{1,-1},{1,0},{1,1},{0,1},{-1,1}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		field = new info[4][4];
		turn = new info[16];
		
		int k = 0;
		for(int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < 4; j++) {
				int num = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				field[i][j] = new info(i, j, num, dir);
				turn[k]= new info(i,j,num,dir);
				k++;
			}
		}
		Arrays.sort(turn);
//		for(int i = 0; i < 16; i++) {
//			System.out.print(turn[i].num + " ");
//		}
//		=1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 
		
		
//		for(int i = 0; i < 4; i++) {
//			for(int j = 0; j < 4; j++) {
//				System.out.print(field[i][j].num + " ");
//			}
//			System.out.println();
//		}
		Smove(0,0,17,0);
		System.out.println(s.num);

	}


	private static void Smove(int x, int y, int num, int dir) {
		info f;
		switch(dir) {
		case 0:
			s = new info(x, y, num + field[x][y].num, field[x][y].dir);
			eat(field[x][y].num);
			field[x][y] = new info(x,y,17,0);
			fmove();			
			f = find(x,y,field[x][y].dir);
			if(f.num != 0) {
				field[x][y] = new info(x,y,0,0);
				Smove(f.x, f.y, f.num, f.dir);
			}else {
				return;
			}			
			break;
		case 1:
			s = new info(x, y, num + field[x][y].num, field[x][y].dir);
			eat(field[x][y].num);
			field[x][y] = new info(x,y,17,0);
			fmove();			
			f = find(x,y,field[x][y].dir);
			if(f.num != 0) {
				field[x][y] = new info(x,y,0,0);
				Smove(f.x, f.y, f.num, f.dir);
			}else {
				return;
			}		
			break;
		case 2:
			s = new info(x, y, num + field[x][y].num, field[x][y].dir);
			eat(field[x][y].num);
			field[x][y] = new info(x,y,17,0);
			fmove();			
			f = find(x,y,field[x][y].dir);
			if(f.num != 0) {
				field[x][y] = new info(x,y,0,0);
				Smove(f.x, f.y, f.num, f.dir);
			}else {
				return;
			}		
			break;
		case 3:
			s = new info(x, y, num + field[x][y].num, field[x][y].dir);
			eat(field[x][y].num);
			field[x][y] = new info(x,y,17,0);
			fmove();			
			f = find(x,y,field[x][y].dir);
			if(f.num != 0) {
				field[x][y] = new info(x,y,0,0);
				Smove(f.x, f.y, f.num, f.dir);
			}else {
				return;
			}		
			break;
		case 4:
			s = new info(x, y, num + field[x][y].num, field[x][y].dir);
			eat(field[x][y].num);
			field[x][y] = new info(x,y,17,0);
			fmove();			
			f = find(x,y,field[x][y].dir);
			if(f.num != 0) {
				field[x][y] = new info(x,y,0,0);
				Smove(f.x, f.y, f.num, f.dir);
			}else {
				return;
			}		
			break;
		case 5:
			s = new info(x, y, num + field[x][y].num, field[x][y].dir);
			eat(field[x][y].num);
			field[x][y] = new info(x,y,17,0);
			fmove();			
			f = find(x,y,field[x][y].dir);
			if(f.num != 0) {
				field[x][y] = new info(x,y,0,0);
				Smove(f.x, f.y, f.num, f.dir);
			}else {
				return;
			}		
			break;
		case 6:
			s = new info(x, y, num + field[x][y].num, field[x][y].dir);
			eat(field[x][y].num);
			field[x][y] = new info(x,y,17,0);
			fmove();			
			f = find(x,y,field[x][y].dir);
			if(f.num != 0) {
				field[x][y] = new info(x,y,0,0);
				Smove(f.x, f.y, f.num, f.dir);
			}else {
				return;
			}		
			break;
		case 7:
			s = new info(x, y, num + field[x][y].num, field[x][y].dir);
			eat(field[x][y].num);
			field[x][y] = new info(x,y,17,0);
			fmove();			
			f = find(x,y,field[x][y].dir);
			if(f.num != 0) {
				field[x][y] = new info(x,y,0,0);
				Smove(f.x, f.y, f.num, f.dir);
			}else {
				return;
			}		
			break;
		case 8:
			s = new info(x, y, num + field[x][y].num, field[x][y].dir);
			eat(field[x][y].num);
			field[x][y] = new info(x,y,17,0);
			fmove();			
			f = find(x,y,field[x][y].dir);
			if(f.num != 0) {
				field[x][y] = new info(x,y,0,0);
				Smove(f.x, f.y, f.num, f.dir);
			}else {
				return;
			}		
			break;
				
		}
	}


	private static info find(int x, int y, int i) {
		int dx = 0;
		int dy = 0;
		int max = Integer.MIN_VALUE;
		switch(i) {
		case 1:
			dx = x + d[i][0];
			dy = x + d[i][1];
			if(dx < 0 && field[dx][dy].num == 0 ) {
				return new info(dx,dy,0,0);
			}else {
				while(dx>=0) {
				int a = field[dx][dy].num;
				max = Math.max(max, a);
			}
			}
						
			break;
		case 2:
			dx = x + d[i][0];
			dy = x + d[i][1];
			while(dx >= 0 && dy >= 0) {
				int a = field[dx][dy].num;
				max = Math.max(max, a);
			}
			break;
		case 3:
			dx = x + d[i][0];
			dy = x + d[i][1];
			while(dy >= 0) {
				int a = field[dx][dy].num;
				max = Math.max(max, a);
			}
			break;
		case 4:
			dx = x + d[i][0];
			dy = x + d[i][1];
			while(dx < 4 && dy >= 0) {
				int a = field[dx][dy].num;
				max = Math.max(max, a);
			}
			break;
		case 5:
			dx = x + d[i][0];
			dy = x + d[i][1];
			while(dx < 4) {
				int a = field[dx][dy].num;
				max = Math.max(max, a);
			}
			break;
		case 6:
			dx = x + d[i][0];
			dy = x + d[i][1];
			while(dx < 4 && dy < 4) {
				int a = field[dx][dy].num;
				max = Math.max(max, a);
			}
			break;
		case 7:
			dx = x + d[i][0];
			dy = x + d[i][1];
			while(dy < 4) {
				int a = field[dx][dy].num;
				max = Math.max(max, a);
			}
			break;
		case 8:
			dx = x + d[i][0];
			dy = x + d[i][1];
			while(dx>=0 && dy < 4) {
				int a = field[dx][dy].num;
				max = Math.max(max, a);
			}
			break;
				
		}
		return new info(dx,dy,field[dx][dy].num, field[dx][dy].dir);
		
	}


	private static void eat(int num) {
		for(int i = 0; i < 16; i++) {
			if(turn[i].num == num) {
				turn[i] = new info(0,0,0,0);
			}
		}
		
	}


	private static void fmove() {
		for(int i = 0; i < 16; i++) {
			if(turn[i].num != 0) {
				exchange(i);				
			}
		}
		
	}


	private static void exchange(int i) {
		int nx;
		int ny;
		switch(turn[i].dir) {
		case 1:
			nx = turn[i].x + d[i][0];
			ny = turn[i].y + d[i][1];
			if(nx >=0 && nx < 4 && ny >= 0 && ny < 4 && field[nx][ny].num >= 17) {
				info temp = new info(field[nx][ny].x, field[nx][ny].y, field[nx][ny].num , field[nx][ny].dir);
				field[nx][ny] = new info(nx, ny, turn[i].num, turn[i].dir);
				field[turn[i].x][turn[i].y] = new info(turn[i].x, turn[i].y, temp.num,temp.dir); 
			}else {	
				if(turn[i].dir == 8) {
					turn[i].dir = 1;
					exchange(i);
				}else {
					turn[i].dir += 1;
					exchange(i);
				}
								
			}			
			break;
		case 2:
			nx = turn[i].x + d[i][0];
			ny = turn[i].y + d[i][1];
			if(nx >=0 && nx < 4 && ny >= 0 && ny < 4 && field[nx][ny].num >= 17) {
				info temp = new info(field[nx][ny].x, field[nx][ny].y, field[nx][ny].num , field[nx][ny].dir);
				field[nx][ny] = new info(nx, ny, turn[i].num, turn[i].dir);
				field[turn[i].x][turn[i].y] = new info(turn[i].x, turn[i].y, temp.num,temp.dir); 
			}else {
				if(turn[i].dir == 8) {
					turn[i].dir = 1;
					exchange(i);
				}else {
					turn[i].dir += 1;
					exchange(i);
				}				
			}
			break;
		case 3:
			nx = turn[i].x + d[i][0];
			ny = turn[i].y + d[i][1];
			if(nx >=0 && nx < 4 && ny >= 0 && ny < 4 && field[nx][ny].num >= 17) {
				info temp = new info(field[nx][ny].x, field[nx][ny].y, field[nx][ny].num , field[nx][ny].dir);
				field[nx][ny] = new info(nx, ny, turn[i].num, turn[i].dir);
				field[turn[i].x][turn[i].y] = new info(turn[i].x, turn[i].y, temp.num,temp.dir); 
			}else {
				if(turn[i].dir == 8) {
					turn[i].dir = 1;
					exchange(i);
				}else {
					turn[i].dir += 1;
					exchange(i);
				}				
			}
			break;
		case 4:
			nx = turn[i].x + d[i][0];
			ny = turn[i].y + d[i][1];
			if(nx >=0 && nx < 4 && ny >= 0 && ny < 4 && field[nx][ny].num >= 17) {
				info temp = new info(field[nx][ny].x, field[nx][ny].y, field[nx][ny].num , field[nx][ny].dir);
				field[nx][ny] = new info(nx, ny, turn[i].num, turn[i].dir);
				field[turn[i].x][turn[i].y] = new info(turn[i].x, turn[i].y, temp.num,temp.dir); 
			}else {
				if(turn[i].dir == 8) {
					turn[i].dir = 1;
					exchange(i);
				}else {
					turn[i].dir += 1;
					exchange(i);
				}			
			}
			break;
		case 5:
			nx = turn[i].x + d[i][0];
			ny = turn[i].y + d[i][1];
			if(nx >=0 && nx < 4 && ny >= 0 && ny < 4 && field[nx][ny].num >= 17) {
				info temp = new info(field[nx][ny].x, field[nx][ny].y, field[nx][ny].num , field[nx][ny].dir);
				field[nx][ny] = new info(nx, ny, turn[i].num, turn[i].dir);
				field[turn[i].x][turn[i].y] = new info(turn[i].x, turn[i].y, temp.num,temp.dir); 
			}else {
				if(turn[i].dir == 8) {
					turn[i].dir = 1;
					exchange(i);
				}else {
					turn[i].dir += 1;
					exchange(i);
				}			
			}
			break;
		case 6:
			nx = turn[i].x + d[i][0];
			ny = turn[i].y + d[i][1];
			if(nx >=0 && nx < 4 && ny >= 0 && ny < 4 && field[nx][ny].num >= 17) {
				info temp = new info(field[nx][ny].x, field[nx][ny].y, field[nx][ny].num , field[nx][ny].dir);
				field[nx][ny] = new info(nx, ny, turn[i].num, turn[i].dir);
				field[turn[i].x][turn[i].y] = new info(turn[i].x, turn[i].y, temp.num,temp.dir); 
			}else {
				if(turn[i].dir == 8) {
					turn[i].dir = 1;
					exchange(i);
				}else {
					turn[i].dir += 1;
					exchange(i);
				}			
			}
			break;
		case 7:
			nx = turn[i].x + d[i][0];
			ny = turn[i].y + d[i][1];
			if(nx >=0 && nx < 4 && ny >= 0 && ny < 4 && field[nx][ny].num >= 17) {
				info temp = new info(field[nx][ny].x, field[nx][ny].y, field[nx][ny].num , field[nx][ny].dir);
				field[nx][ny] = new info(nx, ny, turn[i].num, turn[i].dir);
				field[turn[i].x][turn[i].y] = new info(turn[i].x, turn[i].y, temp.num,temp.dir); 
			}else {
				if(turn[i].dir == 8) {
					turn[i].dir = 1;
					exchange(i);
				}else {
					turn[i].dir += 1;
					exchange(i);
				}			
			}
			break;
		case 8:
			nx = turn[i].x + d[i][0];
			ny = turn[i].y + d[i][1];
			if(nx >=0 && nx < 4 && ny >= 0 && ny < 4 && field[nx][ny].num >= 17) {
				info temp = new info(field[nx][ny].x, field[nx][ny].y, field[nx][ny].num , field[nx][ny].dir);
				field[nx][ny] = new info(nx, ny, turn[i].num, turn[i].dir);
				field[turn[i].x][turn[i].y] = new info(turn[i].x, turn[i].y, temp.num,temp.dir); 
			}else {
				if(turn[i].dir == 8) {
					turn[i].dir = 1;
					exchange(i);
				}else {
					turn[i].dir += 1;
					exchange(i);
				}			
			}
			break;
				
		}
		
	}

}
