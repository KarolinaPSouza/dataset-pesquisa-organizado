import java.util.*;
import java.io.*;

public class entry_3717710 {
    static int n;
    static int m;
    static int[][] A; // A[i, j] is the edit distance between the strings x1x2 . . . xi and y1y2 . . . yj
    static char[] x,y;

    public static void main(String arg[])
    {
        FastScanner in = new FastScanner(System.in);

        String s1 = in.nextLine();
        String s2 = in.nextLine();

        n = s1.length() + 1; // "" + s1
        m = s2.length() + 1; // "" + s2

        x = new char[n];
        y = new char[m];

        A = new int[n][m]; 

        for (int i = 0; i < n - 1; i++) {
            x[i] = s1.charAt(i);
        }

        for (int i = 0; i < m - 1; i++) {
            y[i] = s2.charAt(i);
        }

        int a = 0;
        int b = 0;
        while (a < n || b < m) {
            if (a < n)
                A[a][0] = a; 
            if (b < m)
                A[0][b] = b;
            a++;
            b++;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp(i, j);
            }
        }

        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < m; j++) {
        //         System.out.print(A[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        System.out.println(A[n-1][m-1]);
    }

    static public void dp(int i, int j) {
        int c = 1;
        if (x[i - 1] == y[j - 1])
            c = 0;

        A[i][j] = Math.min(c + A[i-1][j-1], 
                    Math.min(1 + A[i][j-1], 1 + A[i-1][j]));

    }

}


/* Matt Fontaine 
http://www.usaco.org/current/data/sol_disrupt_platinum_open18.html */
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
