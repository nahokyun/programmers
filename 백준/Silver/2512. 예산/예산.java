
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
		int budget=Integer.parseInt(br.readLine());

		int start=0;
		int end=budget;

		while(start+1<end){
			int mid=(start+end)>>1;
			if(checkBudget(mid,arr,budget)){
				start=mid;
			}else{
				end=mid;
			}
		}
		int result=0;
		for(int i=0;i<n;i++){
			result=Math.max(result,arr[i]);
		}
		result=Math.min(result,start);

		System.out.println(result);





	}

	private static boolean checkBudget(int mid, int[] arr, int budget) {
		int count=0;
		for(int cur:arr){
			if(cur<=mid){
				count+=cur;
			}else{
				count+=mid;
			}
		}
		return count<=budget;//상한선 반영했을때 예산내에 충족

	}
}
