
import java.io.*;
import java.util.*;
public class Main{
    static class info{
        int t;
        int wei;
        public info(int t, int wei){
            this.t = t;
            this.wei = wei;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken()); //단위길이
        int l = Integer.parseInt(st.nextToken()); //다리 최대 하중

        int[] truck = new int[n];
        //Queue<Integer> truck = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            truck[i] = Integer.parseInt(st.nextToken());
        }

        Queue<info> que = new LinkedList<>();

        int idx = 0;
        int weight = 0;
        int time = 1;
        que.add(new info(time,truck[idx]));
        weight += truck[idx];
        idx++;

        while(!que.isEmpty()){
            time++;
            info check = que.peek();
            if(time - check.t == w){ //다리 위의 트럭 단위시간 지나면 통과
                info q = que.poll();
                weight -= q.wei;
            }

            if(idx < n && weight+truck[idx] <= l){ //다리위 트럭 + 대기 중 트럭 하중이 다리 최대 하중 이하면 트럭 진입
                que.add(new info(time,truck[idx]));
                weight += truck[idx];
                idx++;
            }
        }

        System.out.println(time);


    }
}
