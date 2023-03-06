import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static boolean[] check;
    static int[][] arr;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N][N]; //선수들 능력치
        check = new boolean[N]; //소속 팀

        StringTokenizer st;
        for(int i = 0; i < N; i++){ //능력치 입력
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        track(0,0);

        System.out.println(min);
    }

    private static void track(int start ,int dep) {
        if(dep == N/2){
            diff();
            return;
        }

        for(int i = start; i < N; i++){
            if(!check[i]){
                check[i] = true;
                track(i + 1, dep + 1);
                check[i] = false;
            }

        }
    }

    private static void diff() {
        int first = 0;
        int second = 0;

        for(int i = 0; i < N-1; i++){
            for(int j = i + 1; j < N; j++){
                if(check[i] == true && check[j] == true){
                    first += arr[i][j];
                    first += arr[j][i];
                }

                else if(check[i] == false && check[j] == false){
                    second += arr[i][j];
                    second += arr[j][i];
                }

            }
        }
        int gap = Math.abs(first - second);

//        if(gap == 0){
//            System.out.println(gap);
//            System.exit(0);
//        }

        min = Math.min(gap, min);

    }
}
