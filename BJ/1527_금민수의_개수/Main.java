package com.ssafy.hw.day1.algo.BJ;

import java.io.*;
import java.util.*;
public class Main {
    static int a,b,result;
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        dfs(0);


        System.out.println(result);

    }
    private static void dfs(long num){
        if(num > b)return;

        if(num >= a && num <= b)result++;

        dfs(num*10+4); //끝에 4를 늘림
        dfs(num*10+7); //끝에 7을 늘림

    }



}
