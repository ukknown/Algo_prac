package com.ssafy.hw.day1.algo.BJ;

import java.io.*;
import java.util.*;
class info{
    int x;
    int y;
    public info(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int N,L,R;
    static int[][] arr;
    static ArrayList<info> list;
    static boolean[][] visited1, visited2;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        //16234 인구이동
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int day = 0;
        while (true) {
            boolean flag = false; //국경 열수 있는 구역 있다는 표시
            visited1 = new boolean[N][N]; //연합 구역 체크용
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited1[i][j] && check(i, j)) { //4방 탐색으로 국경 열기 가능 여부 확인
                        flag = true; //국경 열 구역 존재
                        visited2 = new boolean[N][N];//1개 연합 구역 체크용
                        list = new ArrayList<>();
                        BFS(i, j); //1개 연합 구역 체크
                    }
                }
            }

            if(!flag){
                break;
            }else{
                day++;
            }

        }


        System.out.println(day);


    }


    private static void change(int num){
        for(int i = 0; i < list.size(); i++){
            arr[list.get(i).x][list.get(i).y] = num;
        }
    }
    private static void BFS(int x, int y){
        Queue<info> que = new LinkedList<>();
        que.add(new info(x,y));
        list.add(new info(x,y));
        visited1[x][y] = true;

        int c = 1;
        int sum = arr[x][y];

        while(!que.isEmpty()){
            info q = que.poll();

            for(int i = 0; i < 4; i++){ //4방 탐색
                int nx = q.x + dx[i];
                int ny = q.y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < N && ny < N && !visited1[nx][ny] &&L <= Math.abs(arr[q.x][q.y]-arr[nx][ny]) && R >= Math.abs(arr[q.x][q.y]-arr[nx][ny])){
                  //범위 체크 및 연합체크
                  que.add(new info(nx, ny));
                  visited1[nx][ny] = true;
                  list.add(new info(nx,ny));
                  c++;
                  sum += arr[nx][ny];
                }
            }
        }

        int po = sum/c; //분산될 인구 수
        change(po); //인구 이동

    }
    private static boolean check(int x, int y){ //국경 열기 가능 여부 확인
        int count = 0;
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny >= 0 && nx < N && ny <N && L <= Math.abs(arr[x][y]-arr[nx][ny]) && R >= Math.abs(arr[x][y]-arr[nx][ny])){
                count++;
            }
        }

        if(count == 0){
            return false;
        }
        return true;
    }
}
