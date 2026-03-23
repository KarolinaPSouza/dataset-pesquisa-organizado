import java.io.*;
import java.util.StringTokenizer;
import java.util.*;
import java.lang.*;
// entry_11300492 Class

public class entry_11300492 {

//main function
 public static void main(String[] args) throws IOException
    {

       try {
            FastReader s=new FastReader();
            FastWriter out = new FastWriter();
            //write your code here
            int t=s.nextInt();
            while(t-->0){
              long x=s.nextLong();
              long y=s.nextLong();
              long ans=0;
              if(x>=y){
                if(x%2==0){
                   ans=x*x-y+1;
                }else{
                  ans=(x-1)*(x-1)+y;
                }
              }else{
                if(y%2==0){
                  ans=(y-1)*(y-1)+x;
                }else{
                  ans=y*y-x+1;
                }
              }
              out.println(ans);
            }
            //code ends here

        out.close();
        } catch (Exception e) {
            return;
        }
    }

//fast input
public static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br=new BufferedReader(new InputStreamReader(System.in));

            if (System.getProperty(
                    "ONLINE_JUDGE")
                == null) {
                try {
                   br = new BufferedReader(
                        new InputStreamReader(
                            new FileInputStream(
                                "input.txt")));
                }
                catch (Exception e) {
                }
            }
        }
        String next(){
            while(st==null || !st.hasMoreTokens()){
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt(){
            return Integer.parseInt(next());
        }
        long nextLong(){
            return Long.parseLong(next());
        }
        double nextDouble(){
            return Double.parseDouble(next());
        }
        String nextLine(){
            String str="";
            try {
                str=br.readLine().trim();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return str;
        }
}
//fast output
     public static class FastWriter {
         BufferedWriter bwr;
        public FastWriter() {
            bwr = new BufferedWriter(new OutputStreamWriter(System.out));

            if (System.getProperty(
                    "ONLINE_JUDGE")
                == null) {
                try {
                bwr = new BufferedWriter(
                        new OutputStreamWriter(
                            new FileOutputStream(
                                "output.txt")));
                }
                catch (Exception e) {
                }
            }
        }
        public void print(Object object) throws IOException {
            bwr.append("" + object);
        }
        public void println(Object object) throws IOException {
            print(object);
            bwr.append("\n");
        }

        public void close() throws IOException {
            bwr.close();
        }
    }
    }