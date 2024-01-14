
import java.io.*;
import java.util.*;
import java.awt.*;
class info implements Comparable<info>{
    int x;
    int y;
    int num;
    int t;
    public info(int x, int y, int num, int t){
        this.x = x;
        this.y = y;
        this.num = num;
        this.t = t;
    }

    @Override
    public int compareTo(info i){
        return this.num - i.num;
    }
}
public class Main {
    static int N,K;
    static int[][] field;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        field = new int[N][N];

        ArrayList<info> list = new ArrayList<>(); //입력된 바이러스 값을 오름차순 정렬하기 위해서
        Queue<info> que = new LinkedList<>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                field[i][j] = Integer.parseInt(st.nextToken());
                if(field[i][j] != 0){
                    list.add(new info(i,j, field[i][j],0));
                }
            }
        }
        Collections.sort(list);

        for(info o : list){
            que.add(o);
        }


        st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken()); //경과시간(초)
        int X = Integer.parseInt(st.nextToken()); //위치
        int Y = Integer.parseInt(st.nextToken()); //위치

        while(true){
            info q = que.poll();
          
            if(q.t == S || que.isEmpty()){
                break;
            }

            for(int d = 0; d < 4; d++){
                int nx = q.x + dx[d];
                int ny = q.y + dy[d];

                if(nx >= 0 && nx < N && ny >= 0 && ny < N && field[nx][ny] == 0){
                    field[nx][ny] = q.num;
                    que.add(new info(nx, ny, q.num, q.t+1));
                }
            }



        }

        System.out.println(field[X-1][Y-1]);

    }
}
