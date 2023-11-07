
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());


        //영토크기
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N+1][M+1];
        int sum = 0;
        for(int i = 1; i <= N; i++){ // 단위 구역 내 사람 수 누적합(M값 누적)
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++){
                map[i][j] = map[i][j-1] + Integer.parseInt(st.nextToken());
            }
        }

        int K = Integer.parseInt(br.readLine()); // 직사각형 범위의 개수

        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int x1 =Integer.parseInt(st.nextToken());
            int y1 =Integer.parseInt(st.nextToken());
            int x2 =Integer.parseInt(st.nextToken());
            int y2 =Integer.parseInt(st.nextToken());

            int result = 0;
            for(int j = x1; j <= x2; j++){
                result += map[j][y2] - map[j][y1-1];
            }

            sb.append(result + "\n");
        }

        System.out.println(sb);
    }
}
