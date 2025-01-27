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
		int s=0;
		int d=n-1;
		int ability=Integer.MAX_VALUE;
		int ss=0;
		int dd=0;

		while(s!=d){
			int abs = Math.abs(arr[s] + arr[d]);
			if(abs <ability){
				ability= abs;
				ss=s;
				dd=d;
			}
			if(arr[s]+arr[d]<0){
				s++;
			}else if(arr[s]+arr[d]>0){
				d--;
			}else{
				break;
			}
		}


		System.out.println(arr[ss]+" "+arr[dd]);

	}
}
