import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    static class Node{
        HashMap<Character,Node> child;
        boolean isEnd;
        
        public Node(){
            this.child=new HashMap<>();
            this.isEnd=false;
        }
    }
    
    static class Trie{
        Node rootNode=new Node();
        
        public boolean insert(String in){
            Node node=rootNode;
            
            for(int i=0;i<in.length();i++){
                Node next=new Node();
                node.child.putIfAbsent(in.charAt(i),next);
                node=node.child.get(in.charAt(i));
                if(i<in.length()-1&&node.isEnd){
                    return false;
                }
            }
            
            node.isEnd=true;
            return true;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int test=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();
        
        for(int t=0;t<test;t++){
            int n=Integer.parseInt(br.readLine());
            Trie trie=new Trie();
            String[] arr=new String[n];
            for(int i=0;i<n;i++){
                arr[i]=br.readLine();
            }//end of input
            Arrays.sort(arr);
            
            boolean flag=true;
            for(int i=0;i<n;i++){
                if(flag)
                    flag=trie.insert(arr[i]);
            }
            
            if(!flag){
                sb.append("NO");
            }else
                sb.append("YES");
            sb.append('\n');
            
        }
        
        System.out.println(sb);
        
    }
}
