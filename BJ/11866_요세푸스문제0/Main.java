import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,K;
	static int[] arr;
	static Queue<Integer> queue;
	static ArrayList<Integer> list;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		queue = new LinkedList<>();
		list = new ArrayList<>();
		arr = new int[N];
		
		for(int i = 1; i <= N; i++) {
			queue.add(i);
		}
		
		int c=1;
		while(!queue.isEmpty()) {
			if(c == K) {
				int num = queue.poll();
				list.add(num);
				c=1;
			}
			else {
				int num2 = queue.poll();
				queue.add(num2);
				c++;
			}
			
			
		}
		
		System.out.print("<");
		for(int i = 0; i < list.size();i++) {
			if(i<list.size()-1) {
				System.out.print(list.get(i) + ","+ " ");
			}
			else {
				System.out.print(list.get(i));
			}
			
		}
		System.out.println(">");

	}

}
