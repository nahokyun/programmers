
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());

		int n= Integer.parseInt(st.nextToken());
		int k= Integer.parseInt(st.nextToken());

		int[] arr=new int[200001];
		Arrays.fill(arr,Integer.MAX_VALUE);
		Deque<Integer> q=new LinkedList<>();
		arr[n]=0;
		q.add(n);

		if(n==k)
			System.out.println(0);
		else{
			while(!q.isEmpty()){
				int cur=q.poll();

				if(cur+1>=0&&cur+1<100001&&arr[cur+1]>arr[cur]+1){
					arr[cur+1]=arr[cur]+1;
					q.addLast(cur+1);
				}
				if(cur-1>=0&&cur-1<100001&&arr[cur-1]>arr[cur]+1){
					arr[cur-1]=arr[cur]+1;
					q.addLast(cur-1);
				}
				if(2*cur>=0&&2*cur<200001&&arr[2*cur]>arr[cur]){
					arr[2*cur]=arr[cur];
					q.addFirst(2*cur);
				}
			}
			System.out.println(arr[k]);
		}

	}
}
