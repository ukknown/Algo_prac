import java.io.*;
import java.util.*;

public class Main {
    static int N,result;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); //화단 한변의 길이
        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        result = Integer.MAX_VALUE;
        dfs(0,0);

        System.out.println(result);


    }
    private static void dfs(int seed, int sum){
        if(seed == 3){
            result = Math.min(result, sum);
            return;
        }

        for(int i = 1; i < N-1; i++){
            for(int j = 1; j < N-1; j++){
                if(!visited[i][j] && check(i,j)){
                    visited[i][j] = true;
                    sum += map[i][j] + change(i,j,true);
                    dfs(seed+1, sum);
                    visited[i][j] = false;
                    sum -= map[i][j] + change(i,j,false);
                }
            }
        }

    }

    private static boolean check(int x, int y){
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(visited[nx][ny]){
                return false;
            }
        }
        return true;
    }

    private static int change(int x, int y, boolean b){
        int s = 0;
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            visited[nx][ny] = b;
            s += map[nx][ny];
        }

        return s;
    }




}
