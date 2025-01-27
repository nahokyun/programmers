import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		int n=Integer.parseInt(br.readLine());
		long[] arr=new long[n];
		StringTokenizer st=new StringTokenizer(br.readLine());


		for(int i=0;i<n;i++){
			arr[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		long ability=Long.MAX_VALUE;
		int ss = 0;
		int dd = 0;
		int cc=0;

		for(int i=0;i<n-2;i++) {
			long cur=arr[i];
			int s=i+1;
			int d=n-1;

			while (s != d) {
				long abs = Math.abs(arr[s] + arr[d]+cur);
				if (abs < ability) {
					ability = abs;
					ss = s;
					dd = d;
					cc=i;
				}
				if (arr[s] + arr[d]+cur < 0) {
					s++;
				} else if (arr[s] + arr[d]+cur > 0) {
					d--;
				} else {
					break;
				}
			}
		}

		System.out.println(arr[cc]+" "+arr[ss]+" "+arr[dd]);

	}
}
