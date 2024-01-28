import java.io.*;
import java.util.*; 

public class Main {	
    public static void main(String[] args) throws Exception{		
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
        StringTokenizer st = new StringTokenizer(br.readLine());		
        int i, n=Integer.parseInt(st.nextToken()), h=Integer.parseInt(st.nextToken()), t=Integer.parseInt(st.nextToken());		
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());		// 가장 큰 키를 표현하기 위해 내림차순 우선순위 큐 생성		
        for(i=0;i<n;i++)			
            pq.add(Integer.parseInt(br.readLine()));		
        for(i=0;i<t;i++){						
            if(pq.peek()<h)	// 최대 값이 h보다 작으면 더이상 탐색할 필요 X				
                break;			
            if(pq.peek()>1)	// 값이 1보다 클 경우에만 나눌 수 있음 				
                pq.add(pq.poll()/2);		}		
        if(pq.peek()>=h)	// 최대값이 키보다 같거나 크면 NO를 출력하고 가장 큰 키를 출력			
            System.out.println("NO\n"+pq.peek());		
        else			
            System.out.println("YES\n"+i);	// 아니면 망치의 사용횟수를 출력	
    }
}
