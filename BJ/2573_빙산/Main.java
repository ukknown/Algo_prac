
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
    static int N, M;
    static int[][] map,arr;
    static boolean[][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];//빙산
        arr = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int year = 0;
        while(true){
            int flag = check();
            if(flag == 0){ //2개로 안나뉘면
                year = 0;
                break;
            }else if(flag >= 2){ // 2개 이상으로 나뉘면
                break;
            }
            for(int i = 0; i < N; i++){ //주변 0갯수 확인 후 녹음
                for(int j = 0; j < M; j++){
                    if(map[i][j] != 0){
                        melt(i,j); 
                    }
                }
            }

            for(int i = 0; i < N; i++){
                map[i] = Arrays.copyOf(arr[i], M);
            }
            year++;


        }

        System.out.println(year);




    }

    private static void melt(int x, int y){
        int sea = 0;
        for(int i = 0; i < 4; i++){ //인접한 행렬 0 갯수 확인
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] == 0){
                sea++;
            }
        }
      //녹임
        if(map[x][y] - sea >= 0){ 
            arr[x][y] = map[x][y] - sea;
        }else{
            arr[x][y] = 0;
        }

    }
    private static void BFS(int x, int y){ //빙산 한개 크기 확인
        Queue<info> que = new LinkedList<>();
        que.add(new info(x,y));
        visited[x][y] = true;


        while(!que.isEmpty()){
            info q = que.poll();

            for(int i = 0; i < 4; i++){
                int nx = q.x + dx[i];
                int ny = q.y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny] && map[nx][ny] != 0){
                    que.add(new info(nx,ny));
                    visited[nx][ny] = true;
                }
            }
        }

    }
    private static int check(){ // 빙산 수 확인
        visited = new boolean[N][M];
        int ice = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] != 0 && !visited[i][j]){
                    ice++;
                    BFS(i,j);
                }
            }
        }

        return ice;
    }

}
