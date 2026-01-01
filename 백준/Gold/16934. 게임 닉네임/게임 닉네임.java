import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    static StringBuilder sb=new StringBuilder();
    static class Node{
        Map<Character,Node> child;
        boolean isEnd;
        int count;
        public Node(){
            this.child=new HashMap<>();
            this.isEnd=false;
            this.count=1;
        }
    }
    static class Trie{
        Node rootNode;
        
        public Trie(){
            rootNode=new Node();
        }
        
        public void insert(String input){
            Node node=this.rootNode;
            boolean flag=false;
            for(int i=0;i<input.length();i++){
                if(node.child.get(input.charAt(i))!=null){
                    node=node.child.get(input.charAt(i));
                    sb.append(input.charAt(i));
                }else{
                    Node node2=new Node();
                    node=node.child.put(input.charAt(i),node2);
                    node=node2;
                    
                    if(!flag){//처음으로 다른게 나오면 추가함
                        sb.append(input.charAt(i));
                        flag=true;
                    }
                }
            }
            if(node.isEnd){
                node.count+=1;
                sb.append(node.count);
            }
            node.isEnd=true;
        }
        
        
        
    }
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        
        Trie trie=new Trie();
        for(int i=0;i<n;i++){
            trie.insert(br.readLine());
            sb.append('\n');
        }
        
        System.out.println(sb);
        
        
    }
}