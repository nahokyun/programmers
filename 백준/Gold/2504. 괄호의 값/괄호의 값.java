
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.awt.Point;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		String s=br.readLine();

		Stack<Character> st=new Stack<>();
		int mul=1;
		int result=0;
		for(int i=0;i<s.length();i++){
			char cur=s.charAt(i);
			switch (cur) {
				case '(':
					st.add(cur);
					mul*=2;
					break;
				case '[':
					st.add(cur);
					mul*=3;
					break;
				case ')':
					if(st.isEmpty()||st.peek()!='('){
						System.out.println(0);
						return;
					}
					if(s.charAt(i-1)=='(')
						result += mul;
					st.pop();
					mul /= 2;
					break;
				case ']':
					if(st.isEmpty()||st.peek()!='['){
						System.out.println(0);
						return;
					}
					if(s.charAt(i-1)=='[')
						result += mul;
					st.pop();
					mul /= 3;
					break;
			}

		}

		System.out.println(!st.isEmpty()?0:result);
	}
}
