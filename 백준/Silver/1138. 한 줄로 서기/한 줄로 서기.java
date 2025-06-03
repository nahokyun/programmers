
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
		int[] result=new int[n];
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++){
			arr[i]=Integer.parseInt(st.nextToken());
		}

		Arrays.fill(result, 999);
		for(int i=0;i<n;i++){
			int idx=0;
			int count=0;
			while(count!=arr[i]){
				if(result[idx]>i+1){
					count++;
				}
				idx++;
			}
			while(result[idx]!=999){
				idx++;
			}
			result[idx]=i+1;
		}




		StringBuilder sb=new StringBuilder();
		for(int i=0;i<n;i++){
			sb.append(result[i]).append(' ');
		}

		System.out.println(sb);



	}
}
