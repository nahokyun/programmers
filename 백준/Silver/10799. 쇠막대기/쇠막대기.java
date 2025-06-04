
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		String s=br.readLine();

		Stack<Character> stack = new Stack<>();
		int count=0;
		int result=0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)=='('){
				stack.add('(');
				count++;
			}else{
				stack.pop();
				count--;
				if(s.charAt(i-1)=='('){
					result+=count;
				}else{
					result+=1;
				}
			}
		}
		System.out.println(result);

	}
}
