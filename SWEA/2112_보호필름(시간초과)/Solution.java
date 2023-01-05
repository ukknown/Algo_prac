import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static StringTokenizer st;
	static int D,W,K,count;
	static int[] choice;
	static int[] what;
	static int[][] film;
	static int[][] copy;
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());//보호필름 두께
			W = Integer.parseInt(st.nextToken());//가로크기
			K = Integer.parseInt(st.nextToken());//합격기준
			count = Integer.MAX_VALUE; //약품 투입 횟수
			
			film = new int[D][W]; //확인할 보호 필름
			copy = new int[D][W];
			
			
			for(int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < W; j++) {
					film[i][j] = Integer.parseInt(st.nextToken());
					copy[i][j] = film[i][j];
				}
			}
			
			confirm(1);
			
			if(count != 0) {
				for(int i = 0; i < D; i++) {
				choice = new int[i+1];
				subset(0,0,i+1); //바꿀 필름 번호 선택
				}
			}
			
			
			System.out.println("#"+tc+" "+count);
						
		}

	}


	private static void subset(int cur, int dep, int size) {
		if(dep == size) {
//			for(int i = 0; i < size; i++) {
//				System.out.print("필름 번호 : "+choice[i] + " ");
//			}
//			System.out.println();
			what = new int[dep];
			change(0,0,dep); //A,B중 무엇으로 바꿀지 결정			
			return;
		}		
		for(int i = cur; i < D; i++) {
			choice[dep] = i;
			subset(i+1,dep+1,size);
		}
		
	}


	private static void change(int cur, int dep , int size) {
		if(dep == size) {
//			for(int i = 0; i < size; i++) {
//				System.out.print("약품선택 : "+ what[i]);
//			}
//			System.out.println();
			test();
			for(int i = 0; i < D; i++) {
				for(int j = 0; j < W; j++) {
					film[i][j] = copy[i][j];
					
				}
			}
			return;
			
		}
		for(int i = 0; i <= 1; i++) {
			what[cur] = i;
			change(cur+1,dep+1,size);
		}
		
	}


	private static void test() {
		for(int i = 0; i < choice.length; i++) {
			for(int j = 0; j < W; j++) {
				film[choice[i]][j] = what[i];
			}
		}
		
		confirm(2); //필름 검사
	}


	private static void confirm(int round) {
		int possible = 0;
		
		for(int i = 0; i < W; i++) {
			int first = film[0][i];
			int same = 0;
			for(int j = 0; j < D; j++) {
				if(same == K)break;
				if(film[j][i] == first) {
					same+=1;
				}else {
					first = film[j][i];
					same = 1;
				}
			}
			if(same >= K) {
				possible += 1;
			}else {
				break;
			}
		}
		
		if(round == 1 && possible == W) {
			count = 0;
		}
		if(round == 2 && possible == W) {
			
			count = Math.min(count, choice.length);
		}
		
		
		
	}

}
