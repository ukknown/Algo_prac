package com.ssafy.hw.day1.algo.BJ;

import java.io.*;
import java.util.*;
import java.awt.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String L = st.nextToken();
        String R = st.nextToken();

        int count = 0;

        if(L.length()== R.length()){ //R의 길이가 L보다 길면 무조건 8이 없는 숫자가 존재 ex)900000,80000
            for(int i = 0; i < L.length(); i++){ //앞부터 숫자 하나씩 비교
                if(L.charAt(i) != R.charAt(i)){ //다르면 8이 필요없는 숫자가 존재 끝
                    break;
                }else{
                    if(L.charAt(i) == '8'){ //같으면 무조건 8이 1개 들어감
                        count++;
                    }
                }
            }
        }

        System.out.println(count);


    }

}
