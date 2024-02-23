import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st=new StringTokenizer(br.readLine());

		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int[] hi=new int[N];
		int[] arc=new int[M];
		int[] scoreHi=new int[100001];
		int[] scoreArc=new int[100001];

		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++){
			hi[i]=Integer.parseInt(st.nextToken());
			scoreHi[hi[i]]++;
		}
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++){
			arc[i]=Integer.parseInt(st.nextToken());
			scoreArc[arc[i]]++;
		}
		//입력 종료

		long draw=0;
		for(int i=1;i<=100000;i++){
			draw+= (long)scoreHi[i] *scoreArc[i];
		}
		//비김 체크

		Arrays.sort(hi);
		Arrays.sort(arc);

		int hiIdx=0;
		int arcIdx=0;

		long arcWin=0;
		while(hiIdx<N&&arcIdx<M){
			if(hi[hiIdx]>=arc[arcIdx]){
				arcIdx++;
			}else{
				arcWin+=M-arcIdx;
				hiIdx++;
			}
		}

		System.out.println((long)M *N-arcWin-draw+" "+arcWin+" "+draw);



	}
}
