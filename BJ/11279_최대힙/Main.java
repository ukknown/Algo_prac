import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); //큰 값 순서대로 정렬

        for(int i =0 ; i < N; i++){
            int x = Integer.parseInt(br.readLine());

            if(x == 0){ //입력값이 0이면
                if(pq.isEmpty()){ //비어있으면 0 출력
                    System.out.println(0);
                }else { // 제일 큰 값 출력
                    System.out.println(pq.poll());
                }
            }else{ //0 아니면 추가
                pq.add(x);
            }
        }


    }
}
