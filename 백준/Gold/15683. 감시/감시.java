import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int[] dx={0,0,-1,1};
	static int[] dy={1,-1,0,0};
	static List<Point> list;
	static int m;
	static int n;
	static int min=1_000_000_000;
	static int cc=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		int[][] map=new int[n][m];

		list = new ArrayList<>();

		for(int i=0;i<n;i++){
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++){
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]!=0&&map[i][j]!=6){
					list.add(new Point(j,i));
				}
			}
		}//입력 종료

		find(0,map);

		System.out.println(min);
	}

	private static void find(int cur,int[][] map) {
		if(cur==list.size()){
			int count=0;
			for(int i=0;i<n;i++){
				for(int j=0;j<m;j++){
					if(map[i][j]==0){
						count++;
					}
				}
			}
			min=Math.min(min,count);
			return;
		}
		int[][] undo=new int[n][m];
		for(int i=0;i<n;i++){
			undo[i]= Arrays.copyOf(map[i],m);
		}

		int curCCTV=map[list.get(cur).y][list.get(cur).x];
		switch(curCCTV){
			case 1:
				for(int i=0;i<4;i++){
					find(cur+1,change(map,dx[i],dy[i],list.get(cur)));
					for(int j=0;j<n;j++){
						map[j]= Arrays.copyOf(undo[j],m);
					}
				}
				break;
			case 2:
				for(int i=0;i<2;i++){
					find(cur+1,cctv2on(i,map,list.get(cur)));
					for(int j=0;j<n;j++){
						map[j]= Arrays.copyOf(undo[j],m);
					}
				}
				break;
			case 3:
				for(int i=0;i<4;i++){
					find(cur+1,cctv3on(i,map,list.get(cur)));
					for(int j=0;j<n;j++){
						map[j]= Arrays.copyOf(undo[j],m);
					}
				}

				break;
			case 4:
				for(int i=0;i<4;i++){
					find(cur+1,cctv4on(i,map,list.get(cur)));
					for(int j=0;j<n;j++){
						map[j]= Arrays.copyOf(undo[j],m);
					}
				}
				break;
			case 5:
				find(cur+1,change(change(change(change(map,0,1, list.get(cur)),0,-1,list.get(cur)),1,0,list.get(cur)),-1,0,list.get(cur)));
				break;
			default:
				break;
		}

	}

	private static int[][] cctv4on(int idx, int[][] map, Point cur) {
		int dx1;
		int dx2;
		int dy1;
		int dy2;
		int dx3;
		int dy3;

		if(idx==0){//ㅏ
			dx1=0;
			dy1=-1;
			dx2=1;
			dy2=0;
			dx3=0;
			dy3=1;
		}else if(idx==1){//ㅗ
			dx1=1;
			dy1=0;
			dx2=-1;
			dy2=0;
			dx3=0;
			dy3=-1;
		}else if(idx==2){//ㅓ
			dx1=0;
			dy1=1;
			dx2=-1;
			dy2=0;
			dx3=0;
			dy3=-1;
		}else {//ㅜ
			dx1=-1;
			dy1=0;
			dx2=0;
			dy2=1;
			dx3=1;
			dy3=0;
		}
		return change(change(change(map,dx1,dy1,cur),dx2,dy2,cur),dx3,dy3,cur);
	}

	private static int[][] cctv3on(int idx, int[][] map, Point cur) {
		int dx1;
		int dx2;
		int dy1;
		int dy2;

		if(idx==0){
			dx1=0;
			dx2=1;
			dy1=-1;
			dy2=0;
		}else if(idx==1){
			dx1=1;
			dy1=0;
			dx2=0;
			dy2=1;
		}else if(idx==2){
			dx1=0;
			dy1=1;
			dx2=-1;
			dy2=0;
		}else {
			dx1=-1;
			dy1=0;
			dx2=0;
			dy2=-1;
		}
		return change(change(map,dx1,dy1,cur),dx2,dy2,cur);
	}

	private static int[][] cctv2on(int idx, int[][] map, Point cur) {
		int dx1;
		int dx2;
		int dy1;
		int dy2;
		if(idx==0){//상하
			dx1 = 0;
			dx2 = 0;
			dy1 = 1;
			dy2 = -1;
		}else{//좌우
			dx1=-1;
			dx2=1;
			dy1=0;
			dy2=0;
		}
		return change(change(map,dx1,dy1,cur),dx2,dy2,cur);

	}
	private static int[][] change(int[][] map, int dx, int dy, Point cur){
		int i=0;
		int curX=cur.x;
		int curY=cur.y;
		while(check(curX,curY)){
			if(map[curY][curX]==0)
				map[curY][curX]=10;
			if(map[curY][curX]==6){
				return map;
			}
			i++;
			curX=cur.x+dx*i;
			curY=cur.y+dy*i;

		}
		return map;
	}



	private static boolean check(int j, int i) {
		return i>=0&&i<n&&j<m&&j>=0;
	}
}
