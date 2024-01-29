import java.io.*;
import java.util.*;

public class Main {
    static int A,B;
    static int[][] light = {{1,1,1,0,1,1,1},   //전광판 번호별 켜지는 위치
                            {0,0,1,0,0,1,0},
                            {1,0,1,1,1,0,1},
                            {1,0,1,1,0,1,1},
                            {0,1,1,1,0,1,0},
                            {1,1,0,1,0,1,1},
                            {1,1,0,1,1,1,1},
                            {1,1,1,0,0,1,0},
                            {1,1,1,1,1,1,1},
                            {1,1,1,1,0,1,1},
                            {0,0,0,0,0,0,0}
                           };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++){
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            int result = 0;
            int divide = 10000; //전광판 하나의 값 구하기 위한 변수
            boolean flag1 = false; //전광판 앞쪽이 켜지는 지 여부 false면 0이어도 전광판 앞이 안켜진다.
            boolean flag2 = false;
            
            for(int i = 0; i < 5; i++){
                int tmp = A/divide;
                int tmp2 = B/divide;

                if(!flag1){ //전광판 앞이 안켜진다 
                    if(tmp == 0){
                        tmp = 10; //안켜진다.
                    }else{
                        flag1 = true;
                    } 
                }

                if(!flag2){
                    if(tmp2 == 0){
                        tmp2 = 10;
                    }else{
                        flag2 = true;
                    }
                }

                int diff = check(tmp, tmp2);

                result+= diff;
                A %= divide;
                B %= divide;
                divide /= 10;
            }

            System.out.println(result);
            
        }
        
    }
    private static int check(int A, int B){
        int count = 0;
        for(int i = 0; i < 7; i++){
            if(light[A][i] != light[B][i]){
                count++;
            }
            
        }
        return count;
    }
}
