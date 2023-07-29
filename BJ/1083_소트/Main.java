
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Integer> arr = new ArrayList<>();

        for(int i = 0; i < N; i++){
            arr.add(Integer.parseInt(st.nextToken()));
        }

        int S = Integer.parseInt(br.readLine());

        int moveCnt = 0, changeIdx = 0; //움직인 횟수와 변한 시작 위치

        while(moveCnt < S && changeIdx < N-1){ // 범위 확인
            int maxNum = arr.get(changeIdx), maxIdx = -1;

            int idx = changeIdx + 1, count = 1; // 양 옆만 교환 가능 -> 비교할 숫자 위치

            while(moveCnt + count <= S && idx < N){ //교환 가능 횟수 범위 체크와 비교값 위치 범위 체크
                int num = arr.get(idx);
                if(num > maxNum){ //비교 값이 더 크면 교환
                    maxNum = num;
                    maxIdx = idx;
                }
                count++;
                idx++;
            }

            if(maxIdx != -1){ //최댓값이 변했다면 값 교환
                arr.remove(maxIdx);
                arr.add(changeIdx, maxNum);
                moveCnt += maxIdx - changeIdx;
            }
            changeIdx++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i : arr){
            sb.append(i).append(' ');
        }
        System.out.println(sb);
        br.close();





    }
}
