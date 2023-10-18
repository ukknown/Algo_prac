
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int[][] arr = new int[R+1][C+1];

        for(int i = 1; i <= R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= C; j++){
                arr[i][j] = arr[i][j-1] + Integer.parseInt(st.nextToken());
            }
        }


        for(int i = 0; i < Q; i++){
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            int sum = 0;
            int divide = (r2 - r1 +1) * (c2 - c1 +1);
            for(int r = r1; r <= r2; r++){
                sum += arr[r][c2] - arr[r][c1-1];
            }

            sb.append( (sum/divide) + "\n" );

        }

        System.out.println(sb);

    }
}
