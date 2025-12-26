import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    static int n;
    static int result=0;
    static class Node{
        List<Integer> children;
        int parent;
        int num;
        public Node(List<Integer> children, int parent, int num){
            this.children=children;
            this.parent=parent;
            this.num=num;
        } 
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        Node[] arr=new Node[n+1];
        for(int i=0;i<n;i++){
            arr[i]=new Node(new ArrayList<Integer>(), -1, i);
        }
        
        int root=-1;
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            int parent=Integer.parseInt(st.nextToken());
            arr[i].parent=parent;
            if(parent!=-1)
                arr[parent].children.add(i);
            else
                root=i;
        }
        
        int erase=Integer.parseInt(br.readLine());
        
        //부모의 자식list에서 나 지우고
        if(arr[erase].parent!=-1){
            arr[arr[erase].parent].children.remove(Integer.valueOf(erase));
            findLeaf(root,arr);
        }
        //탐색
        System.out.println(result);
    }
    
    static public void findLeaf(int start, Node[] arr){
        if(arr[start].children.size()!=0){
            for(int i:arr[start].children){
                findLeaf(i,arr);
            }
        } else result+=1;
    }
}