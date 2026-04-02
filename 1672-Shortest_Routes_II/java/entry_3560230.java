import java.io.*;
import java.util.*;

public class entry_3560230 {
    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        FastScanner in = new FastScanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int q = in.nextInt();
        long[][] adjMatrix = new long[n][n];
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<n; j++) {
                if(i == j) adjMatrix[i][j] = 0;
                else adjMatrix[i][j] = Long.MAX_VALUE/2;
            }
        }
        for(int i = 0; i<m; i++) {
            int a = in.nextInt()-1;
            int b = in.nextInt()-1;
            long c = in.nextLong();
            adjMatrix[a][b] = Math.min(adjMatrix[a][b], c);
            adjMatrix[b][a] = Math.min(adjMatrix[b][a], c);
        }
        for(int k = 0; k<n; k++) {
            for(int v = 0; v<n; v++) {
                for(int w = 0; w<n; w++) {
                    if(adjMatrix[v][w] > adjMatrix[v][k] + adjMatrix[k][w])
                        adjMatrix[v][w] = adjMatrix[v][k] + adjMatrix[k][w];
                }
            }
        }
        for(int i = 0; i<q; i++) {
            int a = in.nextInt()-1;
            int b = in.nextInt()-1;
            if(adjMatrix[a][b] == Long.MAX_VALUE/2) out.println(-1);
            else out.println(adjMatrix[a][b]);
        }
        out.close();
    }
}

class FastScanner{
    private InputStream stream;                                                                                         
    private byte[] buf = new byte[1024];                                                                                
    private int curChar;                                                                                                
    private int numChars;                                                                                               

    public FastScanner(InputStream stream)
    {
       this.stream = stream;                                                                                            
    }

    int read()
    {
       if (numChars == -1)
          throw new InputMismatchException();                                                                           
       if (curChar >= numChars){
          curChar = 0;                                                                                                  
          try{
             numChars = stream.read(buf);                                                                               
          } catch (IOException e) {
             throw new InputMismatchException();                                                                        
          }
          if (numChars <= 0)
             return -1;                                                                                                 
       }
       return buf[curChar++];                                                                                           
    }

    boolean isSpaceChar(int c)
    {
       return c==' '||c=='\n'||c=='\r'||c=='\t'||c==-1;                                                                 
    }

    boolean isEndline(int c)
    {
       return c=='\n'||c=='\r'||c==-1;                                                                                  
    }

    int nextInt()
    {
       return Integer.parseInt(next());                                                                                 
    }

    long nextLong()
    {
       return Long.parseLong(next());                                                                                   
    }

    double nextDouble()
    {
       return Double.parseDouble(next());                                                                               
    }

    String next(){
       int c = read();                                                                                                  
       while (isSpaceChar(c))
          c = read();                                                                                                   
       StringBuilder res = new StringBuilder();                                                                         
       do{
          res.appendCodePoint(c);                                                                                       
          c = read();                                                                                                   
       }while(!isSpaceChar(c));                                                                                         
       return res.toString();                                                                                           
    }

    String nextLine(){
       int c = read();                                                                                                  
       while (isEndline(c))
          c = read();                                                                                                   
       StringBuilder res = new StringBuilder();                                                                         
       do{
          res.appendCodePoint(c);                                                                                       
          c = read();                                                                                                   
       }while(!isEndline(c));                                                                                           
       return res.toString();                                                                                           
    }
 }