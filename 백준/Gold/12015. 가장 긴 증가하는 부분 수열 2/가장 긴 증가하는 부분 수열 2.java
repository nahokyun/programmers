import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int[] arr=new int[n];
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++){
			arr[i]=Integer.parseInt(st.nextToken());
		}

		int[] longestArr=new int[n];
		longestArr[0]=arr[0];
		int idx=0;
		for(int i=1;i<n;i++){
			int cur=arr[i];
			if(cur>longestArr[idx]){
				longestArr[++idx]=cur;
				continue;
			}

			int left=0;
			int right=idx;
			int mid=0;
			while(left<right){
				mid=(left+right)>>1;
				if(longestArr[mid]>=cur){
					right=mid;
				}else{
					left=mid+1;
				}
			}
			longestArr[right]=cur;
		}

		System.out.println(idx+1);
	}
}
