import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_15650 {
	static int N;
	static int M;
	static int[] arr;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	static void Track(int num, int dep) {
		if(dep == M) {
			for(int val : arr) {
				sb.append(val).append(' ');
			}
			sb.append('\n');
			
			return;
		}
		
		for(int i = num; i <N; i++ ) {			
				arr[dep] = i+1;			
				Track(i+1, dep+1); //중복 허용을 하지않고 오름차순이라 입력값 다음 범위만 재귀
		}
	}
	

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr= new int[M];
		visited = new boolean[N];
		
		Track(0,0);
		System.out.println(sb);

	}

}
