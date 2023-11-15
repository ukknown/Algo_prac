
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
    static int N;
    static boolean result;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0,1};
    static int[] dy = {1,0};
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];


        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        result = false;
        BFS(0,0);


        if(result){
            System.out.println("HaruHaru");
        }else{
            System.out.println("Hing");
        }
//DFS
                  //System.out.println("Hing");




    }
    private static void BFS(int x, int y){
        Queue<info> que = new LinkedList<>();
        que.add(new info(x,y));
        visited[x][y] = true;

        while(!que.isEmpty()){
            info q = que.poll();

            if(map[q.x][q.y] == -1){
                result = true;
                break;
            }
            for(int i = 0; i < 2; i++) {
                int nx = q.x + dx[i] * map[q.x][q.y];
                int ny = q.y + dy[i] * map[q.x][q.y];

                if (nx < N && ny < N && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    que.add(new info(nx, ny));
                }
            }
        }

//DFS
//      if(map[x][y] == -1){
//            System.out.println("HaruHaru");
//            System.exit(0);
//        }
//
//        for(int i = 0; i < 2; i++){
//            int nx = x + dx[i]*map[x][y];
//            int ny = y + dy[i]*map[x][y];
//
//            if(nx < N && ny < N && !visited[nx][ny]){
//                visited[nx][ny] = true;
//                DFS(nx,ny);
//                visited[nx][ny] = false;
//            }
//        }

    }
}
