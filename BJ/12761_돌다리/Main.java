
import java.io.*;
import java.util.*;
class info{
    int loc;
    int cnt;
    public info(int loc, int cnt){
        this.loc = loc;
        this.cnt = cnt;
    }
}
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int dong = Integer.parseInt(st.nextToken());
        int ju = Integer.parseInt(st.nextToken());

        int max = 100000;
        int[] map = new int[max+1];

        Queue<Integer> que = new LinkedList<>();
        que.add(dong);

        while(!que.isEmpty()){
            int q = que.poll();

            if(q == ju){
                System.out.println(map[q]);
                break;
            }

            if(q-1 >= 0 && map[q-1] == 0){
                map[q-1] += map[q]+1;
                que.add(q-1);
            }

            if(q+1 <= max && map[q+1] == 0){
                map[q+1]+= map[q]+1;
                que.add(q+1);
            }

            if(q-A >= 0 && map[q-A] == 0){
                map[q-A]+= map[q]+1;
                que.add(q-A);
            }

            if(q-B >= 0 && map[q-B] == 0){
                map[q-B]+= map[q]+1;
                que.add(q-B);
            }

            if(q+A <= max && map[q+A] == 0){
                map[q+A]+= map[q]+1;
                que.add(q+A);
            }

            if(q+B <= max && map[q+B] == 0){
                map[q+B]+= map[q]+1;
                que.add(q+B);
            }
            if(q*A <= max && map[q*A] == 0){
                map[q*A]+= map[q]+1;
                que.add(q*A);
            }
            if(q*B <= max && map[q*B] == 0){
                map[q*B]+= map[q]+1;
                que.add(q*B);
            }




        }


    }


}
