import java.io.*;
import java.util.*;
import java.awt.*;
public class Main {
    static int N,M, white, blue;
    static char[][] field;
    static boolean[][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //가로
        M = Integer.parseInt(st.nextToken()); //세로

        field = new char[M][N];
        visited = new boolean[M][N];

        for(int i = 0; i < M; i++){
            String s = br.readLine();
            for(int j = 0; j < N; j++){
                field[i][j] = s.charAt(j);
            }
        }
        

        white = 0;
        blue = 0;
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j]){
                    BFS(i,j,field[i][j]);
                }
            }

        }

        System.out.println(white + " " + blue);


    }
    private static void BFS(int x, int y, char c){
        Queue<Point> que = new LinkedList<>();
        que.add(new Point(x,y));
        visited[x][y] = true;

        int count = 1;
        while(!que.isEmpty()){
            Point q = que.poll();

            for(int i = 0; i < 4; i++){
                int nx = q.x + dx[i];
                int ny = q.y + dy[i];

                if(nx >= 0 && nx < M && ny >= 0 && ny < N && !visited[nx][ny] && field[nx][ny] == c){
                    que.add(new Point(nx, ny));
                    visited[nx][ny] = true;
                    count++;
                }
            }

        }

        if(c == 'W'){
            white += count*count;
        }else{
            blue += count*count;
        }


    }



}
