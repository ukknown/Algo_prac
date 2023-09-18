class Solution {
    public int solution(int n) {
        
        int[] arr = new int[n+1];
        
        for(int i = 1; i < n+1; i++){ //배열에 모든 값을 i로 저장
            arr[i] = i;
        }
        
        for(int i = 2; i < n+1; i++){ //i의 배수를 모두 0으로 바꿔준다 = 반복하면 소수만 남음
            if(arr[i] != 0){ //0으로 바뀐 부분은 넘어간다.
                for(int j = i + i; j < n+1; j+=i){
                    arr[j] = 0;
                }
            }
        }
        
        int answer = 0;
        for(int i = 2; i < n+1; i++){ //0이 아니면 카운트
            if(arr[i] != 0)answer++;
        }
       
        return answer;
    }
}
