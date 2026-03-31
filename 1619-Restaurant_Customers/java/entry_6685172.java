import java.io.*;
import java.util.*;

public class entry_6685172 {
//     Create an oject and use.
//     Standard nextInt() & nextLine()
//     When taking a string input after an integer, need not have an empty scn.nextLine() ie. nextInt() would
//     be able to read the line break character as well.
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        int[] readintarray(int n) {
            int res[] = new int[n];
            for (int i = 0; i < n; i++) res[i] = nextInt();
            return res;
        }

        long[] readlongarray(int n) {
            long res[] = new long[n];
            for (int i = 0; i < n; i++) res[i] = nextLong();
            return res;
        }
    }

    public static void main(String[] args) throws IOException {
        FastReader scn = new FastReader();
        int n = scn.nextInt();
        int[] arrival = new int[n];
        int[] departure = new int[n];
        for(int i=0;i<n;i++){
            arrival[i] = scn.nextInt();
            departure[i] = scn.nextInt();
        }
        shuffleArray(arrival);
        shuffleArray(departure);
        System.out.println(ans(n,arrival,departure));
    }
    public static int ans(int n, int[] arrival, int[] departure){
        Arrays.sort(arrival);
        Arrays.sort(departure);
        int p1 = 0;
        int p2 = 0;
        int maxcount = -1;
        while(true){
            if(p1==n){
                maxcount = Math.max(maxcount,p1-p2);
                break;
            }
            if(arrival[p1]<departure[p2]){
                p1++;
            }else{
                maxcount = Math.max(maxcount,p1-p2);
                p2++;
            }
        }
        return maxcount;
    }

    static void shuffleArray(int[] arr){
        int n = arr.length;
        Random rnd = new Random();
        for(int i=0; i<n; ++i){
            int tmp = arr[i];
            int randomPos = i + rnd.nextInt(n-i);
            arr[i] = arr[randomPos];
            arr[randomPos] = tmp;
        }
    }


}