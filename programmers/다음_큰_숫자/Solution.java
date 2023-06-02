class Solution {
    public int solution(int n) {
        //주어진 숫자 다음 값을 알기 위해 변수 선언
        int num = n;
        
      //주어진 값의 2진수 1의 갯수
        int count1 = 0; 
        
      //주어진 값을 2진수로
        while(n > 1){
            if(n % 2 == 1){ //2진수 값이 1이면 카운트
              count1++;  
            }            
            n /= 2;            
        }
      
        int answer = 0;
      //주어진 값에서 +1씩 한 값을 확인하기 위해 변수선언
        int check = num;
        
      //1이 갯수가 같은 값이 나올 때 까지 반복
        while(true){
          //확인한 다음 값으로
            check++;
          //num은 현재 확인 값으로 최신화
            num = check;
            answer = num;
          
            int count2 = 0;
          //2진수 1 갯수 확인
            while(num > 1){
                if(num % 2 == 1){
                    count2++;  
                } 
                num /= 2;
            }
            //1갯수 동일하면 반복 멈춤
            if(count2 == count1){
                break;
            }
            
        }
        
        
        return answer;
    }
}
