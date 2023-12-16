
import java.io.*;
import java.util.*;
class info{
    int x;
    int y;
    int dep;
    public info(int x, int y, int dep){
        this.x = x;
        this.y = y;
        this.dep = dep;
    }
}
public class Main {
    static int N,r1,r2,c1,c2,result;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-2,-2,0,0,2,2};
    static int[] dy = {-1,1,-2,2,-1,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());

        result = -1;
        BFS(r1,c1);

        System.out.println(result);

    }
    private static void BFS(int x, int y){
        Queue<info> que = new LinkedList<>();
        que.add(new info(x,y,0));
        visited[x][y] = true;

        while(!que.isEmpty()){
            info q = que.poll();

            if(q.x == r2 && q.y == c2){
                result = q.dep;
            }

            for(int i = 0; i < 6; i++){
                int nx = q.x + dx[i];
                int ny = q.y + dy[i];

                if(nx >= 0  && nx < N && ny >= 0 && ny < N && !visited[nx][ny]){
                    que.add(new info(nx,ny,q.dep+1));
                    visited[nx][ny] = true;
                }
            }
        }
    }

}
