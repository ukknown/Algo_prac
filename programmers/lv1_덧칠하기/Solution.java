class Solution {
    public int solution(int n, int m, int[] section) {
        
        int[] arr = new int[n+1];
        
        for(int i = 0; i < section.length; i++){
            arr[section[i]] = 1;
        }
        
        int answer = 0;
        for(int i = 1; i < arr.length; i++){
            if(arr[i] == 1){
                if(i+m > n){
                    answer += 1; 
                    break;
                }
                for(int j = i; j < i+m; j++){
                    arr[j] = 0;
                }
                answer+=1;
            }
        }
        
        
        return answer;
    }
}
