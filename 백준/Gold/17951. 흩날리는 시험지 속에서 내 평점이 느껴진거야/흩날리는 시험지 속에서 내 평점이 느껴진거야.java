import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static int[] arr;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        int r=0;
        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            r+=arr[i];
        }

        int l = 0;
        r +=1;
        while (l + 1 != r) {
            int m = (l + r) / 2;
            if (check(m)) {
                l = m;
            } else {
                r = m;
            }
        }
        System.out.println(l);
    }
    static boolean check(int val) {
        int groupCnt = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum >= val) {
                groupCnt++;
                sum = 0;
            }
        }
        return groupCnt >= k;
    }
}