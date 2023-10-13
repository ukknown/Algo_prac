import java.io.*;
import java.util.*;
public class Main {
    static int N,result;
    static int[] tree, arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());

        for(int T = 0; T < tc; T++){
            N = Integer.parseInt(br.readLine());

            tree = new int[N];
            arr = new int[N];
            visited = new boolean[N];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                tree[i] = Integer.parseInt(st.nextToken());
            }

            result = Integer.MAX_VALUE;

            int left = 0;
            int right = N-1;

            Arrays.sort(tree);

            for(int i = 0; i < N; i++){
                if(i%2 == 0){
                    arr[left] = tree[i];
                    left++;
                }else{
                    arr[right] = tree[i];
                    right--;
                }
            }

            int cal = 0;
            int m = 0;

            for(int i = 0; i < N; i++){
                if(i == 0){
                    cal = Math.abs(arr[i]-arr[N-1]);
                }else{
                    cal = Math.abs(arr[i]-arr[i-1]);
                }

                if(cal > m){
                    m = cal;
                }
            }
            result = Math.min(result, m);

            System.out.println(result);
        }
    }

}
