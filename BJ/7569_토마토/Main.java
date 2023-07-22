import java.io.*;
import java.util.*;
public class Main {
    static class info{
        int x;
        int y;
        int h;
        int r;
        public info(int x, int y, int h, int r){
            this.x = x;
            this.y = y;
            this.h = h;
            this.r = r;
        }
    }
    static int M,N,H, round;
    static int[][][] arr;
    static boolean[][][] visited;
    static List<info> list;
    static int[] dx = {-1,0,1,0}; //4방x 이동 세로 이동
    static int[] dy = {0,1,0,-1}; //4방y 이동 가로 이동
    static int[] dh = {1,-1}; //높이 이동
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); //가로 칸 : y
        N = Integer.parseInt(st.nextToken()); //세로 칸 : x
        H = Integer.parseInt(st.nextToken()); // 높이 : h

        arr = new int[N][M][H];
        visited = new boolean[N][M][H];
        list = new ArrayList<>(); //초기 익은 토마토 위치정보


        int Tcheck = 0;
        round = 0; //시간 경과 확인용

        for(int i = 0; i < H; i++){
            for(int j = 0; j < N; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < M; k++){
                    arr[j][k][i] = Integer.parseInt(st.nextToken());
                    if(arr[j][k][i] == -1){
                        visited[j][k][i] = true;
                    }

                    if(arr[j][k][i] == 1){
                        visited[j][k][i] = true;
                        list.add(new info(j,k,i,0));
                    }

                    if(arr[j][k][i] == 0){
                        Tcheck++;
                    }
                }
            }
        }


        if(Tcheck == 0){ //
            System.out.println(0);
        }else{
            BFS();
            System.out.println(round);
        }
    }

    private static void BFS() {
        Queue<info> que = new LinkedList<>();
        for(int i = 0; i < list.size(); i++){
            int x = list.get(i).x;
            int y = list.get(i).y;
            int h = list.get(i).h;
            int r = list.get(i).r;
            que.add(new info(x,y,h,r));
            visited[x][y][h] = true;
        }

        while(!que.isEmpty()){
            info q = que.poll();
            round = q.r; //시간 경과 최신화

            for(int i = 0; i < 4; i++){ //4방향 토마토 익히기
                int nx = q.x + dx[i];
                int ny = q.y + dy[i];
                if(nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny][q.h])continue; //범위 확인
                arr[nx][ny][q.h] = 1;
                visited[nx][ny][q.h] = true;
                que.add(new info(nx,ny,q.h,q.r+1));
            }

            for(int j = 0; j < 2; j++){ //위 아래 토마토 익히기
                int nh = q.h + dh[j];
                if(nh < 0 || nh >= H || visited[q.x][q.y][nh])continue; //범위 확인
                arr[q.x][q.y][nh] = 1;
                visited[q.x][q.y][nh] = true;
                que.add(new info(q.x,q.y,nh,q.r+1));
            }
        }
             for(int i = 0; i < H; i++){ //시간이 지나도 토마토가 다 익지 못하는 경우 확인
                for(int j = 0; j < N; j++){
                    for(int k = 0; k < M; k++){
                        if(!visited[j][k][i]){
                            round = -1; //다 익을 수 없으면 -1
                        }
                    }
                }
            }

    }

}
