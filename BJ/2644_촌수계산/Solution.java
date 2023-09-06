import java.io.*;
import java.util.*;
public class Main {
    static class info{
        int x;
        int y;
        int dep;
        public info(int x, int y, int dep){
            this.x = x;
            this.y = y;
            this.dep = dep;
        }
    }
    static StringTokenizer st;
    static int N,answer, p1, p2;
    static int[][] arr;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //사람 수
        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        //촌수 계산할 두명
        p1 = Integer.parseInt(st.nextToken());
        p2 = Integer.parseInt(st.nextToken());

        int tc = Integer.parseInt(br.readLine());
        arr = new int[N+1][N+1];
        visited = new boolean[N+1][N+1];

        for(int i = 0; i < tc; i++){ //행렬 촌으로 연결되면 1
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x][y] = 1;
            arr[y][x] = 1;
        }
        answer = -1;

        BFS(p1); //시작 사람 번호

        System.out.println(answer);

    }
    private static void BFS(int x){
        Queue<info> que = new LinkedList<>();

        for(int s = 1; s <= N; s++){ //시작 사람 번호 열에서 1인 부분 que에 삽입
            if(arr[x][s] == 1){
                que.add(new info(x,s,1));
                visited[x][s] = visited[s][x] = true;
            }
        }


        while(!que.isEmpty()){
            info q = que.poll();

            if(q.y == p2){ //도착 사람 값이 나오면 answer는 촌수(dep)
                answer = q.dep;
                break;
            }

            for(int i = 1; i <= N; i++){ //연결된 촌수 계산
                if(arr[q.y][i] == 1 && !visited[q.y][i]){
                    que.add(new info(q.y, i, q.dep+1));
                    visited[q.y][i] = visited[i][q.y] =true;
                }
            }

        }


    }
}
