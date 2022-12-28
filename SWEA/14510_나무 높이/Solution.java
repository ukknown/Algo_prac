import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] tree = new int[N]; //나무 키
						
			int max = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) { //나무 키 입력
				tree[i] = Integer.parseInt(st.nextToken());
				max = Math.max(max, tree[i]); //최고 높이 나무
			}
						
			int[] differ = new int[N]; //높이 차이
			int sum = 0;
			for(int i = 0; i < N; i++) { //자라야하는 높이 입력
				differ[i] = max - tree[i];
				sum += differ[i];
			}
			
			int result = sum/3*2; //총 길이에서 매일 물을 줬을 경우 걸리는 경우
			if(sum%3 == 1)result+=1;
			else if(sum%3 == 2) result += 2;
			
			
			//보정
			int check = 0;
			for(int h : differ) {//짝수날만 물을 줄 경우
				check += h/2;
			}
			
			if(sum > check*3) {
				result = check*2;
			}
			
			int remain = sum - check*3;
			if(remain > 0) {
				result += remain*2 -1;
			}
			
			System.out.println("#" + tc + " "+ result);
			
		}
				
	}

}

