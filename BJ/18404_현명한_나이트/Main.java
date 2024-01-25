import java.io.*;
import java.util.*;

class info{
    int x;
    int y;
    public info(int x,int y){
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int N,M,x,y;
    static StringBuilder sb;
    static int[][] field;
    static int[] dx = {-2,-1,1,2,2,1,-1,-2};
    static int[] dy = {1,2,2,1,-1,-2,-2,-1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        field = new int[N+1][N+1];

        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        BFS(x,y);

        for(int tc = 0; tc < M; tc++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            sb.append(field[A][B]).append(" ");

        }

        System.out.println(sb);

    }
    private static void BFS(int x, int y){
        Queue<info> que = new LinkedList<>();
        que.add(new info(x,y));

        while(!que.isEmpty()){
            info q = que.poll();

            for(int i = 0; i < 8; i++){
                int nx = q.x + dx[i];
                int ny = q.y + dy[i];
                if(nx > 0 && nx <= N && ny > 0 && ny <= N){
                    if(field[nx][ny] == 0){
                        field[nx][ny] = field[q.x][q.y]+1;
                        que.add(new info(nx,ny));
                    }

                }
            }
        }

    }


}
