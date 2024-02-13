
import java.util.*;
import java.io.*;
import java.awt.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] maze = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            maze[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] visited = new boolean[N];
        Queue<Point> que = new LinkedList<>();
        que.add(new Point(0, 0));
        visited[0] = true;

        int result = 0;
        while(!que.isEmpty()){
            Point q = que.poll();

            if(q.x == N-1){
                System.out.println(q.y);
                return;
            }

            for(int i = 1; i <= maze[q.x]; i++){
                int next = q.x+i;
                if(next < N && !visited[next]){
                    que.add(new Point(next, q.y+1));
                    visited[next] = true;
                }
            }

        }

        System.out.println(-1);

    }

}
