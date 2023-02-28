import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //동전 종류

        int K = Integer.parseInt(st.nextToken()); // 나눌 돈

        int[] coin = new int[N]; //동전 단위 저장할 배열

        for(int i = N-1 ; i >= 0; i--){ //동전 단위 저장
            coin[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;

        for(int i = 0; i < N; i++){ // 큰 단위부터 나누면 최소 동전 갯수를 구할 수 있다.
            if(coin[i] <= K) {
                int num = K / coin[i];
                K = K % coin[i];
                count += num;
            }
        }
        System.out.println(count);


    }
}
