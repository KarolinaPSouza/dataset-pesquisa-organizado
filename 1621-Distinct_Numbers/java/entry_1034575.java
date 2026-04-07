import java.util.*;
import java.io.*;
class Solution{
    static class InputReader{
        BufferedReader reader;
        StringTokenizer tokenizer;
        public InputReader(InputStream stream){
            reader = new BufferedReader(new InputStreamReader(stream),23768);
            tokenizer=null;
        }
        String next(){
            while(tokenizer==null||!tokenizer.hasMoreTokens()){
                try{
                    tokenizer=new StringTokenizer(reader.readLine());
                }catch(IOException e){
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }
        public int nextInt(){
            return Integer.parseInt(next());
        }
        public long nextLong(){
            return Long.parseLong(next());
        }
        public double nextDouble(){
            return Double.parseDouble(next());
        }
    }
    static InputReader in=new InputReader(System.in);
    static PrintWriter out=new PrintWriter(System.out);
    public static void main(String[]args){
        int t=in.nextInt();
        HashSet<Integer>list=new HashSet<Integer>();
        while(t-->0){
            list.add(in.nextInt());
        }
        out.println(list.size());
        out.close(); 
    }
}