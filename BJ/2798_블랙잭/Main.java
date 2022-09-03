import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int N,M, max = 0;
	static int[] arr;
	static boolean[] visited;
	static void choice(int dep, int sum) {
		if(dep == 3) {
			if(sum <= M) {
				max = Math.max(max, sum);
			}			
			return;
		}		
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i]= true;
				choice(dep+1, sum+arr[i]);
				visited[i] = false;
			}
			
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
       
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		visited = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N; i++) {
			arr[i]=  Integer.parseInt(st.nextToken());
		}
		
		choice(0,0);
		
		System.out.println(max);
				
	}

}
