package com.ssafy.hw.day1.algo.BJ;

import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] amount = new int[100001];

        amount[1] = 1;
        amount[2] = 1;
        amount[3] = 2;
        amount[4] = 2;
        amount[5] = 1;
        amount[6] = 2;
        amount[7] = 1;


        for(int i = 8; i < amount.length; i++){
           int a = Math.min(amount[i-1], amount[i-2]);
           int b = Math.min(amount[i-5], amount[i-7]);

           amount[i] = Math.min(a,b)+1;
          //amount[i] = Math.min( Math.min(amount[i-1], amount[i-2]), Math.min(amount[i-5], amount[i-7])+1;
        }

      System.out.println(amount[N]);

    }

}
