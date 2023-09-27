import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	private static Node[] nodes;
	static int lowCount=0;
	static int highCount=0;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int t=Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		for(int test=1;test<=t;test++) {
			int n=Integer.parseInt(br.readLine());
			int m=Integer.parseInt(br.readLine());
			
			nodes = new Node[n+1];
			for(int i=1;i<=n;i++) {
				nodes[i]=new Node(null,null,i);//big, little순
			}
			
			for(int i=0;i<m;i++) {
				StringTokenizer st=new StringTokenizer(br.readLine()," ");
				int little=Integer.parseInt(st.nextToken());
				int big=Integer.parseInt(st.nextToken());
				nodes[little].higher=new Node(nodes[little].higher,null,big);
				nodes[big].lower=new Node(null,nodes[big].lower,little);
			}
			//입력종료
			int result=0;
			visited=new boolean[n+1];
			for(int i=1;i<=n;i++) {
				Arrays.fill(visited,false);
				lowCount=0;
				highCount=0;
				//dfsLower(i);
				bfsLower(i);
				Arrays.fill(visited,false);
				//dfsHigher(i);
				bfsHigher(i);
				if(lowCount+highCount==n-1) {
					result++;
				}
			}
			sb.append("#").append(test).append(" ").append(result).append('\n');
			
			
		}//end of testcase
		
		System.out.println(sb.toString());
	}//end of main
//	
//	private static void dfsLower(int cur) {
//		for(Node next=nodes[cur].lower;next!=null;next=next.lower) {
//			if(!visited[next.num]) {
//				visited[next.num]=true;
//				lowCount++;
//				dfsLower(next.num);
//			}
//		}
//	}
//	
//	private static void dfsHigher(int cur) {
//		for(Node next=nodes[cur].higher;next!=null;next=next.higher) {
//			if(!visited[next.num]) {
//				visited[next.num]=true;
//				highCount++;
//				dfsHigher(next.num);
//			}
//		}
//	}
	private static void bfsLower(int num) {
		ArrayDeque<Integer> q=new ArrayDeque<>();
		q.add(num);
		visited[num]=true;
		
		while(!q.isEmpty()) {
			int cur=q.poll();
			
			for(Node next=nodes[cur].lower;next!=null;next=next.lower) {
				if(!visited[next.num]) {
					visited[next.num]=true;
					lowCount++;
					q.add(next.num);
				}
			}
			
		}
	}
	private static void bfsHigher(int num) {
		ArrayDeque<Integer> q=new ArrayDeque<>();
		q.add(num);
		visited[num]=true;
		
		while(!q.isEmpty()) {
			int cur=q.poll();
			
			for(Node next=nodes[cur].higher;next!=null;next=next.higher) {
				if(!visited[next.num]) {
					visited[next.num]=true;
					highCount++;
					q.add(next.num);
				}
			}
			
		}
	}
	
	
	
	
	
	static class Node{
		Node higher;
		Node lower;
		int num;
		public Node(Node big, Node little, int num) {
			this.higher = big;
			this.lower = little;
			this.num = num;
		}
		
	}

}
