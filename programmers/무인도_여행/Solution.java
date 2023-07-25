import java.util.*;

class Solution {
    public class info{
        int x;
        int y;
        public info(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int n,m, num;
    static char[][] map;
    static boolean[][] visited;
    
    public int[] solution(String[] maps) {
        System.out.println(maps.length + " " + maps[0].length());
        n = maps.length;
        m = maps[0].length();
        map = new char[n][m];
        visited = new boolean[n][m];
        
        for(int i = 0; i < n; i++){
            String[] str = maps[i].split("");            
            for(int j = 0; j < m; j++){
                map[i][j] = str[j].charAt(0);
                if(map[i][j] == 'X'){
                    visited[i][j] = true;
                }
            }
        }         
        
        ArrayList<Integer> answer = new ArrayList<>();;
        
        
        for(int i = 0; i < n; i++){                      
            for(int j = 0; j < m; j++){
                if(!visited[i][j]){
                    if(map[i][j] == '1'){
                        System.out.println(1);
                    }
                    BFS(i,j);
                    answer.add(num);                   
                }
                
                
            }            
        }
        
        
        if(answer.size() == 0){
            answer.add(-1);
            int[] result = new int[answer.size()];
            for(int i = 0; i < answer.size(); i++){
                result[i] = answer.get(i);
            }
            
            return result;
        }else{
            int[] result = new int[answer.size()];
            for(int i = 0; i < answer.size(); i++){
                result[i] = answer.get(i);
            }
            Arrays.sort(result);
                     
            return result;  
        }
        
     }
    public void BFS(int x, int y){
        Queue<info> que = new LinkedList<info>();
        que.add(new info(x,y));
        visited[x][y] = true;
        
        num = 0;
        while(!que.isEmpty()){
            info q = que.poll();
            num += Character.getNumericValue(map[q.x][q.y]);
            for(int i = 0; i < 4; i++){
                int nx = q.x + dx[i];
                int ny = q.y + dy[i];
                
                if(nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny])continue;    
                que.add(new info(nx, ny));
                visited[nx][ny] = true;
            }
        }
    }
}
