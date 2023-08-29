import java.io.*;
import java.util.*;
public class Main {
    static StringTokenizer st;
    static int N;
    static char[][] cal;
    static int[] dx = {1,0};
    static int[] dy = {0,1};
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        cal = new char[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                cal[i][j] = st.nextToken().charAt(0);
            }
        }

        dfs(0,0, Character.getNumericValue(cal[0][0]),'c');

        System.out.println(max + " " + min);


    }
    public static void dfs(int x, int y,int sum, char c){
        for(int i = 0; i < 2; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < N && ny < N){
                if(cal[nx][ny] == '+' || cal[nx][ny] == '-'  || cal[nx][ny] == '*' ){ // 기호가 나오면
                    switch(cal[nx][ny]){
                        case '+':
                            dfs(nx, ny, sum, '+' );
                            break;
                        case '-':
                            dfs(nx, ny, sum, '-' );
                            break;
                        case '*':
                            dfs(nx, ny, sum, '*' );
                            break;
                    }
                }else{ // 숫자가 나오면
                    int result = 0;
                    switch(c){
                        case '+':
                            result = sum + Character.getNumericValue(cal[nx][ny]);
                            break;
                        case '-':
                            result = sum - Character.getNumericValue(cal[nx][ny]);
                            break;
                        case '*':
                            result = sum * Character.getNumericValue(cal[nx][ny]);
                            break;
                    }

                    if(nx == N-1 && ny == N-1){
                        max = Math.max(max, result);
                        min = Math.min(min, result);
                        return;
                    }

                    dfs(nx, ny, result, c);


                }
            }
        }

    }

}
