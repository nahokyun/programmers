
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st=new StringTokenizer(br.readLine());

		int m=Integer.parseInt(st.nextToken());//사대의 수
		int n=Integer.parseInt(st.nextToken());//동물의 수
		int l=Integer.parseInt(st.nextToken());//사정거리

		int[] shoot=new int[m];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<m;i++){
			shoot[i]= Integer.parseInt(st.nextToken());
		}
		Arrays.sort(shoot);

		Point[] animals=new Point[n];
		for(int i=0;i<n;i++){
			st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			animals[i]=new Point(x,y);
		}
		//입력종료

		int count=0;

		for(int i=0;i<n;i++){
			int start=0;
			int end=m-1;

			while(start<=end){
				int mid=(start+end)>>1;

				if(Math.abs(animals[i].x-shoot[mid])+animals[i].y<=l){
					count++;
					break;
				}

				if(animals[i].x<shoot[mid]){
					end=mid-1;
				}else{
					start=mid+1;
				}

			}


		}


		System.out.println(count);

	}
}
