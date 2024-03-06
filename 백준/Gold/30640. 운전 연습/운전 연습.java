import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
	static class Point{
		long x;
		long y;

		public Point(long x, long y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int n=Integer.parseInt(br.readLine());

		Point[] elect=new Point[n+1];
		long[] fuelDiff=new long[n+1];
		long[] sum=new long[n+1];

		for(int i=0;i<n+1;i++){
			StringTokenizer st=new StringTokenizer(br.readLine());
			elect[i]=new Point(Long.parseLong(st.nextToken()),Long.parseLong(st.nextToken()));
		}
		fuelDiff[0]=elect[0].x;
		sum[0]=elect[0].y;
		for(int i=1;i<n+1;i++){
			sum[i]=sum[i-1]+elect[i].y;
			fuelDiff[i]=sum[i-1]-elect[i].x;
		}


		int startIdx=0;
		boolean flag=true;
		for(int i=1;i<n+1;i++){
			if(fuelDiff[i]<0){
				flag=false;
			}
			if(fuelDiff[i-1]==0){
				startIdx=i-1;
			}

			if(!flag){
				sb.append(-1).append(' ').append(-1).append('\n');
			}else{
				sb.append(startIdx).append(' ').append(fuelDiff[i]).append('\n');
			}


		}

		System.out.println(sb);
	}
}
