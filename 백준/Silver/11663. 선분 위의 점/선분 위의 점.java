
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		StringBuilder sb=new StringBuilder();

		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());

		int[] arr=new int[n];

		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++){
			arr[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		for(int i=0;i<m;i++) {
			int result=0;
			st = new StringTokenizer(br.readLine());
			int start=Integer.parseInt(st.nextToken());
			int end=Integer.parseInt(st.nextToken());


			int startIdx=find(arr,start);
			int endIdx=find(arr,end);

			if(arr[endIdx]<=end)
				result+=1;
			if(arr[startIdx]<start)
				result-=1;

			result+=endIdx-startIdx;
			sb.append(result).append('\n');
		}
		System.out.println(sb);
	}

	private static int find(int[] arr, int num) {
		int start=0;
		int end=arr.length-1;
		int mid=0;
		while(start<=end){
			mid=(start+end)>>1;
			if(arr[mid]>num)
				end=mid-1;
			else if(arr[mid]<num)
				start=mid+1;
			else
				return mid;
		}
		return mid;
	}

}
