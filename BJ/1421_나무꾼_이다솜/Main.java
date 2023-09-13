import java.io.*;
import java.util.*;

public class BJ1421 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 나무개수
        int C= Integer.parseInt(st.nextToken()); // 자를 때 드는 비용
        int W = Integer.parseInt(st.nextToken()); // 나무 한 단위의 가격

        int[] tree = new int[N];

        int max = 0;

        for(int i = 0; i < N; i++){
            tree[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, tree[i]);
        }

        long result = Integer.MIN_VALUE;

        for(int i = 1; i <= max; i++){
            long sum = 0;
            for(int j = 0; j < N; j++){
                int cut = 0;
                if(tree[j] >= i){
                    if(tree[j] % i == 0){ //자르려는 단위의 배수와 나무 길이가 딱 맞으면
                        cut = tree[j]/i -1; // 자른 값에서 -1   ㅡ|ㅡ| 이렇게 되면 1번 잘랐지만 2개가 나옴 그래서 -1 
                    }else{
                        cut = tree[j]/i;
                    }

                    if(W * i * (tree[j]/i) - cut * C > 0){ //벌수 있는 돈(한단위 * 나무 길이 * 나무 개수)이 자르는 비용(자른 횟수 * 자르는 비용)보다 크다면 
                        sum += W * i * (tree[j]/i) - cut * C;
                    }

                }
            }
            result = Math.max(result, sum);

        }

        System.out.println(result);

    }
}
