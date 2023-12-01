
import java.io.*;
import java.util.*;
class info{
    int x;
    int y;
    public info(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int M,N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1,-1,0,1,1,1,0,-1};
    static int[] dy = {0,1,1,1,0,-1,-1,-1};
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        visited = new boolean[M][N];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] == 1 && !visited[i][j]){
                    BFS(i,j);
                    result++;
                }
            }
        }
        System.out.println(result);



    }
    private static void BFS(int x, int y){
        Queue<info> que = new LinkedList<>();
        que.add(new info(x,y));
        visited[x][y] = true;

        while(!que.isEmpty()){
            info q = que.poll();

            for(int i = 0; i < 8; i++){
                int nx = q.x + dx[i];
                int ny = q.y + dy[i];

                if(nx >= 0 && nx < M && ny >= 0 && ny < N && map[nx][ny] == 1 && !visited[nx][ny]){
                    que.add(new info(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
    }


}
