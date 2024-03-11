import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
		Arrays.sort(arr);
		int range=n/2;
		int sum=0;
		if(n%2==0){
			range=n/2;
		}else{
			sum+=arr[n/2];
			range=n/2+1;
		}
		for(int i=n-1;i>=range;i--){
			sum+=2*arr[i];
		}

		System.out.println(sum);
	}
}
