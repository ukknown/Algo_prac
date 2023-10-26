
import java.util.*;
import java.io.*;
public class Main {
    static class info{
        int x;
        int y;
        public info(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int R,C, wolf, sheep;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];

        for(int i = 0; i < R; i++){
            String[] str = br.readLine().split("");
            for(int j = 0; j < C; j++){
                map[i][j] = str[j].charAt(0);
                if(map[i][j] == '#'){
                    visited[i][j] = true;
                }
            }
        }

        wolf = 0;
        sheep = 0;


        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(!visited[i][j]){
                    BFS(i,j);
                }
            }
        }

        sb.append(sheep + " ").append(wolf);

        System.out.println(sb);
    }

    private static void BFS(int x, int y){
        int w = 0; //늑대
        int s = 0; //양
        Queue<info> que = new LinkedList<>();
        que.add(new info(x,y));
        visited[x][y] = true;

        while(!que.isEmpty()){
            info q = que.poll();

            if(map[q.x][q.y] == 'v'){
                w++;
            }else if(map[q.x][q.y] == 'o'){
                s++;
            }

            for(int i = 0; i < 4; i++){
                int nx = q.x + dx[i];
                int ny = q.y + dy[i];
                if(nx > 0 && nx < R && ny > 0 && ny < C && !visited[nx][ny]){
                    que.add(new info(nx, ny));
                    visited[nx][ny] = true;
                }
            }

        }

        if(w >= s){
            wolf += w;
        }else{
            sheep += s;
        }

    }
}
