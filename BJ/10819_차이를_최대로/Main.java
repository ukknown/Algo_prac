
import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static int max = Integer.MIN_VALUE;
    static int[] num, arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N= Integer.parseInt(br.readLine());

        num = new int[N];
        arr = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        perm(0);
        System.out.println(max);

    }
    private static void perm( int dep){
        if(dep == N){
            int sum = 0;
            for(int i = 1; i < N; i++){
                int cal = arr[i-1] - arr[i];
                sum += Math.abs(cal);
            }

            max = Math.max(max, sum);
            return;
        }

        for(int i = 0; i < N; i++){
            if(!visited[i]){
                arr[dep] = num[i];
                visited[i] = true;
                perm(dep+1);
                visited[i] = false;
            }

        }

    }
}
