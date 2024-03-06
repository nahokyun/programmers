import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		String s=br.readLine();

		if(s.length()!=0) {
			int[][] addsum = new int[27][s.length()];

			addsum[s.charAt(0) - 'a'][0] = 1;

			for (int i = 1; i < s.length(); i++) {
				int cur = s.charAt(i) - 'a';

				for (int j = 0; j < 27; j++) {
					if (cur == j) {
						addsum[cur][i] = addsum[cur][i - 1] + 1;
						continue;
					}
					addsum[j][i] = addsum[j][i - 1];
				}
			}

			int q = Integer.parseInt(br.readLine());
			for (int i = 0; i < q; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int object = st.nextToken().charAt(0) - 'a';//찾고자 하는 문자
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				if (start != 0) {
					start--;
				} else {//start가 0일때
					sb.append(addsum[object][end]).append('\n');
					continue;
				}

				sb.append(addsum[object][end] - addsum[object][start]).append('\n');

			}
		}else{
			int q = Integer.parseInt(br.readLine());
			for(int i=0;i<q;i++){
				StringTokenizer st = new StringTokenizer(br.readLine());
				sb.append(0).append('\n');
			}
		}

		System.out.println(sb);

	}
}
