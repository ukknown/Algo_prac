import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, r, c, d, dir, count;
	static int[][] arr;

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		// 방 크기
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N][M]; // 방

		st = new StringTokenizer(br.readLine());
		// 로봇 청소기 위치 좌표
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		// 로봇청소기가 바라보는 방향
		d = Integer.parseInt(st.nextToken());

		// 방 청소해야야할 칸 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		count = 1;
		dir = 0;

		move(r, c, d);
		System.out.println(count);

	}

	private static void move(int r, int c, int dir) {

		arr[r][c] = -1; // 청소

		for (int i = 0; i < 4; i++) {
			dir -= 1; //반시계 90도씩 변화
			
			if(dir == -1) dir = 3;
			
			int nx = r + dx[dir];
			int ny = c + dy[dir];

			if (nx >= 0 && nx < N && ny >= 0 && ny < M && arr[nx][ny] == 0) {
				count++;
				move(nx, ny, dir);
				return;
			}
		}

		int back = (dir + 2) % 4; //반대방향 후진
		int bx = r + dx[back];
		int by = c + dy[back];

		if (by >= 0 && by < M && bx < N && bx >= 0 && arr[bx][by] != 1) {
			move(bx, by, dir);

		}

	}
}
