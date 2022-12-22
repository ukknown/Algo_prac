import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine()); //명령의 수
		Deque<String> deq = new ArrayDeque<>(); //덱 초기화
		for(int tc = 1; tc <= T; tc++) {
			
			
			String[] str = br.readLine().split(" "); //명령어 입력
			String s; //빼줄 값 저장할 변수
			
			switch(str[0]) {
			case "push_front": //정수 X를 덱의 앞에 넣는다.
				deq.addFirst(str[1]);
				break;
			case "push_back": //정수 X를 덱의 뒤에 넣는다.
				deq.addLast(str[1]);
				break;
			case "pop_front": // 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
				if(deq.isEmpty()) {
					System.out.println(-1);
				}else {
					s = deq.pollFirst();
					System.out.println(s);
				}
				
				break;
			case "pop_back": //덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
				if(deq.isEmpty()) {
					System.out.println(-1);
				}else {
					s = deq.pollLast();
					System.out.println(s);
				}
				break;
			case "size": // 덱에 들어있는 정수의 개수를 출력한다.
				System.out.println(deq.size());
				break;
			case "empty": //덱이 비어있으면 1을, 아니면 0을 출력한다.
				if(deq.isEmpty()) {
					System.out.println(1);
				}else {
					System.out.println(0);
				}
				break;
			case "front": //덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
				if(deq.isEmpty()) {
					System.out.println(-1);
				}else {
					System.out.println(deq.getFirst());
				}
				break;
			case "back": //덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
				if(deq.isEmpty()) {
					System.out.println(-1);
				}else {
					System.out.println(deq.getLast());
				}
				break;
			}
			
		}
	}

}
