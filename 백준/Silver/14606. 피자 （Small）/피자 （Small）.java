import java.util.Scanner;

public class Main {
    public static int sum=0;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        dfs(n);
        System.out.println(sum);
    }

    private static void dfs(int num){
        if(num==1)
            return;
        if(num%2==0){
            sum+=num*num/4;
            dfs(num/2);
            dfs(num/2);
        }else{
            sum+=((num-1)*(num+1)/4);
            dfs((num-1)/2);
            dfs((num+1)/2);
        }
    }
}
