
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s=br.readLine();

		int[] sub = new int[s.length()];
		int max = 0;
		for (int k = 0; k < s.length(); k++) {
			String tmp=s.substring(k,s.length());
//			System.out.println(tmp);
			char[] pattern = tmp.toCharArray();
			
			for (int i = 1, j = 0; i < pattern.length; i++) {
				while (j > 0 && pattern[i] != pattern[j]) {
					j = sub[j - 1];
				}
				if (pattern[i] == pattern[j]) {
					sub[i] = ++j;
				} else {
					sub[i] = 0;
				}
			}
			
			for (int i = 0; i < s.length(); i++) {
				max = Math.max(max, sub[i]);
			}
			
			
//			for(int i=0;i<s.length();i++) {
//				System.out.println(Arrays.toString(sub));
//			}
			
		}
		

		
		
		System.out.println(max);

	}
}