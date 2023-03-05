
import java.util.PriorityQueue;
import java.util.Scanner;

public class BJ1927 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i = 0; i < N; i++) {
			int x = sc.nextInt();
			
			if(x == 0) { //들어온 값이 0이면 가장 작은 값 출력
				if(pq.size() == 0) { // pq의 값이 없을 경우
					System.out.println(0);
				}else { 
					System.out.println(pq.poll());
				}
			}else { // 0이 아닌 값이 들어오면 pq에 추가
				pq.add(x);
			}
		}
	}

}
