
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N+1][N+1];


        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            int sum = 0;
            for(int j = 1; j <= N; j++){
                sum += Integer.parseInt(st.nextToken());
                arr[i][j] = sum;
            }
        }



        for(int tc = 0; tc < M; tc++){
            int result = 0;
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int i = x1; i <= x2; i++){
                result += arr[i][y2] - arr[i][y1-1];
            }
            sb.append(result + "\n");

        }
        System.out.println(sb);
    }
}
