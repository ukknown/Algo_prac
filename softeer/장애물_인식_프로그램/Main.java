import java.util.*;
import java.io.*;
import java.awt.*;


public class Main
{
    static int N;
    static boolean[][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        visited = new boolean[N][N];


        for(int i = 0; i < N; i++){
            String[] str = br.readLine().split("");
            for(int j = 0; j < str.length; j++){
                arr[i][j] = Integer.parseInt(str[j]);
                if(arr[i][j] == 0)visited[i][j] = true;
            }
        }

        int count = 0;
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(visited[i][j])continue;
                count++; //블록의 수 
                int obstracle = BFS(i,j); //장애물의 수 
                list.add(obstracle);
            }
        }

        Collections.sort(list); // 오름차순 정렬 

        System.out.println(count);
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
      
        
    }
    public static int BFS(int x, int y){
        Queue<Point> que = new LinkedList<>();
        que.add(new Point(x,y));
        visited[x][y] = true;

        int num = 0;

        while(!que.isEmpty()){
            Point q = que.poll();
            num++;

            for(int i = 0; i < 4; i++){
                int nx = q.x + dx[i];
                int ny = q.y + dy[i];
                if(nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny])continue;
                que.add(new Point(nx,ny));
                visited[nx][ny] = true;
            }



        }

        return num;

    }
}
