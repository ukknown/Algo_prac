
import java.util.*;
import java.io.*;
import java.awt.*;
public class Main {

    static int N,M;
    static int max = Integer.MIN_VALUE;
    static int[][] arr, map;
    static boolean[][][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //세로
        M = Integer.parseInt(st.nextToken()); //가로

        arr = new int[N][M];
        visited = new boolean[N][M][2];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1)visited[i][j][1] = true; //벽
            }
        }

        wall(0);

        System.out.println(max);
    }

    private static void wall(int w) { //벽 세우기
        if(w == 3){  //3개를 먼저 세우고 바이러스 확산
            virus();
            return;
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(arr[i][j] == 0){
                    arr[i][j] = 1;
                    wall(w+1);
                    arr[i][j] = 0;
                }


            }
        }
    }

    private static void virus(){ // 바이러스 확산
        Queue<Point> que = new LinkedList<>();
        map = new int[N][M];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                map[i][j] = arr[i][j];
                if(map[i][j] == 2){
                    que.add(new Point(i,j));
                }
            }
        }

        while(!que.isEmpty()){
            Point q = que.poll();

            for(int i = 0; i < 4; i++){
                int nx = q.x + dx[i];
                int ny = q.y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] == 0){
                    map[nx][ny] = 2;
                    que.add(new Point(nx,ny));
                }
            }
        }

        int count = 0;
        for(int i = 0; i < N; i++){ // 안전영역 크기 계산
            for(int j = 0; j < M; j++){
                if(map[i][j] == 0){
                    count++;
                }
            }
        }

        max = Math.max(max, count);

    }

}
