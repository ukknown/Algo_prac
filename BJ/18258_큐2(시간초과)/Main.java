
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Deque<Integer> que = new LinkedList<>();
		
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			String s = st.nextToken();
			
			switch(s) {
			case "push" :
				int num = Integer.parseInt(st.nextToken());				
				que.add(num);
				break;
			case "pop" :
				if(que.isEmpty()) {
					System.out.println(-1);
				}else {
					int q = que.poll();
					System.out.println(q);
				}				
				break;
			case "size" :
				System.out.println(que.size());
				break;
			case "empty" :
				if(que.isEmpty()) {
					System.out.println(-1);
				}else {
					System.out.println(0);
				}
				break;
			case "front" :
				
				if(que.isEmpty()) {
					System.out.println(-1);
				}else {
					int fq = que.peek();
					System.out.println(fq);
				}
				break;
			case "back" :
				if(que.isEmpty()) {
					System.out.println(-1);
				}else {
					int bq = que.peekLast();
					System.out.println(bq);
				}
				
				break;
				
			}
		}

	}

}
