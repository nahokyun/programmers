
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static private int leftCount;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}//입력 종료

		leftCount = n;//남은 숫자개수
		int result = 0;
		boolean flag = false;
		while (leftCount > 0) {
			Arrays.sort(arr);
			int startIdx = 0;

			startIdx = Math.abs(arr[0]) > Math.abs(arr[n - 1]) ? 0 : n - 1;
			//시작할점
			int cur = 0;
			cur=erase(arr,arr[startIdx]>0,m,startIdx);

			if (flag) {
				result += 2 * cur;
			} else {
				result += cur;
				flag = true;
			}
		}
		System.out.println(result);

	}

	private static int erase(int[] arr, boolean isPositive, int m, int startIdx) {
		int x = Math.abs(arr[startIdx]);
		if (isPositive) {
			for (int i = startIdx; i > startIdx - m&&i>=0; i--) {
				if (arr[i] <= 0) {
					break;
				} else {
					arr[i] = 0;
					leftCount--;
				}
			}
		} else {//시작이 음수일때
			for (int i = 0; i < m && i < arr.length; i++) {
				if (arr[i] >= 0) {
					break;
				} else {
					arr[i] = 0;
					leftCount--;
				}
			}
		}
		return x;
	}
}
