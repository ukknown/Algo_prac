package ws;

import java.io.BufferedReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static class shark {
		int r;
		int c;
		int s;
		int d;
		int z;

		public shark(int r, int c, int s, int d, int z) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}

		public shark(int s, int d, int z) {
			super();
			this.s = s;
			this.d = d;
			this.z = z;
		}

	}

	static int R, C, M, sum;
	static shark[][] sea;
	static int[][] map;
	static shark[][] copy;
	static int[][] copy2;
	static shark[] Sinfo;
	static int[] dx = {0, -1, 1, 0, 0 };
	static int[] dy = {0, 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		sea = new shark[R + 1][C + 1];
		map = new int[R + 1][C + 1];
		Sinfo = new shark[M + 1];

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(bf.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());

			map[r][c] = i;
			Sinfo[i] = new shark(r, c, s, d, z);
		}

		sum = 0;

		for (int i = 1; i <= C; i++) {// 사냥꾼 이동
			int fish = 0;
			for (int j = 1; j <= R; j++) {// 사냥꾼 위치에 상어 존재 여부
				if (map[j][i] != 0) {
					fish += 1;
					sum += Sinfo[map[j][i]].z;
					map[j][i] = 0;
					Sinfo[map[j][i]] = null;
					Move(); //상어 이동
					break;
				}
				
			}			
			if(fish == 0) { //사냥꾼 위치에서 사냥감이 없었을 경우
				Move();
			}


		}
		System.out.println(sum);

	}

	private static void Move() {
		copy2 = new int[R + 1][C + 1];
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				if (map[i][j] != 0) {
					shark shark = Sinfo[map[i][j]];
		
					int move = shark.s;

					switch (shark.d) {
					case 1:// 위로 이동
						if (move > (R * 2) - 2) {// 한바퀴 돌아 제자리로 되돌아오는 경우 나눠줌
							move %= (R * 2 - 2);
							if (move == 0)
								move = (R * 2 - 2);
						}

						while (move-- > 0) {// 속도만큼 이동
							shark.r += dx[shark.d];

							if (shark.r > R) {// 끝에 도달하면 방향전환 - 아래-> 위
								shark.d = 1;
								shark.r -= 1;
								move += 1;
							} else if (shark.r == 0) {// 끝에 도달하면 방향전환 - 위-> 아래
								shark.d = 2;
								shark.r += 1;
								move += 1;
							}
						}
						break;
					case 2:// 아래로 이동
						if (move > (R * 2) - 2) {// 한바퀴 돌아 제자리로 되돌아오는 경우 나눠줌
							move %= (R * 2 - 2);
							if (move == 0)
								move = (R * 2 - 2);
						}

						while (move-- > 0) {// 속도만큼 이동
							shark.r += dx[shark.d];

							if (shark.r > R) {// 끝에 도달하면 방향전환 - 아래-> 위
								shark.d = 1;
								shark.r -= 1;
								move += 1;
							} else if (shark.r == 0) {// 끝에 도달하면 방향전환 - 위-> 아래
								shark.d = 2;
								shark.r += 1;
								move += 1;
							}
						}
						break;
					case 3: // 왼쪽으로 이동
						if (move > (C * 2) - 2) {// 한바퀴 돌아 제자리로 되돌아오는 경우 나눠줌
							move %= (C * 2 - 2);
							if (move == 0)
								move = (C * 2 - 2);
						}

						while (move-- > 0) {// 속도만큼 이동
							shark.c += dy[shark.d];

							if (shark.c > C) {// 끝에 도달하면 방향전환 - 오른쪽->왼쪽
								shark.d = 4;
								shark.c -= 1;
								move += 1;
							} else if (shark.c == 0) {// 끝에 도달하면 방향전환 - 왼쪽-> 오른쪽
								shark.d = 3;
								shark.c += 1;
								move += 1;
							}
						}
						break;
					case 4:// 오른쪽으로 이동
						if (move > (C * 2) - 2) {// 한바퀴 돌아 제자리로 되돌아오는 경우 나눠줌
							move %= (C * 2 - 2);
							if (move == 0)
								move = (C * 2 - 2);
						}

						while (move-- > 0) {// 속도만큼 이동
							shark.c += dy[shark.d];

							if (shark.c > C) {// 끝에 도달하면 방향전환 - 오른쪽->왼쪽
								shark.d = 4;
								shark.c -= 1;
								move += 1;
							} else if (shark.c == 0) {// 끝에 도달하면 방향전환 - 왼-> 오
								shark.d = 3;
								shark.c += 1;
								move += 1;
							}
						}
						break;
					}
					
					//상어의 위치가 겹치는 경우 작은 녀석은 먹힘
					if (copy2[shark.r][shark.c] != 0 && Sinfo[copy2[shark.r][shark.c]].z > shark.z) {	
							Sinfo[map[i][j]] = null;
						continue;
	
					} else {
						Sinfo[copy2[shark.r][shark.c]] = null;
						int s =  map[i][j];
						copy2[shark.r][shark.c] = s;
					}
					

				}
				
			}
		}
		map = copy2;
	}

}
