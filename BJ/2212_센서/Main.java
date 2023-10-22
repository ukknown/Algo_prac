import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] arr = new int[N];


        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr); //오름차순 정렬

        Integer[] diff = new Integer[N-1];
        for(int i = 1; i < N; i++){ //각 센서별 거리를 저장
            diff[i-1] = arr[i] - arr[i-1];
        }

        Arrays.sort(diff, Collections.reverseOrder()); //내림차순 정렬

        int sum = 0;
        for(int i = K-1; i < N-1; i++){ // K개의 센서면 k-1개 만큼 그룹을 나눌 수 있음. 최소값이 되야함으로 가장 큰 값들 제외
            sum += diff[i];
        }

        System.out.println(sum);




    }
}
