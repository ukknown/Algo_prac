
import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 접시의 수
        int d = Integer.parseInt(st.nextToken()); // 초밥의 가짓수
        int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수
        int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

        int[] sushi = new int[N];

        for(int i = 0; i < N; i++){
            sushi[i] = Integer.parseInt(br.readLine());
        }

        ArrayList<Integer> list = new ArrayList<>();
        int front = 0; // 투포인터 앞부분
        int back = k-1; //투포인터 뒷부분
        int count = 0;

        for(int i = 0; i < k; i++){
            if(!list.contains(sushi[i])){ //현재 가져간 스시목록에 없으면 갯수 추가 
                count++;
            }
            list.add(sushi[i]);  //스시 목록 추가
        }
        int result = count;

        if(!list.contains(c)){ //K개의 스시를 뽑고 그안에 쿠폰 번호의 스시가 없으면 갯수 추가
            result = Math.max(result, count+1);
        }else{
            result = Math.max(result, count);
        }



        for(int i = 0; i < N-1; i++){
            if(back == N-1){ //투포인터 뒷 부분 이동
                back = 0;
            }else{
                back++;
            }
            list.remove(0);
            if(!list.contains(sushi[front])){ //제거한 스시목록 스시번호가 스시목록에 없으면 갯수 줄임
                count--;
            }
            front++; //투포인터 앞 이동

            if(!list.contains(sushi[back])){
                count++;
            }
            list.add(sushi[back]);

            if(!list.contains(c)){
                result = Math.max(result, count+1);
            }else{
                result = Math.max(result, count);
            }


        }

        System.out.println(result);


    }

}
