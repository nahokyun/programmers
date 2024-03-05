import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());

		long X=Integer.parseInt(st.nextToken());
		long Y=Integer.parseInt(st.nextToken());

		long Z=100L*Y/X;

		long left=1;
		long right=100_000_000_000_000L;

		while(left<right){
			long mid=(left+right)>>1;
			long cmpX=X+mid;
			long cmpY=Y+mid;
			long cmpZ=100L*cmpY/cmpX;
			if(cmpZ>Z){
				right=mid;
			}else{
				left=mid+1;
			}
		}

		if(right==100_000_000_000_000L){
			System.out.println(-1);
		}else{
			System.out.println(left);
		}

	}
}
