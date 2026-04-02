import java.io.*;
import java.util.*;


public class entry_4785463 {

    public static void main(String[] args)throws IOException
    {
        Kattio bob = new Kattio();
        int N = bob.nextInt();

        int x = bob.nextInt();

        Point[] arr = new Point[N];

        for(int i=0; i<N; i++)
        {
            arr[i] = new Point(bob.nextInt(), i+1);
        }


        Arrays.sort(arr);

        for(int i=0; i<N; i++)
        {
            for(int j=i+1; j<N; j++)
            {
                int left =j+1;
                int right = N-1;

                while(left<right)
                {
                   // System.out.println(arr[i] + " " + arr[j] + " " + arr[left] + " " + arr[right]);
                    if(arr[i].val + arr[j].val + arr[left].val + arr[right].val == x)
                    {
                        System.out.println(arr[i].index + " " + arr[j].index + " " + arr[left].index + " " + arr[right].index);
                        System.exit(0);
                    }
                    else if(arr[i].val + arr[j].val + arr[left].val + arr[right].val > x)
                    {
                        right--;
                    }
                    else if(arr[i].val + arr[j].val + arr[left].val + arr[right].val < x)
                    {
                        left++;
                    }
                }
            }
        }

        bob.println("IMPOSSIBLE");
        bob.close();

    }
    static class Kattio extends PrintWriter {
  private BufferedReader r;
  private StringTokenizer st;
  // standard input
  public Kattio() { this(System.in, System.out); }
  public Kattio(InputStream i, OutputStream o) {
   super(o);
   r = new BufferedReader(new InputStreamReader(i));
  }
  // USACO-style file input
  public Kattio(String problemName) throws IOException {
   super(problemName + ".out");
   r = new BufferedReader(new FileReader(problemName + ".in"));
  }
  // returns null if no more input
  public String next() {
   try {
    while (st == null || !st.hasMoreTokens())
     st = new StringTokenizer(r.readLine());
    return st.nextToken();
   } catch (Exception e) { }
   return null;
  }
  public int nextInt() { return Integer.parseInt(next()); }
  public double nextDouble() { return Double.parseDouble(next()); }
  public long nextLong() { return Long.parseLong(next()); }
 }


}
class Point implements Comparable<Point>
{
    int index;
    int val;

    public Point(int val, int index)
    {
        this.val = val;
        this.index = index;
    }

    public int compareTo(Point o)
    {
        return Integer.compare(val, o.val);
    }
}