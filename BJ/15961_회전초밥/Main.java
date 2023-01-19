import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,d,k,c;
	static int[] num;
	static int start;
	static int[] eat;
	static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		num = new int[N + k-1];
	
		for(int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i = 0; i < k-1; i++) {
			num[N++]=num[i];
		}

		
		eat = new int[d+1];				
		eat[c] += 1;
		max = 1;
		
		sliding();
	
		System.out.println(max);
				
	}

	private static void sliding() {
		int start = 0;
		
		for(int i = start; i < k; i++) {//시작k개 초밥
			if(eat[num[i]] == 0) { //한번도 먹지 않은 초밥이면 max+1
				max += 1;
			}
			eat[num[i]] += 1; //선택된 초밥 번호 카운트
		}
		
		start = 0;		
		int end = k; //선택한 초밥 끝 값		
		int result = max;
		
		for(int i = end; i < num.length; i++) {
			eat[num[start]] -= 1; //슬라이딩 윈도우로 첫 값 삭제
			
			if(eat[num[start]] == 0) {//제거한 값이 하나뿐이 었으면 초밥 최고 개수에서 -1
				result -= 1;
			}
						
			if(eat[num[i]]== 0) { // 없던 초밥이면 최고 갯수 +1
				result += 1;
			}
			eat[num[i]] += 1;
			
			max = Math.max(max, result);
			start++; //첫번재 위치 변화
		}
		
	}


}
