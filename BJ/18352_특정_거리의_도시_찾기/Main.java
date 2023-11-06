
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //도시 개수
        int M = Integer.parseInt(st.nextToken()); //도로 개수
        int K = Integer.parseInt(st.nextToken()); //거리 정보
        int X = Integer.parseInt(st.nextToken()); //출발 도시 번호

        ArrayList<Integer>[] arr = new ArrayList[N+1];


        for(int i = 0; i <= N; i++){
            arr[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            arr[start].add(end);
        }

        int[] load = new int[N+1];
        Arrays.fill(load, Integer.MAX_VALUE);

        Queue<Integer> que = new LinkedList<>();
        load[X] = 0;

        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < arr[X].size(); i++){ //출반 도시 번호와 연결된 도시 추가
            que.add(X);
        }

        while(!que.isEmpty()){
            int s = que.poll();

            if(load[s] > K)break; // 찾으려는 거리 이상이면 끝
            if(load[s] == K){ //찾으려는 거리 도시면 추가
                result.add(s);
            }


            for(int i = 0; i < arr[s].size(); i++) { //출반 도시 번호와 연결된 도시 추가
                if(load[arr[s].get(i)] != Integer.MAX_VALUE)continue;
                load[arr[s].get(i)] = load[s] + 1;
                que.add(arr[s].get(i));
            }

        }

        Collections.sort(result);

        for(int i = 0; i < result.size(); i++){
            sb.append(result.get(i) + "\n");
        }
        if(result.size() == 0){
            sb.append(-1);
        }

        System.out.println(sb);




    }
}
