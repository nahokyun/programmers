
import java.io.*;
import java.util.*;

public class Main {
	private static int result=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());

		int n=Integer.parseInt(st.nextToken());
		int s=Integer.parseInt(st.nextToken());

		int[] arr=new int[n];

		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++){
			arr[i]=Integer.parseInt(st.nextToken());
		}
		//입력종료

		track(arr,s,0,0,0);

		System.out.println(result);


	}
	private static void track(int[] arr, int goal, int sum, int idx,int count){
		if(idx==arr.length){
			if(goal==sum&&count!=0)
				result++;
			return;
		}else{

			track(arr, goal, sum + arr[idx], idx + 1,count+1);
			track(arr, goal, sum, idx + 1,count);
		}
	}
}
