import java.util.PriorityQueue;

public class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < scoville.length; i++){
            pq.add(scoville[i]);
        }

        int answer = 0;
        while(true){
            int a = pq.poll();
            if(a < K && pq.isEmpty()){ //스코빌지수를 K 이상 못올릴 때
                answer = -1;
                break;
            }
            
            if(a >= K){ //음식들을 스코빌지수 K값 이상으로 모두 만들었을 때 
                break;
            }
            int b = pq.poll();

            int sum = a + ( b*2 ); //두 음식을 합쳐서 스코빌지수 올린 음식
            pq.add(sum);
            answer += 1;
        }

        return answer;
    }
}
