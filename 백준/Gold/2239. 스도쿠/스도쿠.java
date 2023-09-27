
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static StringBuilder sb = new StringBuilder();
	private static boolean[][] checkCol;
	private static boolean[][] checkRow;
	private static boolean[][] checkSq;
	static boolean flag=false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] map = new int[9][9];
		boolean[][] origin = new boolean[9][9];
		checkRow = new boolean[9][10];
		checkCol = new boolean[9][10];
		checkSq = new boolean[9][10];

		for (int i = 0; i < 9; i++) {
			String s = br.readLine();
			for (int j = 0; j < 9; j++) {
				map[i][j] = s.charAt(j) - '0';
				if (map[i][j] != 0) {
					origin[i][j] = true;
					checkRow[i][map[i][j]] = true;
					checkCol[j][map[i][j]] = true;
					checkSq[3 * (i / 3) + j / 3][map[i][j]] = true;
				}
			}
		}
		// 입력종료
		track(map, 0);

	}

	private static void track(int[][] map, int num) {
		if(flag)
			return;
		if (num == 81) {

			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(map[i][j]);
				}
				sb.append('\n');
			}

			System.out.println(sb);
			flag=true;

			return;
		}

		int y = num / 9;
		int x = num % 9;
		if (map[y][x] == 0) {
			for (int i = 1; i <= 9; i++) {
				if(flag)
					return;
				if (!checkRow[y][i] && !checkCol[x][i] && !checkSq[3 * (y / 3) + x / 3][i]) {
					checkRow[y][i] = true;
					checkCol[x][i] = true;
					checkSq[3 * (y / 3) + x / 3][i] = true;
					map[y][x] = i;
					track(map, num + 1);
					map[y][x] = 0;
					checkRow[y][i] = false;
					checkCol[x][i] = false;
					checkSq[3 * (y / 3) + x / 3][i] = false;
				}
			}
		} else {
			track(map, num + 1);
		}

	}

	private static boolean check(int[][] map) {
		for (int i = 0; i < 9; i++) {
			boolean[] row = new boolean[10];

			for (int j = 0; j < 9; j++) {
				row[map[i][j]] = true;
			}
			for (int j = 1; j <= 9; j++) {
				if (!row[j])
					return false;
			}
		}

		for (int i = 0; i < 9; i++) {
			boolean[] col = new boolean[10];

			for (int j = 0; j < 9; j++) {
				col[map[j][i]] = true;
			}
			for (int j = 1; j <= 9; j++) {
				if (!col[j])
					return false;
			}
		}

		for (int k = 0; k < 3; k++) {
			for (int l = 0; l < 3; l++) {
				boolean[] sq = new boolean[10];

				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						sq[map[3 * k + i][3 * l + j]] = true;
					}
				}

				for (int i = 1; i <= 9; i++) {
					if (!sq[i])
						return false;
				}

			}
		}

		return true;

	}

}
