import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static class info implements Comparable<info>{
        int start;
        int end;

        info(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(info o) { //회의 종료 시간 오름차순으로 정렬하도록 조건 설정
            if(this.end == o.end){
                return this.start - o.start;
            }
            return this.end - o.end;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); //전체 회의의 수

        info[] meeting = new info[N]; //회의 정보 저장 배열

        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken()); //회의 시작 시간
            int e = Integer.parseInt(st.nextToken()); //회의 끝나는 시간

            meeting[i] = new info(s,e);
        }
        Arrays.sort(meeting); //배열 정렬

        int cnt = 0;
        int end = 0;

        for(int i = 0; i < N; i++){ //앞 회의의 끝과 다음 회의의 시작 시간을 비교
            if(end <= meeting[i].start){
                end = meeting[i].end;
                cnt++;
            }
        }

        System.out.println(cnt);

    }


}
