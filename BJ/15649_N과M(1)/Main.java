import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[] arr;
	static boolean[] visited;
	public static StringBuilder sb = new StringBuilder();
	static void Tracking(int num, int dep) {
		if(dep == M) { //출력 크기와 깊이가 같아지면 출력
			for (int val : arr) {
				sb.append(val).append(' ');
			}
			sb.append('\n');

			return;
		}
		for(int i = num; i <= N; i++) {		//번호를 출력 크기에 맞는 깊이만큼 저장	
			if(!visited[i]) {
				arr[dep] = i;
				visited[i] = true;
				Tracking(num, dep+1);
				visited[i] =false;

			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M]; //고를 갯수만큼의 사이즈를 갖는 배열 생성
		visited = new boolean[N+1];	// 값 사용 여부 확인	
		Tracking(1, 0);//시작 번호와 출력할 크기만큼의 깊이
		System.out.println(sb);

	}

}
