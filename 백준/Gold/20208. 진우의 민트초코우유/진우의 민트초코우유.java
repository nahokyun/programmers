import static java.lang.Math.*;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int n;
	static int m;
	static int h;
	static Point home;
	static int maxMint=0;
	static Point[] mints;
	static boolean[] visited;
	static int initMintCount;

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());

		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		h=Integer.parseInt(st.nextToken());

		map=new int[n][n];
		mints=new Point[10];


		initMintCount=0;
		for(int i=0;i<n;i++){
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++){
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==1){
					home=new Point(j,i);
				}
				if(map[i][j]==2){
					mints[initMintCount++]=new Point(j,i);
				}
			}
		}
		visited=new boolean[initMintCount];
		//입력 종료


		List<Integer> li = new ArrayList<Integer>();
		moveAround(0, li);


		System.out.println(maxMint);

	}

	private static void moveAround(int curIdx,List<Integer> li) {
		if(curIdx==initMintCount){
			Point cur=home;
			int curH=m;

			for(int i=0;i<initMintCount;i++){
				int diff=abs(mints[li.get(i)].x-cur.x)+abs(mints[li.get(i)].y-cur.y);
				if(diff<=curH){
					curH-=diff;
					curH+=h;
					cur=mints[li.get(i)];
				}else{
					return;
				}
				if(curH>=abs(mints[li.get(i)].x-home.x)+abs(mints[li.get(i)].y-home.y)) {
					maxMint = max(maxMint, i+1);
				}
			}

		}else{
			for(int i=0;i<initMintCount;i++){
				if(!visited[i]){
					li.add(i);
					visited[i]=true;
					moveAround(curIdx+1,li);
					visited[i]=false;
					li.remove(curIdx);
				}
			}
		}



	}
}
