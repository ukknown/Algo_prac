import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] A = new int[N];
		Integer[] B = new Integer[N];
		
		
		for(int i = 0; i < 2; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				if(i == 0) {
					A[j] = Integer.parseInt(st.nextToken());
				}else {
					B[j] = Integer.parseInt(st.nextToken());
				}
			}
		}
  
	  //A[]의 작은 값과 B[]의 큰 값 순서대로 곱해주면 최솟값	
		Arrays.sort(A);  //오름차순 정렬
		Arrays.sort(B,Collections.reverseOrder()); //내림차순 정렬
		
		int result = 0;
		
		for(int i = 0; i < N ; i ++) {
		result += (A[i]*B[i]);
		}
		
		System.out.println(result);
		

	}

}
