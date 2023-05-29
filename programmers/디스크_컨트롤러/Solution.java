import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int end = 0; //수행되고난 직후의 시간
        int jobsIdx = 0; //jobs 배열의 인덱스
        int count = 0; // 수행된 요청의 갯수
        
        
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);// jobs배열 오름차순 정렬(요청 시간으로)
        
        // 처리 시간 오름차순으로 정렬한 우선순위 큐
        PriorityQueue<int[]> pq = new PriorityQueue<>( (o1, o2) -> o1[1] - o2[1] );
        
        while(count < jobs.length){// 모든 요청이 수행될 때 까지
            
            
            //하나의 요청 작업이 완료될 때 까지 오는 요청 모두 큐에 넣음
            while(jobsIdx < jobs.length && jobs[jobsIdx][0] <= end){
                pq.add(jobs[jobsIdx++]);
            }
            
            //큐가 비어있다면 작업 완료 이후에 다시 요청이 들어옴
            //end를 다음 요청 가정 처음으로 맞춤
            if(pq.isEmpty()){
                end = jobs[jobsIdx][0];
            }else{
                int[] temp = pq.poll();
                //요청별 총 시간 = 요청 작업시간 + 작업 시작 시간 - 작업 요청이 들어온 시간
                answer += temp[1] + end - temp[0];
                end += temp[1];
                count++;               
            }
            
            
            
        }
        

        return answer/jobs.length;
    }
}
