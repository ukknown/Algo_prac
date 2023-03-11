import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main{

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Long> pq = new PriorityQueue<>();
		
		for(int i = 0; i< N; i++) {
			pq.add(Long.parseLong(br.readLine()));
		}
		
		
		
		long count = 0;
		
		while(pq.size() > 1) {
			long a = pq.poll();
			long b = pq.poll();
			
			count += a + b;
			pq.add(a + b);
		}
		
		
		
		System.out.println(count);

	}

}
