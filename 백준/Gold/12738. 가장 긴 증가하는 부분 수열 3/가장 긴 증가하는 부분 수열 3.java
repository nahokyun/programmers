import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int[] arr=new int[n+1];
		int[] dp=new int[n+1];
		
		for(int i=1;i<=n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		dp[0]=arr[1];
		int idx=1;
		for(int i=2;i<=n;i++) {
			if(arr[i]>dp[idx-1]) {
				dp[idx++]=arr[i];
				continue;
			}
			
			int left=0;
			int right=idx;
			while(left<right) {
				int mid=(left+right)>>1;
				if(dp[mid]<arr[i]) {
					left=mid+1;
				}else {
					right=mid;
				}
			}
			
			dp[right]=arr[i];
			
		}
		
		System.out.println(idx);
		
		
	}
}
