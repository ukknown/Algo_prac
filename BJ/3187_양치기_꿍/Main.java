
import java.io.*;
import java.util.*;
import java.awt.*;
public class Main {
    static int R,C,w,s;
    static char[][] field;
    static boolean[][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());


        w = 0; //늑대
        s = 0; //양

        field = new char[R][C];
        visited = new boolean[R][C];


        for(int i = 0; i < R; i++){
            String s = br.readLine();
            for(int j = 0; j < C; j++){
                field[i][j] = s.charAt(j);
                if(field[i][j] == '#'){
                    visited[i][j] = true;
                }
            }
        }

        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(field[i][j] != '#' && !visited[i][j]){
                    BFS(i,j);
                }
            }
        }

        System.out.print(s + " " + w);


    }
    private static void BFS(int x, int y){
        Queue<Point> que = new LinkedList<>();
        que.add(new Point(x,y));
        visited[x][y] = true;

        int wolf = 0;
        int sheep = 0;

        while(!que.isEmpty()){
            Point q = que.poll();

            if(field[q.x][q.y] == 'v'){
                wolf++;
            }

            if(field[q.x][q.y] == 'k'){
                sheep++;
            }

            for(int i = 0; i < 4; i++){
                int nx = q.x + dx[i];
                int ny = q.y + dy[i];
                if(nx >= 0 && nx < R && ny >= 0 && ny < C && !visited[nx][ny]){
                    que.add(new Point(nx,ny));
                    visited[nx][ny] = true;
                }

            }
        }

        if(wolf >= sheep){
            w+=wolf;
        }else{
            s+=sheep;
        }

    }


}
