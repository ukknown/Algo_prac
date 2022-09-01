import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int V, E, K;
	static int[] dist;
	static ArrayList<Edge>[] adjList;
	static class Edge implements Comparable<Edge>{
		int id, cost;
		
		
		Edge(int id, int cost){
			this.id = id;
			this.cost = cost;
		}


		@Override
		public int compareTo(Edge o) {			
			return this.cost - o.cost;
		}
	}
	
	static void dijkstra(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>(); 
		dist[start]= 0; //입력된 시작 노드부터 탐색 시작
		pq.add(new Edge(start,0));
		
		while(!pq.isEmpty()) {
			Edge now = pq.poll();
			
			if(now.cost > dist[now.id]) continue; //탐색하는 노드의 가중치가 더 크면 넘어감
			
			int len = adjList[now.id].size(); //정점의 연결된 간선 수 만큼 탐색
			for(int i = 0; i < len; i++) {
				Edge next = adjList[now.id].get(i);
				
				if(dist[next.id] > now.cost + next.cost) {// 값 비교후 최솟값 변경
					dist[next.id] = now.cost + next.cost;
					pq.add(new Edge(next.id, dist[next.id]));
				}
			}
		}
		
		return;
	}
	

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		V = Integer.parseInt(st.nextToken());//정점의 개수
		E = Integer.parseInt(st.nextToken());//간선의 개수		
		K = Integer.parseInt(bf.readLine());//시작 정점 번호
				
		dist = new int[V+1];
		for(int i = 0; i <= V; i++) {
			dist[i] = Integer.MAX_VALUE; //각 정점의 가중치를 최고값을 줘 가중치들과 비교해 최소값을 찾음
		}
		
		adjList = new ArrayList[V+1];
		
		for(int i = 1; i <=V; i++ ) {
			adjList[i] = new ArrayList<Edge>();
		}

		for (int i = 1; i <= E; i++) { // 각 정점과 연결된 정점과 간선의 가중치 입력
			st = new StringTokenizer(bf.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			adjList[u].add(new Edge(v, w));

		}

		dijkstra(K);

		for (int i = 1; i <= V; i++) {
			if (dist[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			} else {
				System.out.println(dist[i]);
			}
		}
	}

}
