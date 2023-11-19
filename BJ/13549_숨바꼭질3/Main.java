import java.io.*;
import java.util.*;
class info{
    int x;
    int time;
    public info(int x, int time){
        this.x = x;
        this.time = time;
    }
}
public class Main {
    static int X,K,result;
    static boolean[] visited;
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine());


        X = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[100001];
        result = Integer.MAX_VALUE;
        BFS(X);


        System.out.println(result);

    }
    private static void BFS(int x){
        Queue<info> que = new LinkedList<>();
        que.add(new info(x,0));
        visited[x] = true;

        while(!que.isEmpty()){
            info q = que.poll();
            visited[q.x] = true;

            if(q.x == K){
                result = Math.min(result,q.time);
            }

            if(q.x+1 <= 100000 && !visited[q.x+1])que.add(new info(q.x+1,q.time+1));
            if(q.x-1 >= 0 && !visited[q.x-1]) que.add(new info(q.x-1,q.time+1));
            if(q.x*2 <= 100000 && !visited[q.x*2])que.add(new info(q.x*2,q.time));
        }

    }
}
