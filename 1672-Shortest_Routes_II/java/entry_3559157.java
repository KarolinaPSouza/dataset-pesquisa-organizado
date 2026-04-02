import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class entry_3559157 {
 public static void floydWarshall(long[][] mat) {
  int n = mat.length;
  for(int k = 0; k < n; k++) {
   for(int i = 0; i < n; i++) {
    if(mat[i][k] != Long.MAX_VALUE) {
     for(int j = 0; j < i; j++) {
      if(mat[k][j] != Long.MAX_VALUE) {
       long curr = mat[i][k] + mat[k][j];
       mat[i][j] = Math.min(curr, mat[i][j]);
       mat[j][i] = mat[i][j];
      }
     }
    }
   }
  }
    }

 public static void main(String[] args) {
     FastScanner sc = new FastScanner(System.in);
     StringBuilder sb = new StringBuilder();
     int n = sc.nextInt();
     int m = sc.nextInt();
     int q = sc.nextInt();

     long[][] mat = new long[n][n];
     for(int i = 0; i < n; i++) {
      for(int j = 0; j < n; j++) {
       mat[i][j] = i == j ? 0 : Long.MAX_VALUE;
      }
     }

     for(int i = 0; i < m; i++) {
      int s = sc.nextInt() - 1;
      int d = sc.nextInt() - 1;
      long cost = sc.nextInt();
      mat[s][d] = Math.min(cost, mat[s][d]);
      mat[d][s] = Math.min(cost, mat[d][s]);
     }

     floydWarshall(mat);

     for(int i = 0; i < q; i++) {
      int s = sc.nextInt() - 1;
      int d = sc.nextInt() - 1;
      sb.append(mat[s][d] == Long.MAX_VALUE ? -1 : mat[s][d]);
      sb.append("\n");
     }

     System.out.println(sb.toString());
 }

 /*
  *  FastScanner developed by Matt Fontaine
  */
 public static class FastScanner{
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
}