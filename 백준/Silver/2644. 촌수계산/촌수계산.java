
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	private static class Node{
		int num;
		List<Integer> children;
		int parentNum;

		public Node(int num, List<Integer> children, int parentNum) {
			this.num = num;
			this.children = children;
			this.parentNum = parentNum;
		}
	}
	static Node[] relation;
	static int result=100000000;
	static boolean[] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		int findX=Integer.parseInt(st.nextToken());
		int findY=Integer.parseInt(st.nextToken());

		int m=Integer.parseInt(br.readLine());
		relation=new Node[n+1];
		check=new boolean[n+1];

		for(int i=1;i<=n;i++){
			relation[i]=new Node(i,new ArrayList<>(),0);
		}

		for(int i=0;i<m;i++){
			st=new StringTokenizer(br.readLine());

			int parent=Integer.parseInt(st.nextToken());
			int child=Integer.parseInt(st.nextToken());

			relation[parent].children.add(child);
			relation[child].parentNum=parent;


		}

		find(findX,findY,0);

		System.out.println(result==100000000?-1:result);


	}

	private static void find(int findX, int findY,int count) {
		if(findX==0)
			return;

		check[findX]=true;
		if(relation[findX].parentNum==findY||relation[findX].children.contains(findY)){
			result=Math.min(count+1,result);
			return;
		}


		//부모방향으로 탐색
		if(!check[relation[findX].parentNum])
			find(relation[findX].parentNum,findY,count+1);


		//자식방향으로 탐색

		for(int i:relation[findX].children){
			if(!check[i])
				find(i,findY,count+1);
		}


	}
}
