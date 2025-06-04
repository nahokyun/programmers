
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		int n=Integer.parseInt(br.readLine());

		int[][] map=new int[1001][1001];
		int[] arr=new int[1001];

		for(int i=0;i<n;i++){
			StringTokenizer st=new StringTokenizer(br.readLine());

			int idx=Integer.parseInt(st.nextToken());
			int h=Integer.parseInt(st.nextToken());
			arr[idx]=h;
		}

		Stack<Integer> stack=new Stack<>();
		int max=0;
		for(int i=0;i<1001;i++){
			if(arr[i]>max){
				max=arr[i];
			}
			for(int j=0;j<max;j++){
				map[i][j]=1;
			}
		}
		int revMax=0;
		for(int i=1000;i>=0;i--){
			if(arr[i]>revMax){
				revMax=arr[i];
			}
			for(int j=0;j<revMax;j++){
				map[i][j]+=1;
			}
		}

		int count=0;
		for(int i=0;i<1001;i++){
			for(int j=0;j<1001;j++){
				if(map[i][j]==2)
					count++;
			}
		}

		System.out.println(count);


	}
}
