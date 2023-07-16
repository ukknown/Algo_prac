
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> minpq = new PriorityQueue<>(Collections.reverseOrder()); //우선순위 내림차순
        PriorityQueue<Integer> maxpq = new PriorityQueue<>(); //우선순위 오름차순

        for(int tc = 0; tc < N; tc++){
            int num = Integer.parseInt(br.readLine());

            if(minpq.size() == maxpq.size()){// 사이즈가 동일하면 작은 수가 들어갈 곳으로
                minpq.offer(num);
            }else{ //사이즈가 다르면 큰 수가 들어갈 곳으로 
                maxpq.offer(num);
            }

            if(!minpq.isEmpty() && !maxpq.isEmpty() && maxpq.peek() < minpq.peek()){ //작은 수들이 있을 곳에 큰 수에 있어야할 값이 있다면
                int tmp = maxpq.poll();
                maxpq.offer(minpq.poll());
                minpq.offer(tmp);
            }
            sb.append(minpq.peek() + "\n");


        }
        System.out.println(sb);


    }
}
