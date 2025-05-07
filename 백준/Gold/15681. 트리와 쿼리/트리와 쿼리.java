
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static List<Integer>[] li;
	static List<Node> tree;
	static int[] size;
	static class Node{
		int num;
		int parent;
		List<Integer> child;

		public Node(int num, int parent, List<Integer> child) {
			this.num = num;
			this.parent = parent;
			this.child = child;
		}
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int r=Integer.parseInt(st.nextToken());
		int q=Integer.parseInt(st.nextToken());

		li=new ArrayList[n+1];
		tree=new ArrayList<>();
		size=new int[n+1];

		for(int i=0;i<=n;i++){
			li[i]=new ArrayList<>();
			tree.add(new Node(i,-1,new ArrayList<>()));
		}


		for(int i=1;i<n;i++){
			st=new StringTokenizer(br.readLine());

			int s=Integer.parseInt(st.nextToken());
			int e=Integer.parseInt(st.nextToken());
			li[s].add(e);
			li[e].add(s);
		}
		makeTree(r,-1);
		countSubtreeNodes(r);
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<q;i++){
			sb.append(size[Integer.parseInt(br.readLine())]).append('\n');
		}
		System.out.println(sb.toString());
	}
	private static void makeTree(int cur,int parent){
		for(int i:li[cur]){
			if(i!=parent) {
				tree.get(cur).child.add(i);
				tree.get(i).parent = cur;
				makeTree(i, cur);
			}
		}
	}
	private static void countSubtreeNodes(int cur){
		size[cur]=1;
		for(int i:tree.get(cur).child){
			countSubtreeNodes(i);
			size[cur]+=size[i];
		}
	}

}
