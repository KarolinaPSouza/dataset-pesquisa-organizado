import java.io.*;
import java.util.*;
public class entry_8094870 {
        static class FastReader {
        BufferedReader br;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        int nextInt() throws IOException {
            int num = 0;
            boolean isNeg = false;
            char c;

            do {
                c = (char) br.read();
            } while (!Character.isDigit(c) && c != '-');

            if (c == '-') {
                isNeg = true;
                c = (char) br.read();
            }

            do {
                num = num * 10 + c - '0';
                c = (char) br.read();
            } while (Character.isDigit(c));

            if (isNeg) {
                num = -num;
            }

            return num;
        }
        String nextLine() throws IOException {
            return br.readLine();
        }
    }
    public static void main(String[] args) throws IOException {
        FastReader scn = new FastReader();
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;++i)
        {
            int u = scn.nextInt();
            arr[i] = u;
        }
        long sum =Integer.MIN_VALUE,mx=0;
        for(int i=0;i<n;i++)
        {
            mx += arr[i];
            sum = Math.max(mx,sum);
            if(mx < 0)
            mx = 0;
        }
        System.out.println(sum);
    }
}
