package com.ssafy.hw.day1.algo;


import java.awt.*;
import java.io.*;
import java.util.*;

public class BJ2468 {
    static int N;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];

        int max = Integer.MIN_VALUE; //최고 높이 변수

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, arr[i][j]);
            }
        }

        int MaxArea = 0; // 가장 영역이 많은 값 저장 변수


        int round = max+1; //비의 양 최대치


        for(int r = 0; r < round; r++){
            visited = new boolean[N][N];

            check(r);
            int count = 0;

            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++) {
                    if(visited[i][j])continue;
                    count++;
                    Area(i, j);

                }
            }
            MaxArea = Math.max(MaxArea, count);


        }
        System.out.println(MaxArea);



    }
    public static void check(int h){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(arr[i][j] <= h)visited[i][j] = true;
            }
        }
    }
    public static void Area(int i, int j){
        Queue<Point> que = new LinkedList<>();
        que.add(new Point(i,j));
        visited[i][j] = true;

        while(!que.isEmpty()){
            Point q = que.poll();

            for(int d = 0; d < 4; d++){
                int nx = q.x + dx[d];
                int ny = q.y + dy[d];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny])continue;
                que.add(new Point(nx,ny));
                visited[nx][ny] = true;
            }
        }

    }
}
