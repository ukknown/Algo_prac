import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Queen {
	static int N, count;
	static int[] arr;
	static boolean[][] queen;
	static void Track(int dep){
		if(dep == N) {
			count += 1;
			return;
		}
		for(int i = 0; i < N; i++) {
			arr[dep] = i;
			if(passible(dep)) {
				Track(dep+1);
			}	
			
		}		
	}
	public static boolean passible(int cnt) {
		
		for(int i = 0; i < cnt; i++) {
			if(arr[cnt] == arr[i]) return false;
			else if(Math.abs(cnt - i) == Math.abs(arr[cnt] - arr[i]))return false;
		}
		
		return true;
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(st.nextToken());
		count = 0;
		
		arr = new int[N];		
		
		Track(0);
		System.out.println(count);

	}

}
