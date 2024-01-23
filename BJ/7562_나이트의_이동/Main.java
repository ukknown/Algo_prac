import java.io.*;
import java.util.*;

class info{
    int x;
    int y;
    int dep;
    public info(int x,int y,int dep){
        this.x = x;
        this.y = y;
        this.dep = dep;
    }
}
public class BJ9081 {
    static int L,Cx,Cy,Px,Py,result;
    static int[][] field;
    static boolean[][] visited;
    static int[] dx = {-2,-1,1,2,2,1,-1,-2};
    static int[] dy = {1,2,2,1,-1,-2,-2,-1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < N; tc++){
            L = Integer.parseInt(br.readLine());

            field = new int[L][L]; //체스판 크기
            visited = new boolean[L][L];


            StringTokenizer st = new StringTokenizer(br.readLine());
            Cx = Integer.parseInt(st.nextToken());
            Cy = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            Px = Integer.parseInt(st.nextToken());
            Py = Integer.parseInt(st.nextToken());

            result = 0;
            BFS(Cx,Cy);

            System.out.println(result);

        }


    }
    private static void BFS(int x, int y){
        Queue<info> que = new LinkedList<>();
        que.add(new info(x,y,0));
        visited[x][y] = true;

        while(!que.isEmpty()){
            info q = que.poll();

            if(q.x == Px && q.y == Py){
                result = q.dep;
                break;
            }

            for(int i = 0; i < 8; i++){
                int nx = q.x + dx[i];
                int ny = q.y + dy[i];
                if(nx >= 0 && nx < L && ny >= 0 && ny < L && !visited[nx][ny]){
                    que.add(new info(nx,ny,q.dep+1));
                    visited[nx][ny] = true;
                }
            }
        }


    }
}
