import java.util.*;
import java.io.*;
public class Main {
    static int s,p;
    static int[] DNA;
    static int[] arr;
    static char[] str;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        DNA = new int[4];
        arr = new int[4];
        int count = 0;
        s = Integer.parseInt(st.nextToken()); //임의 문자열의 길이
        p = Integer.parseInt(st.nextToken()); //비밀번호 문자열 길이

        str = br.readLine().toCharArray(); //임의 문자열

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++){ //부분 문자열에 포함되어야 할 최소 개수
            DNA[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < p; i++){ //시작 문자 부터 비밀번호 길이까지 DNA문자열 확인
            switch(str[i]){
                case 'A':
                    arr[0]++;
                    break;
                case 'C':
                    arr[1]++;
                    break;
                case 'G':
                    arr[2]++;
                    break;
                case 'T':
                    arr[3]++;
                    break;
            }
        }

        if(check())count++; // 최소 개수 만족 여부 확인

        int i = 0;

        for(int j = p; j < s; j++){ //슬라이딩 윈도우 추가할 가장 뒤 인덱스
            i = j - p; // 제거할 가장 앞 인덱스


            switch(str[j]){ //추가된 인덱스 DNA 문자열인지 확인
                case 'A':
                    arr[0]++;
                    break;
                case 'C':
                    arr[1]++;
                    break;
                case 'G':
                    arr[2]++;
                    break;
                case 'T':
                    arr[3]++;
                    break;
            }

            switch(str[i]){ // 제거된 인덱스의 값 카운트 제거
                case 'A':
                    arr[0]--;
                    break;
                case 'C':
                    arr[1]--;
                    break;
                case 'G':
                    arr[2]--;
                    break;
                case 'T':
                    arr[3]--;
                    break;
            }

            if(check())count++; // DNA문자열 여부 확인
        }




        System.out.println(count);



    }
    public static boolean check(){
        for(int i = 0; i < 4; i++){
            if(arr[i] < DNA[i])return false;
        }
        return true;
    }
}
