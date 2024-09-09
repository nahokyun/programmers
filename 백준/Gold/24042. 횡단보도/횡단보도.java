import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	private static Node[] nodes;
	private static long[] distance;
	private static int n;
	private static int m;

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());

		n=Integer.parseInt(st.nextToken());//지역수
		m=Integer.parseInt(st.nextToken());//주기
		distance=new long[n+1];
		Arrays.fill(distance,Long.MAX_VALUE);
		distance[1]=0;

		nodes=new Node[n+1];
		for(int i=1;i<=n;i++){
			nodes[i]=new Node(null,0,i);
		}

		for(int i=0;i<m;i++){
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());

			nodes[a].next=new Node(nodes[a].next,i,b);
			nodes[b].next=new Node(nodes[b].next,i,a);
		}
		dijk();

		System.out.println(distance[n]);
	}
	private static void dijk(){
		PriorityQueue<Node> pq=new PriorityQueue<>();
		pq.add(new Node(null,0,1));

		while(!pq.isEmpty()){
			Node curNode=pq.poll();
			int curNum=curNode.num;
            if(curNode.time>distance[curNum])
                continue;
			for(Node next=nodes[curNum].next;next!=null;next=next.next){
				int nextNum=next.num;
				long nextTime;
				if(curNode.time<=next.time){
					nextTime=next.time+1;
				}else{
					nextTime= (long)((Math.ceil(((double)curNode.time-next.time)/m))*m+next.time+1);
				}
				if(nextTime<distance[nextNum]){
					distance[nextNum]=nextTime;
					pq.offer(new Node(null,nextTime,nextNum));
				}
			}


		}

	}





	static class Node implements Comparable<Node>{
		Node next;
		long time;
		int num;

		public Node(Node next, long time, int num) {
			this.next = next;
			this.time = time;
			this.num = num;
		}


		@Override
		public int compareTo(Node o) {
			return Long.compare(this.time,o.time);
		}
	}
}
