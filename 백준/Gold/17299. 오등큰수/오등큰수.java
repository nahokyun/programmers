
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n= Integer.parseInt(br.readLine());

		int[] count=new int[1_000_001];
		int[] arr=new int[n];
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++){
			arr[i]=Integer.parseInt(st.nextToken());
			count[arr[i]]++;
		}

		int[] result=new int[n];
		Stack<Integer> s=new Stack<>();
		for(int i=n-1;i>=0;i--){
			int cur=arr[i];

			if(s.isEmpty()){
				result[i]=-1;
				s.add(cur);
			}else{
				while(!s.isEmpty()){
					int cmp=s.peek();
					if(count[cur]<count[cmp]){
						s.add(cur);
						result[i]=cmp;
						break;
					}else{
						s.pop();
					}
				}
				if(s.isEmpty()){
					result[i]=-1;
					s.add(cur);
				}

			}
		}

		StringBuilder sb=new StringBuilder();
		for(int i=0;i<n;i++){
			sb.append(result[i]).append(' ');
		}

		System.out.println(sb);

	}
}
