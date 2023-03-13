import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static boolean[][] visited;
    static int n, m, result;
    class info{
    	int x;
    	int y;
    	int dep;
    	public info(int x, int y, int dep) {
    		this.x = x;
    		this.y = y;
    		this.dep = dep;
    	}
    }
    public int solution(int[][] maps) {
    	n = maps.length;
    	m = maps[0].length;
    	visited = new boolean[n][m];
        int answer = 0;
        result = 0;
        
        
        ;
        
//        if(result == 0) {
//        	answer = -1;
//        }else {
//        	answer = result;
//        }
        
        return BFS(0,0,maps);
    }
	private int BFS(int x, int y, int[][] maps) {
		Queue<info> que = new LinkedList<>();
		que.add(new info(x,y,1));
		
		visited[x][y] = true;
		
		while(!que.isEmpty()) {
			info q = que.poll();
			
			if(q.x == n-1 && q.y == m-1) {
//				result = Math.min(result, q.dep);
				return q.dep;
			}
			
			for(int i = 0; i < 4; i++) {
				int nx = q.x + dx[i];
				int ny = q.y + dy[i];
				
				if(nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny] || maps[nx][ny] == 0)continue;
				
				que.add(new info(nx,ny, q.dep + 1));
				visited[nx][ny] = true;
			}
		}
		return -1;
	}
	
	

}
