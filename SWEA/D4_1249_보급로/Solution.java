import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Pos {
    int x;
    int y;
 
    Pos(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int[] dx = {-1,1,0,0};// 상하좌우
    static int[] dy = {0,0,-1,1};
    static int n;
    static int[][] arr;
    static int min;
    static boolean[][] visited;
    static int[][] ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
         
        for(int tc = 1; tc <= T; tc++){
            n = Integer.parseInt(br.readLine());
 
            arr = new int[n][n];
            for(int i=0; i<n; i++){ //필드 값 입력
                String[] str = br.readLine().split("");
                for(int j=0; j<n; j++){
                    arr[i][j] = Integer.parseInt(str[j]);
                }
            }
 
            min = Integer.MAX_VALUE;
            visited = new boolean[n][n];
             
            ans = new int[n][n];
            for(int i=0; i<n; i++) { //소요시간 입력할 배열
                Arrays.fill(ans[i], Integer.MAX_VALUE);
            }
            ans[0][0] = 0;
 
            bfs(0,0);
            System.out.println("#" + tc + " " + min);
        }
 
        br.close();
    }
 
    private static void bfs(int x, int y){
        Queue<Pos> q = new LinkedList<>();
 
        q.offer(new Pos(x,y));
        visited[x][y] = true;
        while(!q.isEmpty()){
            Pos p = q.poll();
            int a = p.x;
            int b = p.y;
 
          
            if(a == n-1 && b == n-1) { // 우 하단 도착지에 도착한 경우 값 비교
            	if(min > ans[n-1][n-1]) {
            		min = ans[n-1][n-1];
            	}
            }
                
            if(min <= ans[a][b])continue;
            
            for(int i = 0; i < 4; i++){//4방향 탐색
                int nx = a + dx[i];
                int ny = b + dy[i];
                if(nx >= 0 && nx < n && ny >=0 && ny < n){
                    if(!visited[nx][ny] || ans[nx][ny] > ans[a][b] + arr[nx][ny]){
                        visited[nx][ny] = true;
                        ans[nx][ny] = ans[a][b] + arr[nx][ny]; // 최소 소요시간 저장
                        q.offer(new Pos(nx, ny));
                    }
                }
            }
        }
    }
 
}
