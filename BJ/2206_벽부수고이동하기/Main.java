import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2206 {
    static class info {
        int x;
        int y;
        int cnt;
        boolean destroy;

        public info(int x, int y, int cnt, boolean destroy) { //이동정보와 벽 부순 여부 확인 정보
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.destroy = destroy;
        }
    }

    static int N, M, dist, flag;
    static int[][] arr;
    static boolean[][][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //N개의 줄
        M = Integer.parseInt(st.nextToken()); //M개의 숫자

        arr = new int[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }

        dist = 0; //거리 나타낼 변수
        flag = 0; // 완주 여부 확일할 변수
        BFS(0, 0, 1);

        System.out.println(dist);

    }

    private static void BFS(int x, int y, int d) {
        Queue<info> que = new LinkedList<>();
        que.add(new info(x, y, d, false));


        while (!que.isEmpty()) {

            info q = que.poll();

            if (q.x == N - 1 && q.y == M - 1) { //완주 했을 때
                dist = q.cnt;
                flag = 1; //완주했을 경우 flag == 1
                return;
            }

            for (int i = 0; i < 4; i++) { //4방 탐색
                int nx = q.x + dx[i];
                int ny = q.y + dy[i];
 
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue; //범위 확인

                if (arr[nx][ny] == 0) {
                    if (!q.destroy && !visited[nx][ny][0]) { //벽 부순적 없고 길이 0
                        que.add(new info(nx, ny, q.cnt + 1, false));
                        visited[nx][ny][0] = true;
                    } else if (q.destroy && !visited[nx][ny][1]) { //벽 부순 적 있고 길이 0
                        que.add(new info(nx, ny, q.cnt + 1, true));
                        visited[nx][ny][1] = true;
                    }
                } else if (arr[nx][ny] == 1) { //벽 도달
                    if(!q.destroy){ //벽 부순적 없다면
                        que.add(new info(nx, ny, q.cnt + 1, true));
                        visited[nx][ny][1] = true;
                    }
                }
            }
        }

        if (flag == 0) { //완주 못한 경우
            dist = -1;
        }


    }
}

