
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());

		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		int[] arr=new int[n];
		int end=1_000_000_000;
		int start=0;

		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++){
			arr[i]=Integer.parseInt(st.nextToken());
		}//입력종료


		int mid;
		while(start+1<end){
			mid=(start+end)/2;
			if(checkBlueRay(mid,arr)<=m){
				end=mid;
			}else{
				start=mid;
			}
		}
		System.out.println(end);

	}

	private static int checkBlueRay(int mid,int[] lect) {

		int count=0;
		int sum=0;
		for(int i=0;i<lect.length;i++){
			if(lect[i]>mid)
				return 1_000_000_000;
			sum+=lect[i];
			if(sum>mid){
				count++;
				sum=0;
				i--;
			}else if(sum==mid){
				sum=0;
				count++;
			}
		}
		if(sum<mid&&sum!=0)
			count++;
		return count;
	}
}
