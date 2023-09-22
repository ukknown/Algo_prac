
import java.io.*;
import java.util.*;
public class Main {
    static class info implements Comparable<info>{
        int v; //선호도
        int c; // 도수
        public info(int v, int c){
            this.v = v;
            this.c = c;
        }

        @Override
        public int compareTo(info o) {
            if(o.c == this.c){
                return this.v - o.v;
            }else{
                return this.c - o.c;
            }

        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<info> pq = new PriorityQueue<>(); //도수 기준 오름차순 정렬(도수 같으면 선호도 기준 오름차순) 
        PriorityQueue<Integer> pref = new PriorityQueue<>();

        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int like = Integer.parseInt(st.nextToken());
            int alco = Integer.parseInt(st.nextToken());

            pq.add(new info(like, alco));
        }


        int total = 0; //선호도 총합
        int result = -1; //최고 도수

        for(int i = 0; i < K; i++){
            info a = pq.poll();

            pref.add(a.v); //기본으로 오름차순 정렬,축제날에 받을 맥주
            total += a.v;

            if(pref.size() > N){ //축제날을 넘으면 pref하나 제거하고 total에서 빼준다.
                total -= pref.poll();
            }


            if(pref.size() == N && total >= M){ // 축제날 기간도 맞고 선호도가 요구조건에 맞다면
                result = a.c;
                break;
            }

        }
        System.out.println(result);






    }
}
