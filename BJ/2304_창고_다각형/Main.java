import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int start  = Integer.MAX_VALUE;
        int end = 0;

        int[] arr = new int[1001];

        for(int tc = 0; tc < N; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int high = Integer.parseInt(st.nextToken());

            arr[left] = high;
            start = Math.min(start, left);
            end = Math.max(end, left);
        }

        Stack<Integer> stack = new Stack<>();

        int temp = arr[start];

        for(int i = start+1; i<= end; i++){
            if(arr[i] < temp){
                stack.push(i);
            }else{
                while(!stack.isEmpty()){
                    int x = stack.pop();
                    arr[x] = temp;
                }
                temp = arr[i];
            }
        }
        stack.clear();

        temp = arr[end];
        for(int i = end-1; i >= start; i--){
            if(arr[i] < temp){
                stack.push(i);
            }else{
                while(!stack.isEmpty()){
                    int x = stack.pop();
                    arr[x] = temp;
                }
                temp = arr[i];
            }
        }

        int result = 0;
        for(int i = start; i <= end; i++){
            result += arr[i];
        }

        System.out.println(result);





    }
}
