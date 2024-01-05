import java.io.*;
import java.util.*;

class info{
    int loc;
    int dep;
    public info(int loc, int dep){
        this.loc = loc;
        this.dep = dep;
    }
}
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int F = Integer.parseInt(st.nextToken()); //건물 높이
        int S = Integer.parseInt(st.nextToken()); //강호가 있는 곳
        int G = Integer.parseInt(st.nextToken()); //스타트링크 위치
        int U = Integer.parseInt(st.nextToken()); //위로 올라가는 층 갯수
        int D = Integer.parseInt(st.nextToken()); //내려가는 층 갯수

        int result = Integer.MAX_VALUE;
        boolean[] visited = new boolean[F+1];

        Queue<info> que = new LinkedList<>();
        que.add(new info(S,0));

        while(!que.isEmpty()){
            info q = que.poll();

            if(q.loc == G){
                result = Math.min(result, q.dep);
            }


            if(q.loc + U <= F && !visited[q.loc + U]){
                que.add(new info(q.loc + U, q.dep + 1));
                visited[q.loc + U] = true;

            }

            if(q.loc - D >= 1 && !visited[q.loc - D]){
                que.add(new info(q.loc - D, q.dep + 1));
                visited[q.loc - D] = true;
            }
        }

        if(result == Integer.MAX_VALUE){
            System.out.println("use the stairs");
        }else{
            System.out.println(result);
        }



    }


}
