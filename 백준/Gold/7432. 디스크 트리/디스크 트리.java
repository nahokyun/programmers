
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb=new StringBuilder();
	static class Node{
		HashMap<String, Node> child;
		boolean isEnd;

		public Node(){
			this.child=new HashMap<>();
			this.isEnd=false;
		}
	}

	static class Trie{
		Node rootNode=new Node();

		public void insert(String s){
			Node node=this.rootNode;

			StringTokenizer st=new StringTokenizer(s,"\\");

			while(st.hasMoreTokens()){
				String cur=st.nextToken();
				node.child.putIfAbsent(cur,new Node());
				node=node.child.get(cur);
			}
			node.isEnd=true;
		}

		public void printStructure(int s,Node node){
			List<String> li=new ArrayList<>(node.child.keySet());
			Collections.sort(li);

			for(String cur:li){
				for(int i=0;i<s;i++){
					sb.append(' ');
				}
				sb.append(cur).append('\n');
				printStructure(s+1,node.child.get(cur));
			}

		}



	}


	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());

		Trie trie=new Trie();
		for(int i=0;i<n;i++){
			String s=br.readLine();
			trie.insert(s);
		}
		trie.printStructure(0,trie.rootNode);
		System.out.println(sb);
	}
}
