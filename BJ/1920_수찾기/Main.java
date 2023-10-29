
import java.io.*;
import java.util.*;
public class Main {
    static int N,M;
    static int[] arr, arr2;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        M = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            int num = Integer.parseInt(st.nextToken());
            if(search(num)){
                sb.append(1 + "\n");
            }else{
                sb.append(0 + "\n");
            }

        }

        System.out.println(sb);


    }
    private static boolean search(int num){
        int left = 0;
        int right = N-1;

        while(left <= right){
            int mid = (left+right)/2;
            if(num > arr[mid]){
                left = mid+1;
            }else if(num < arr[mid]){
                right = mid-1;
            }else{
                return true;
            }
        }

        return false;
    }
}
