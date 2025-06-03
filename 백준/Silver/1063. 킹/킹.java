
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	//R L B T RT LT RB LB
	static int[] dx={1,-1,0,0,1,-1,1,-1};
	static int[] dy={0,0,-1,1,1,1,-1,-1};
	static char[] ds={'A','B','C','D','E','F','G','H'};
	static int[][] map=new int[8][8];
	static Point king;
	static Point stone;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st=new StringTokenizer(br.readLine());

		String startK= st.nextToken();
		String startS= st.nextToken();
		int n=Integer.parseInt(st.nextToken());

		Map<String,Integer> dir=new HashMap<>();
		dir.put("R",0);
		dir.put("L",1);
		dir.put("B",2);
		dir.put("T",3);
		dir.put("RT",4);
		dir.put("LT",5);
		dir.put("RB",6);
		dir.put("LB",7);

		king=new Point(startK.charAt(0)-'A',startK.charAt(1)-'1');
		stone=new Point(startS.charAt(0)-'A',startS.charAt(1)-'1');


		for(int i=0;i<n;i++){
			int idx=dir.get(br.readLine());

			move(idx);

		}
		StringBuilder sb=new StringBuilder();
		sb.append(ds[king.x]).append(king.y+1).append('\n');
		sb.append(ds[stone.x]).append(stone.y+1);
		System.out.println(sb);

	}
	static void move(int idx){
		if(king.x+dx[idx]>=0&&king.x+dx[idx]<8&&king.y+dy[idx]>=0&&king.y+dy[idx]<8){
			if(king.x+dx[idx]==stone.x&&king.y+dy[idx]==stone.y){//king이 움직였을때 겹치는 경우
				if(stone.x+dx[idx]>=0&&stone.x+dx[idx]<8&&stone.y+dy[idx]>=0&&stone.y+dy[idx]<8){
					stone=new Point(stone.x+dx[idx],stone.y+dy[idx]);
					king=new Point(king.x+dx[idx],king.y+dy[idx]);
				}
			}
			else{
				king=new Point(king.x+dx[idx],king.y+dy[idx]);
			}
		}
	}
}
