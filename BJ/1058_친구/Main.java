

import java.io.*;
import java.util.*;
import java.awt.*;
public class Main {
    static int N,count;
    static char[][] line;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        line = new char[N][N];

        for(int i = 0; i < N; i++){
            String s = br.readLine();
            for(int j = 0; j < N; j++){
                line[i][j] = s.charAt(j);
            }
        }

        int result = 0;
        for(int i = 0; i < N; i++){
            visited = new boolean[N];
            visited[i] = true; //확인된 친구

            Queue<Integer> que = new LinkedList<>();
            que.add(i); //0번 부터 2-친구 확인 시작

            int dep = 0; // 한다리 건너서까지만 확인
            int cnt = 0; // 2-친구

            while(dep < 2){

                int size = que.size(); //확인하는 번호의 사람과 연결된 친구들 확인을 위한 변수

                for(int k = 0; k < size; k++){
                    int n = que.poll();

                    for(int j = 0; j < N; j++){
                        if(line[n][j] == 'Y' && !visited[j]){
                            cnt++;
                            que.add(j);
                            visited[j] = true;
                        }
                    }
                }
                dep++;
            }

            result = Math.max(result, cnt);
        }

        System.out.println(result);



    }



}
