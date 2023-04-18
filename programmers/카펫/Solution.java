class Solution {
    public int[] solution(int brown, int yellow) {       
        int[] answer = new int[2];
        int sum = brown + yellow;
        
        for(int i = 3; i < sum; i++){ // 갈색이 노란색 테두리에 있을 수 있는 최솟값
            int j = sum / i; 
            
            if(sum % i == 0 && j >= 3){ // sum값의 약수, 가로 세로 모두 3 이상이어야 함
                int x = Math.max(i,j); //세로
                int y = Math.min(i,j); //가로
                
                int center = (x-2) * (y-2); //노란색의 크기
                
                if(center == yellow){ // 약수로 구한 노란색 크기와 주어진 노란색 크기 동일해야
                    answer[0] = x;
                    answer[1] = y;
                }
            }
        }
        
        
        
        return answer;
    }
}
