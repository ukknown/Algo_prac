import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	static void Track( int dep) {
		if(dep == M) {
			for(int val : arr) {
				sb.append(val).append(' ');
			}
			sb.append('\n');			
			return;
		}
		
		for(int i = 0; i < N; i++ ) {
			if(dep == 0) {
				arr[dep]= i+1;
				Track( dep+1);
			}
			else if(arr[dep-1] <= i+1) {
				arr[dep]= i+1;
				Track( dep+1);
			}
							
		}
	}
	

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr= new int[M];
		
		Track(0);
		System.out.println(sb);

	}

}
