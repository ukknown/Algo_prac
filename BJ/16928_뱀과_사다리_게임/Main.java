import java.io.*;
import java.util.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> ladder = new HashMap<>();
        HashMap<Integer, Integer> snake = new HashMap<>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            ladder.put(x,y);
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            snake.put(u,v);
        }
        boolean[] visited = new boolean[101];

        Queue<Point> que = new LinkedList<>();
        que.add(new Point(1,0));
        visited[1] = true;

        int result = 0;
        while(!que.isEmpty()){
            Point q = que.poll();

            if(q.x == 100){
                result = q.y;
                break;
            }

            for(int i = 1; i <= 6; i++){
                int next = q.x+i;
                int loc = 0;
                if(ladder.containsKey(next)){
                    loc = ladder.get(next);
                    if(!visited[loc]){
                        que.add(new Point(loc, q.y+1));
                        visited[loc] = true;
                    }
                }else if(snake.containsKey(next)){
                    loc = snake.get(next);
                    if(!visited[loc]){
                        que.add(new Point(loc, q.y+1));
                        visited[loc] = true;
                    }
                }else{
                    if(next <= 100 && !visited[next]){
                        que.add(new Point(next, q.y+1));
                        visited[next] = true;
                    }
                }
            }
        }

        System.out.println(result);


    }




}
