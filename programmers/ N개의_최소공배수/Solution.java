class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        int num = arr[0];
        
        for(int i = 1; i < arr.length; i++){
            int index = 1;
          
            while(true){
                int n = num*index;             
                index++;
                if(n%arr[i] == 0){
                    System.out.println(n);
                    num = n;
                    break;
                }
                
                
            }
        }
        
        answer = num;
        
        return answer;
    }
}
