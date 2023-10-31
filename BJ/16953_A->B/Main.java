import java.io.*;
import java.util.*;
public class Main {
    static class info{
        long x;
        int y;
        public info(long x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());

        int result = BFS(A,B);

        System.out.println(result);
    }
    private static int BFS(long A, long B){
        Queue<info> que = new LinkedList<>();
        que.add(new info(A, 1));

        while(!que.isEmpty()){
            info q = que.poll();

            if(q.x == B){
                return q.y;
            }

            if(q.x < B){
                que.add(new info(q.x*2, q.y+1));
                que.add(new info((q.x*10)+1, q.y+1));
            }


        }
        return -1;
    }
}
