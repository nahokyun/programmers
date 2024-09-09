
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	private static List<List<Node>> nodes;
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

		nodes=new ArrayList<>();
		for(int i=0;i<=n;i++){
			nodes.add(new ArrayList<>());
		}

		for(int i=0;i<m;i++){
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());

			nodes.get(a).add(new Node(i,b));
			nodes.get(b).add(new Node(i,a));
		}
		dijk();

		System.out.println(distance[n]);
	}
	private static void dijk(){
		PriorityQueue<Node> pq=new PriorityQueue<>();
		pq.add(new Node(0,1));

		while(!pq.isEmpty()){
			Node curNode=pq.poll();
			if(curNode.time>distance[curNode.num])
				continue;
			int curNum=curNode.num;

			for(Node next:nodes.get(curNum)){
				int nextNum=next.num;
				long nextTime;
				if(curNode.time<=next.time){
					nextTime=next.time+1;
				}else{
					nextTime= ((long)Math.ceil(((double)curNode.time-next.time)/m))*m+next.time+1;
				}
				if(nextTime<distance[nextNum]){
					distance[nextNum]=nextTime;
					pq.add(new Node(nextTime,nextNum));
				}
			}


		}

	}





	static class Node implements Comparable<Node>{
		long time;
		int num;

		public Node(long time, int num) {
			this.time = time;
			this.num = num;
		}


		@Override
		public int compareTo(Node o) {
			return Long.compare(this.time,o.time);
		}
	}
}
