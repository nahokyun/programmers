
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		String input=br.readLine();

		int[] al=new int[26];

		for(int i=0;i<input.length();i++){
			al[input.charAt(i)-'A']++;
		}
		int count=0;
		for(int i=0;i<26;i++){
			if(al[i]%2==1){
				count++;
			}
		}
		StringBuilder sb=new StringBuilder();
		if(count>1){
			System.out.println("I'm Sorry Hansoo");
		}else{
			int idx=-1;
			for(int i=0;i<26;i++){
				if(al[i]%2==1){
					idx=i;
				}
				for(int j=0;j<al[i]/2;j++){
					sb.append((char)('A'+i));
				}

			}
			if(idx!=-1)
				sb.append((char)('A'+idx));
			for(int i=25;i>=0;i--){
				for(int j=0;j<al[i]/2;j++){
					sb.append((char)('A'+i));
				}

			}
			System.out.println(sb);
		}

	}
}
