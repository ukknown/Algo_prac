
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
    static int N,M;
    static int result = Integer.MIN_VALUE;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];


        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = str.charAt(j);
            }
        }



        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j]=='L'){  //모든 지점에서 최단거리를 계산
                    visited = new boolean[N][M];
                    int d = bfs(i,j,0);
                    result = Math.max(result, d); //가장 먼 두 지점을 구하려면 최단거리 중 가장 큰 값
                }
            }
        }
        System.out.println(result);


    }
    private static int bfs(int x, int y, int dep){
        Queue<info> que = new LinkedList<>();
        que.add(new info(x,y,dep));
        visited[x][y] = true;

        int dis = 0;
        while(!que.isEmpty()){
            info q = que.poll();

            if(q.dep > dis){
                dis = q.dep;
            }

            for(int i = 0; i < 4; i++){
                int nx = q.x+dx[i];
                int ny = q.y+dy[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 'L' && !visited[nx][ny]){
                    que.add(new info(nx,ny, q.dep+1));
                    visited[nx][ny] = true;
                }
            }


        }

        return dis;

    }




}
