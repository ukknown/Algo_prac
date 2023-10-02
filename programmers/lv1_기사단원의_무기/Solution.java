class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        int[] arr = new int[number+1];
        
        for(int i = 1; i < arr.length; i++){ //약수 추가
            for(int j = i; j < arr.length; j+=i){
                    arr[j]++;

            }
        }
         
        for(int i = 1; i < arr.length; i++){
            if(arr[i] <= limit){
                answer += arr[i];
            }else{
                answer += power;
            }
        }
        
        return answer;
    }
}
