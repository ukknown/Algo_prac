


class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        
        int[][] answer = new int[arr1.length][arr2[0].length];
      //행렬곱
      //R[0][0] += A[i][0] * B[0][j]
      //R[0][0] += A[i][1] * B[1][j]

 
        for(int i = 0; i < arr1.length; i++){
            for(int j = 0; j < arr2[0].length; j++){
                for(int k = 0; k < arr2.length; k++){
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
            
        }
                
        return answer;
    }
}
