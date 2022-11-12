
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N,B;
	static int[] worker;
	static int min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			StringBuilder sb = new StringBuilder();
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());//점원의수
			B = Integer.parseInt(st.nextToken());//선반 높이
					
			worker = new int[N];//점원 키 정보
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) { //점원 키 입력
				worker[i] = Integer.parseInt(st.nextToken());
			}
			
			min = Integer.MAX_VALUE;
			top(0,0,0); //부분 조합
			
			System.out.println("#"+tc + " " + (min-B)); //실행시간 108 ms
//			sb.append("#").append(tc).append(" ").append(min-B); //StringBuilder쓸 경우 113 ms
//			System.out.println(sb);
			
		}
		
		

	}

	private static void top(int cur,int dep, int sum) {
		if(sum >= B) {
			min = Math.min(min, sum); //B보다 크거나 같은 값 중 가장 작은 값
			return;
		}
				
		for(int i = cur; i < N; i++) {
				top(i+1, dep+1, sum + worker[i]);
			
		}				
	}

}
