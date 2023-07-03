import java.io.*;
import java.util.*;
public class Main {
    static class info{
        int T;
        int P;
        public info(int T, int P){
            this.T = T;
            this.P = P;
        }
    }
    static int n;
    static int max;
    static info[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new info[n];

        StringTokenizer st;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());

            int Ti = Integer.parseInt(st.nextToken());
            int Pi = Integer.parseInt(st.nextToken());
            arr[i] = new info(Ti, Pi);
        }

        max = 0;
        DFS(0, 0);

        System.out.println(max);
        

    }

    private static void DFS(int cur, int Psum) {
        if(cur >= n){
            max = Math.max(max, Psum);
            return;
        }

        if(cur + arr[cur].T <= n){ //n이하라면 상담 기간 더 해주고 상담비 추가
            DFS(cur + arr[cur].T, Psum + arr[cur].P);
        }else{ //n을 넘는다면 상담 불가 탈출조건으로 보냄
            DFS(cur + arr[cur].T, Psum);
        }

        DFS(cur+1, Psum); // 상담 끝나는 날 이어서 상담이 아닌 하루 띄워서 상담날짜 입력

    }
}
