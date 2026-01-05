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
        
        public void insert(String in){
            Node node=rootNode;
            
            for(int i=0;i<in.length();i++){
                node.child.putIfAbsent(in.charAt(i),new Node());
                node=node.child.get(in.charAt(i));
            }
            node.isEnd=true;
        }
        
        public int find(String in){
            int count=1;
            Node node=this.rootNode.child.get(in.charAt(0));
            
            for(int i=1;i<in.length();i++){
                if(node.child.size()>1||node.isEnd){
                    count++;
                }
                node=node.child.get(in.charAt(i));
            }
            
            return count;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String input;
        StringBuilder sb=new StringBuilder();
        
        while((input=br.readLine())!=null){
            int n=Integer.parseInt(input);
            String[] arr=new String[n];
            Trie trie=new Trie();
            double sum=0;
            
            for(int i=0;i<n;i++){
                arr[i]=br.readLine();
                trie.insert(arr[i]);
            }
            
            for(int i=0;i<n;i++){
                sum+=trie.find(arr[i]);
            }
            sb.append(String.format("%.2f",sum/n)).append('\n');
        }
        System.out.println(sb);
        
    }
}