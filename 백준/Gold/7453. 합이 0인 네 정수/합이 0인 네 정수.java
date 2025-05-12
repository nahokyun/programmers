
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[4][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < 4; j++) {
				arr[j][i] = Integer.parseInt(st.nextToken());
			}
		}//입력종료

		int[] arrSum1 = new int[n * n];
		int[] arrSum2 = new int[n * n];
		int idx = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arrSum1[idx] = arr[0][i] + arr[1][j];
				arrSum2[idx++] = arr[2][i] + arr[3][j];
			}
		}
		Arrays.sort(arrSum1);
		Arrays.sort(arrSum2);

		int left = 0;
		int right = n * n - 1;
		long count=0;
		while (left < n * n && right >= 0) {
			if (arrSum1[left] + arrSum2[right] > 0) {
				right--;
			} else if (arrSum1[left] + arrSum2[right] < 0) {
				left++;
			} else {//합 0일 경우
				int c1 = 1;
				int c2 = 1;
				int tmp1 = arrSum1[left];
				int tmp2 = arrSum2[right];
				while (left + c1 < n * n && arrSum1[left + c1] == tmp1) {
					c1++;
				}
				while (right >= c2 && arrSum2[right - c2] == tmp2) {
					c2++;
				}
				left+=c1;
				right-=c2;
				count+=(long)c1*c2;

			}
		}

		System.out.println(count);
	}
}
