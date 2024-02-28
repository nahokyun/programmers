import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		int n=Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		int[] arr=new int[n];
		boolean[] isGood=new boolean[n];
		int count=0;

		for(int i=0;i<n;i++){
			arr[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		for(int i=0;i<n;i++){
			int cur=arr[i];
			int left=0;
			int right=n-1;

			while(left<right){
				int mid=arr[left]+arr[right];
				if(mid>cur){
					right-=1;
				}else if(mid<cur){
					left+=1;
				}else{//합이 같을때
					if(i==left){
						left+=1;
						continue;
					}
					if(i==right){
						right-=1;
						continue;
					}
					isGood[i]=true;
					break;
				}
			}
		}
		for(int i=0;i<n;i++){
			if(isGood[i]){
				count++;
			}
		}
		System.out.println(count);

	}
}
