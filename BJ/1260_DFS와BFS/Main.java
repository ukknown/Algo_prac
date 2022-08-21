import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M,V;
	static int[][] arr;
	static boolean[] visited1;
	static boolean[] visited;
	static void DFS(int dep) {
		visited[dep] = true;
		System.out.print(dep + " ");
		
		if(dep == arr.length) {
			return;
		}
		
		for(int i = 1; i < arr.length; i++) {
			if(arr[dep][i] == 1 && !visited[i]) {
				DFS(i);
			}
		}

	}
	static void BFS(int dep) {
		Queue<Integer> que = new LinkedList<Integer>();
		
		que.add(dep);
		visited1[dep] = true;
		System.out.print(dep + " ");
		
		while(!que.isEmpty()) {
			int temp = que.poll();
			for(int i = 1; i < arr.length; i++) {
				if(arr[temp][i] == 1 && !visited1[i]) {
					que.add(i);
					visited1[i] = true;
					System.out.print(i + " ");
				}
			}
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1][N+1];
		visited = new boolean[N+1];
		visited1 = new boolean[N+1];
		
		for(int i = 0; i < M; i++) {			
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());			
			arr[a][b] = arr[b][a] = 1;			
		}
		
		DFS(V);
		System.out.println();
		BFS(V);

	}

}
