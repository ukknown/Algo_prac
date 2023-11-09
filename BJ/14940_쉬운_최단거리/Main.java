
import java.io.*;
import java.util.*;
class info{
    int x;
    int y;
    int s;
    public info(int x, int y, int s){
        this.x = x;
        this.y = y;
        this.s = s;
    }
}
public class Main {
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        int[][] arr = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        for(int i = 0; i < n; i++){
            Arrays.fill(arr[i], -1);
        }
        

        int px = 0;
        int py = 0;

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 0){
                    arr[i][j] = 0;
                }else if(map[i][j] == 2){
                    px = i;
                    py = j;
                }
            }
        }

        Queue<info> que = new LinkedList<>();

        que.add(new info(px,py,0));
        visited[px][py] = true;

        while(!que.isEmpty()){
            info q = que.poll();
            arr[q.x][q.y] = q.s;

            for(int i = 0; i < 4; i++){
                int nx = q.x + dx[i];
                int ny = q.y + dy[i];

                if(nx < n && nx >= 0 && ny < m && ny >= 0 && !visited[nx][ny] && map[nx][ny] != 0){
                    visited[nx][ny] = true;
                    que.add(new info(nx,ny,q.s + map[nx][ny]));
                }

            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                System.out.print(arr[i][j] + " ");
            }System.out.println();
        }




    }
}
