
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[][] arr = new int[H][W];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < W; i++){
            int num = Integer.parseInt(st.nextToken());
            for(int j = 0; j < num; j++){
                arr[j][i] = 1;
            }
        }


        int result = 0;
        for(int i = 0; i < H; i++){
            boolean flag = false;
            int count = 0;
            for(int j = 0; j < W; j++){
                if(!flag && arr[i][j] == 1){ //좌측에 벽이 있다
                    flag = true;
                }else if(flag && arr[i][j] == 0){ // 벽이 있고 현재 비어있다 채운다
                    count++;

                }else if(flag && arr[i][j] == 1){ // 벽이 있고 또 벽이 나왔다 = 빗물 총량에 추가
                    result += count;
                    count = 0;
                }
            }

        }

        System.out.println(result);



    }
}
