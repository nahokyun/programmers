import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());

		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());

		int[] nodeCount=new int[N+1];
		Node[] nodes=new Node[N+1];

		for(int i=1;i<=N;i++){
			nodes[i]=new Node(i,null);
		}

		for(int i=0;i<M;i++){
			st=new StringTokenizer(br.readLine());
			int first=Integer.parseInt(st.nextToken());
			int second=Integer.parseInt(st.nextToken());

			nodeCount[second]++;
			nodes[first].next=new Node(second,nodes[first].next);
		}//입력 종료

		PriorityQueue<Integer> q=new PriorityQueue<>();
		for(int i=1;i<=N;i++){
			if(nodeCount[i]==0){
				q.add(i);
			}
		}//처음으로 넣을 노드 찾아내서 add
		List<Integer> result=new ArrayList<>();

		while(!q.isEmpty()){
			int curNode=q.poll();
			result.add(curNode);

			for(Node cur=nodes[curNode].next;cur!=null;cur=cur.next){
				nodeCount[cur.num]--;
				if(nodeCount[cur.num]==0){
					q.add(cur.num);
				}
			}
		}//향하는 노드가 0개인것을 다시 넣어줌

		StringBuilder sb=new StringBuilder();
		for(int i=0;i<N;i++){
			sb.append(result.get(i)).append(' ');
		}

		System.out.println(sb);
	}//end of main

	static class Node{
		int num;
		Node next;

		public Node(int num, Node next) {
			this.num = num;
			this.next = next;
		}
	}
}
