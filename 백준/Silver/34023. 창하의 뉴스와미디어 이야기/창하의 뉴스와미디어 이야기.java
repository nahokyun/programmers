
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Word implements Comparable<Word>{
		int difficulty;
		String text;

		public Word(int difficulty, String text) {
			this.difficulty = difficulty;
			this.text = text;
		}

		@Override
		public int compareTo(Word o) {
			return o.difficulty-this.difficulty;
		}
	}
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		int n=Integer.parseInt(br.readLine());

		PriorityQueue<Word> pq=new PriorityQueue<>();
		for(int i=0;i<n;i++){
			StringTokenizer st=new StringTokenizer(br.readLine());

			String cur= st.nextToken();
			int x=Integer.parseInt(st.nextToken());

			pq.add(new Word(x,cur));

		}

		String[][] words=new String[4][n/4];

		for(int j=0;j<n/4;j++) {
			for (int i = 0; i < 4; i++) {
				words[i][j]=pq.poll().text;
			}
		}
		for(int i=0;i<4;i++){
			Arrays.sort(words[i]);
		}
		StringBuilder sb=new StringBuilder();

		for(int i=0;i<4;i++){
			sb.append(i+1).append(' ');
			for(int j=0;j<n/4;j++){
				sb.append(words[i][j]).append(' ');
			}
			sb.append('\n');
		}

		System.out.println(sb);

	}
}
