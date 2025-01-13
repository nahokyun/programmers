
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());

		int v=Integer.parseInt(st.nextToken());
		int e=Integer.parseInt(st.nextToken());
		int[][] map=new int[v+1][v+1];

		for(int i=0;i<=v;i++){
			for(int j=0;j<=v;j++){
				map[i][j]=1_000_000_000;
				if(i==j)
					map[i][j]=0;
			}
		}

		for(int i=0;i<e;i++){
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());

			map[a][b]=c;
		}//입력 종료


		for(int k=1;k<=v;k++){
			for(int i=1;i<=v;i++){
				for(int j=1;j<=v;j++){
					if(map[i][k]+map[k][j]<map[i][j])
						map[i][j]=map[i][k]+map[k][j];
				}
			}
		}
		int min=2_000_000_000;

		for(int i=1;i<=v;i++){
			for(int j=1;j<=v;j++){
				if(i==j)
					continue;
				min=Math.min(min,map[i][j]+map[j][i]);
			}
		}

		System.out.println(min<=1000000000?min:-1);

	}



}
