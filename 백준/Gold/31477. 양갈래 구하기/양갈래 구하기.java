import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static class Node{
		Node next;
		int edge;
		int num;

		public Node(Node next, int edge,int num) {
			this.next = next;
			this.edge = edge;
			this.num=num;
		}
	}
	static Node[] graph;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		int n=Integer.parseInt(br.readLine());

		graph = new Node[n+1];
		visited=new boolean[n+1];
		for(int i=1;i<=n;i++){
			graph[i]=new Node(null,0,i);
		}

		for(int i=0;i<n-1;i++){
			StringTokenizer st=new StringTokenizer(br.readLine());
			int first=Integer.parseInt(st.nextToken());
			int second=Integer.parseInt(st.nextToken());
			int edge=Integer.parseInt(st.nextToken());
			graph[first].next=new Node(graph[first].next,edge,second);
			graph[second].next=new Node(graph[second].next,edge,first);

		}//입력 종료

		visited[1]=true;
		System.out.println(dfs(1));
	}

	private static int dfs(int curNum) {
		int sum=0;
		for(Node cur=graph[curNum].next;cur!=null;cur=cur.next){
			if(cur.num==curNum)
				continue;
			if(!visited[cur.num]){
				visited[cur.num]=true;
				sum+=Math.min(dfs(cur.num),cur.edge);
			}
		}

		return sum==0?1000000000:sum;
	}
}
