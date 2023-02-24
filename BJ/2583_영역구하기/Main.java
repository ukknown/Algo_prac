import javax.print.attribute.IntegerSyntax;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int M, N, K;
    static int x1,y1,x2,y2; //꼭지점
    static int area; //넓이
    static int[][] arr; //필드
    static boolean[][] visited; //방문처리

    static int[] dx = {-1,0,1,0}; //4방 탐색을 위한 배열
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[M][N];
        visited = new boolean[M][N];

        for(int tc = 0; tc < K; tc++){
            st = new StringTokenizer(br.readLine());
            x1 =Integer.parseInt(st.nextToken());
            y1 =Integer.parseInt(st.nextToken());
            x2 =Integer.parseInt(st.nextToken());
            y2 =Integer.parseInt(st.nextToken());

            for(int i = y1; i < y2;  i++){ //모눈종이 눈금 영역
                for(int j = x1; j < x2; j++){
                    arr[i][j] = 1;
                    visited[i][j] = true;
                }
            }
        }

        int count = 0; //분리된 영역 갯수를 구하기 위한 변수
        ArrayList<Integer> list = new ArrayList<>(); //영역 넓이를 저장할 list- 오름차순을 위해 list 사용
        for(int i = 0; i < M;  i++){
            for(int j = 0; j < N; j++){
                if(arr[i][j] == 0 && !visited[i][j]){ //눈금 아닌 지역 넓이 구하기
                    BFS(i,j);
                    count += 1;
                    list.add(area);
                    area = 0;
                }

            }
        }

        Collections.sort(list); //오름차순
        System.out.println(count); //영역 갯수
        for(int i =0 ; i< list.size(); i++){ //영역들 넓이 
            System.out.print(list.get(i) + " ");
        }

    }

    private static  void BFS(int x, int y) {
        Queue<Point> que = new LinkedList<>();
        que.add(new Point(x,y));
        visited[x][y] = true;

        while(!que.isEmpty()){
            Point q = que.poll();
            area += 1;
            for(int i =0; i < 4; i++){ //사방 탐색
                int nx = q.x + dx[i];
                int ny = q.y + dy[i];
                
                //범위 확인
                if(nx < 0 || nx >= M || ny < 0 || ny >= N || visited[nx][ny])continue;

                que.add(new Point(nx,ny));
                visited[nx][ny] = true;
            }
        }
        
    }
}
