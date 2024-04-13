
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private static int[][] map;
	private static int n;
	private static int maxScore;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		maxScore = 0;

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 입력 종료

		game(0);

		System.out.println(maxScore);
	}

	private static void game(int cur) {

		if (cur == 5) {
			findMax();
			return;
		}

		int[][] tmp = new int[n][n];
		for (int i = 0; i < n; i++) {
			tmp[i] = map[i].clone();
		}

		for (int i = 0; i < 4; i++) {
			move(i);
//			System.out.println("현재 i="+i);
//			for (int k = 0; k < n; k++) {
//				System.out.println(Arrays.toString(map[k]));
//			}
//			System.out.println();
			game(cur + 1);

			for (int j = 0; j < n; j++) {
				map[j] = tmp[j].clone();
			} // 원상복구
		}

	}

	private static void move(int dir) {
		switch (dir) {
		case 0:// 위로 땡길때

			for (int i = 0; i < n; i++) {
				int idx = 0;
				int before = 0;
				for (int j = 0; j < n; j++) {
					if (map[j][i] == 0)
						continue;
					if (map[j][i] == before) {
						map[idx - 1][i] = before * 2;
						map[j][i] = 0;
						before = 0;
					} else {
						before = map[j][i];
						map[j][i] = 0;
						map[idx][i] = before;
						idx++;
					}
				}
			}
			break;
		case 1:// 밑으로 땡길때

			for (int i = 0; i < n; i++) {
				int idx = n - 1;
				int before = 0;
				for (int j = n - 1; j >= 0; j--) {
					if (map[j][i] == 0)
						continue;
					if (map[j][i] == before) {
						map[idx + 1][i] = before * 2;
						before = 0;
						map[j][i] = 0;
					} else {
						before = map[j][i];
						map[j][i] = 0;
						map[idx][i] = before;
						idx--;
					}
				}
			}
			break;
		case 2:// 오른쪽으로 땡길때
			for (int i = 0; i < n; i++) {
				int idx = n - 1;
				int before = 0;
				for (int j = n - 1; j >= 0; j--) {
					if (map[i][j] == 0)
						continue;
					if (map[i][j] == before) {
						map[i][idx + 1] = before * 2;
						map[i][j] = 0;
						before = 0;
					} else {
						before = map[i][j];
						map[i][j] = 0;
						map[i][idx] = before;
						idx--;
					}
				}
			}
			break;
		case 3:// 왼쪽으로 땡길때
			for (int i = 0; i < n; i++) {
				int idx = 0;
				int before = 0;
				for (int j = 0; j < n; j++) {
					if (map[i][j] == 0)
						continue;
					if (map[i][j] == before) {
						map[i][idx - 1] = before * 2;
						map[i][j] = 0;
						before = 0;
					} else {
						before = map[i][j];
						map[i][j] = 0;
						map[i][idx] = before;
						idx++;
					}
				}
			}
			break;
		}

	}

	private static void findMax() {

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				maxScore = Math.max(maxScore, map[i][j]);
			}
		}

	}

}
