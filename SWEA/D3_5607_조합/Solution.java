
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int mod = 1234567891;
	static long[] arr = new long[1000001];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<= T; tc++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			
			arr[0] = 1;
			for(int i=1; i <=1000000; i++) {
				arr[i] = arr[i-1] * i % mod;
			}
			
			//nCr
			long A = arr[N]; //n!
			long B = (arr[N-R]*arr[R])%mod;//(n-r)*r!/mod - 모듈러
			long C = cal(B, mod-2);//mod연산을 위해 분수를 정수로 - 페르마 소정리
			
			System.out.println("#"+tc + " " +(A*C%mod));
			
		
			
		}
		


	}


	private static long cal(long b, int i) {
		if(i == 1) {//재귀 끝
			return b;
		}
		
		long c = cal(b, i/2) %mod;
		if(i % 2 == 0) { //짝수일 때
			return c*c % mod;
		}
		else { //홀수일 때
			return((c * c)% mod *b) % mod;
		}
	}



}
