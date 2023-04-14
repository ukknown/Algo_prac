import java.util.*;
class info {
        int x;
        int y;
        int dep;
        
        public info(int x, int y, int dep){
            this.x = x;
            this.y = y;
            this.dep = dep;
        }
    }
class Solution {
    static boolean[][] visited;
    static int x_size,y_size, answer;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static char[][] field;
    
    public int solution(String[] maps) {
        x_size = maps.length; // maps의 길이
        y_size = maps[0].length();  // maps[0] 문장의 길이
        field = new char[x_size][y_size]; 
        info start = null;
        info lever = null;
        info end = null;
        for(int i = 0; i < x_size; i++){
            for(int j = 0 ; j < y_size; j++){
                field[i][j] = maps[i].charAt(j);
                if(maps[i].charAt(j) == 'S'){
                    start = new info(i, j ,0);                  
                }
                if(maps[i].charAt(j) == 'L'){
                    lever = new info(i, j ,0);                  
                }
                if(maps[i].charAt(j) =='E'){
                    end = new info(i, j ,0);                  
                }                
            }                      
        }
        
        answer = 0;    
        visited = new boolean[x_size][y_size];
        
        answer = bfs(start, lever);   //레버를 먼저 방문해서 출구문을 열수 있도록 한다.     
        if(answer > -1){
            visited = new boolean[x_size][y_size]; // 방문 기록 리셋시킨다.
            int temp = bfs(lever, end);    //레버에서 부터 출구로 이동        
            if(temp == -1){
                answer = -1;
            }else{
                answer += temp;
            }
        }
        
        return answer;
    }
    
    public int bfs(info start, info end){
        Queue<info> que = new LinkedList<>();
        que.add(start);
        visited[start.x][start.y] = true;
        
        while(!que.isEmpty()){
            info q = que.poll();
            
            if(q.x == end.x && q.y == end.y){
                return q.dep;
            }
            for(int i = 0; i < 4; i++){
                int nx = q.x + dx[i];
                int ny = q.y + dy[i];
                
                if(nx < 0 || nx >= x_size || ny < 0 || ny >= y_size)continue; 
                
                if(!visited[nx][ny] && field[nx][ny] != 'X'){
                    que.add(new info(nx, ny, q.dep+1)); 
                    visited[nx][ny] = true;
                }
                
                
            }            
        }
        
        return -1;
        
    }
}
