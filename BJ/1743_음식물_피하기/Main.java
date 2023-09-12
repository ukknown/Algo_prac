import java.io.*;
import java.util.*;
public class Main {
    static class info{
        int r;
        int c;
        int num;
        public info(int r, int c, int num){
            this.r = r;
            this.c = c;
            this.num = num;
        }
    }
    static int N,M,size;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 세로길이
        M = Integer.parseInt(st.nextToken()); // 가로길이

        size = 0; //음식물 크기 비교할 변수

        int K = Integer.parseInt(st.nextToken()); // 음식물 쓰레기의 개수

        map = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];

        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[r][c] = 1;
        }

        int idx = 2;
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                if(!visited[i][j] && map[i][j] == 1){
                    bfs(i,j,idx);
                    idx++;
                }
            }
        }

        System.out.println(size);
    }
    private static void bfs(int x, int y, int num){
        Queue<info> que = new LinkedList<>();
        que.add(new info(x,y,num));
        map[x][y] = num;
        visited[x][y] = true;
        int check = 0;

        while(!que.isEmpty()){
            info q = que.poll();
            for(int i = 0; i < 4; i++){
                int nx = q.r + dx[i];
                int ny = q.c + dy[i];

                if(nx >= 1 && nx <= N && ny >= 1 && ny <= M && map[nx][ny] == 1 && !visited[nx][ny]){
                    que.add(new info(nx,ny,q.num));
                    map[nx][ny] = q.num;
                    visited[nx][ny] = true;
                }
            }
        }

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                if(map[i][j] == num){
                    check++;
                }
            }
        }

        size = Math.max(size, check);

    }
}
