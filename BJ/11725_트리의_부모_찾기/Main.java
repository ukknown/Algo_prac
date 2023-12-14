import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
        for(int i = 0 ; i <= N; i++){
            tree.add(new ArrayList<>());
        }
        boolean[] visited = new boolean[N+1];
        int[] node = new int[N+1];



        for(int i = 0; i < N-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        Queue<Integer> que = new LinkedList<>();
        for(int nod : tree.get(1)){
            if(!visited[nod]){
                visited[nod] = true;
                que.add(nod);
                node[nod] = 1;
            }
        }

        while(!que.isEmpty()){
            int num = que.poll();

            for(int nod : tree.get(num)){
                if(!visited[nod]){
                    visited[nod] = true;
                    que.add(nod);
                    node[nod] = num;
                }
            }
        }

        for(int i = 2; i <= N; i++){
            System.out.println(node[i]);
        }



    }

}
