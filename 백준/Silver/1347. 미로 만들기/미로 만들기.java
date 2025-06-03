
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class Main {


	//우, 하, 좌, 상
	static int[][] dir={{1,0},{0,1},{-1,0},{0,-1}};
	static int curDir=1;
	static Point curPos=new Point(50,50);
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());

		String input=br.readLine();
		List<Point> li=new ArrayList<>();
		li.add(curPos);
		char[][] map=new char[101][101];

		for(int i=0;i<101;i++){
			Arrays.fill(map[i],'#');
		}
		map[curPos.y][curPos.x]='.';
		for(int i=0;i<n;i++){
			if(input.charAt(i)=='L'){
				if(curDir>0){
					curDir-=1;
				}else{
					curDir=3;
				}
			}else if(input.charAt(i)=='R'){
				if(curDir<3){
					curDir+=1;
				}else{
					curDir=0;
				}
			}else{
				int cmpX=curPos.x+dir[curDir][0];
				int cmpY=curPos.y+dir[curDir][1];
				li.add(new Point(cmpX,cmpY));

				curPos=new Point(cmpX,cmpY);
				map[curPos.y][curPos.x]='.';
			}
		}//입력종료


		int minX=100000;
		int minY=100000;
		int maxX=-100000;
		int maxY=-100000;
		for(int i=0;i<li.size();i++){
			minX=Math.min(minX,li.get(i).x);
			minY=Math.min(minY,li.get(i).y);
			maxX=Math.max(maxX,li.get(i).x);
			maxY=Math.max(maxY,li.get(i).y);
		}






		StringBuilder sb=new StringBuilder();
		for(int i=minY;i<=maxY;i++){
			for(int j=minX;j<=maxX;j++){
				sb.append(map[i][j]);
			}
			sb.append('\n');
		}

		System.out.println(sb);

	}
}
