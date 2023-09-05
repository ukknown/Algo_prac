import java.io.*;
import java.util.*;
public class Main {
    static int N,M;
    static int[][] start, end;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


            start = new int[N][M];
            end = new int[N][M];

            for(int i = 0; i < N; i++){
                String[] str = br.readLine().split("");
                for(int j = 0; j < M; j++){
                    start[i][j] = Integer.parseInt(str[j]);
                }
            }

            for(int i = 0; i < N; i++){
                String[] str = br.readLine().split("");
                for(int j = 0; j < M; j++){
                    end[i][j] = Integer.parseInt(str[j]);
                }
            }

            int x = 0;
            int y = 0;
            int round = 0;

            for(int i = 0; i < N-2; i++){
                for(int j = 0; j < M-2; j++){
                    if(start[i][j] != end[i][j]){
                        change(i,j);
                        round++;
                    }
                }
            }

            int flag = 0;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(start[i][j] == end[i][j]){
                        flag++;
                    }
                }
            }

            if(flag == N*M ){
                System.out.println(round);
            }else{
                System.out.println(-1);
            }





    }
    public static void change(int x, int y){
        for(int i = x; i < x+3; i++){
            for(int j = y; j < y+3; j++){
                if(start[i][j] == 1){
                    start[i][j] = 0;
                }else{
                    start[i][j] = 1;
                }
            }
        }
    }

}
