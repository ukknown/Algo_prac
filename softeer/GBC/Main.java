import java.util.*;
import java.io.*;


public class Main
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        //각 구간의 길이 및 해당 구간 제한속도 
        int N = Integer.parseInt(st.nextToken());
        //광우가 테스트하는 구간의 길이와 속도도
        int M = Integer.parseInt(st.nextToken());

        //구간 정보 입력 
        int[][] arr = new int[N][2];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        //광우 테스트 구간 정보 입력 
        int[][] test = new int[M][2];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            test[i][0] = Integer.parseInt(st.nextToken());
            test[i][1] = Integer.parseInt(st.nextToken());
        }

        //가장 크게 벗어난 값 
        int result = 0;

        //
        int check = 0;

        for(int i = 0; i < N; i++){
            for(int j = check; j < M; j++){
                //광우의 테스크 구간 값이 더 클 경우
                if(arr[i][0] < test[j][0]) {
                    //초과된 구간을 다음에 계산하기 위해 arr[i][0] 값 빼줌 
                    test[j][0] -= arr[i][0];
                    //가장 크게 벗어난 값 계산
                    if(test[j][1] - arr[i][1] > 0) result = Math.max(result, test[j][1] - arr[i][1]);
                    //정규 구간 다음 구간으로 
                    break;
                } else if(arr[i][0] > test[j][0]) {//광우 테스트 구간보다 더 긴 경우
                    //광우가 검사한 부분까지 빼줌
                    arr[i][0] -= test[j][0];
                    //가장 크게 벗어난 값 계산
                    if(test[j][1] - arr[i][1] > 0) result = Math.max(result, test[j][1] - arr[i][1]);
                    //광우 테스트 이전 구간을 모두 검사 완료 다음 구간 검사하도록 함 
                    check++;
                } else {
                    //가장 크게 벗어난 값 계산
                    if(test[j][1] - arr[i][1] > 0) result = Math.max(result, test[j][1] - arr[i][1]);
                    //광우 테스트 이전 구간을 모두 검사 완료 다음 구간 검사하도록 함
                    check++;
                    break;
                }
            }

        }

        System.out.println(result);




    }
}
