import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class entry_1010567 {
    public static void main(String args[] ) throws Exception {
        FastScanner scanner =new FastScanner();
        long n =scanner.nextLong();
        long entry_1010567 =0;
        for(int t=0;t<n;t++){
            long x = scanner.nextLong();
            long y = scanner.nextLong();
            if(x>y){
                if(x%2 == 0){
                  entry_1010567 = (x*x)-(y-1);
                }
                else{
                entry_1010567= (((x-1)*(x-1))+1)+(y-1);
                }
            }
            else{
                if(y%2 == 1){
                    entry_1010567 = (y*y)-(x-1);
                }
                else{
                    entry_1010567= (((y-1)*(y-1))+1)+(x-1);
                }
            }
            if (t<n-1) {
                System.out.println(entry_1010567);
            } else {
                System.out.print(entry_1010567);
            }
        }
    }
    static  class FastScanner {
        StringTokenizer tok = new StringTokenizer("");
        BufferedReader in;

        FastScanner() {
            in = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (!tok.hasMoreElements())
                tok = new StringTokenizer(in.readLine());
            return tok.nextToken();
        }
        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
        long nextLong() throws IOException {
            return Long.parseLong(next());
        }
    }
}