import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static boolean[] visited;
    static ArrayList<Integer> list;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());


        arr = new int[N+1];
        visited = new boolean[N+1];

        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }


        list = new ArrayList<>();
        for(int i = 1; i <= N; i++){
            visited[i] = true;
            DFS(i,i);
            visited[i] = false;
        }

        Collections.sort(list);
        System.out.println(list.size());
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }



    }
    private static void DFS(int start, int target){
        if(arr[start] == target){ //사이클이되면 결과list에 추가
            list.add(target);
        }

        if(!visited[arr[start]]){
            visited[arr[start]] = true;
            DFS(arr[start], target);
            visited[arr[start]] = false;
        }
    }
}
