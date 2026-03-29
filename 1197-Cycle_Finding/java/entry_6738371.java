import java.io.*;
import java.util.*;

 class cses1193 {
    public static int[] dX = {1, -1, 0, 0};
    public static int[] dY = {0, 0, 1, -1};
    public static String dirs = "DURL";
    public static int N;
    public  static long M;

     static class FastIO extends PrintWriter {

         private InputStream stream;

         private byte[] buf = new byte[1 << 16];

         private int curChar, numChars;


         // standard input

         public FastIO() { this(System.in, System.out); }

         public FastIO(InputStream i, OutputStream o) {

             super(o);

             stream = i;

         }

         // file input

         public FastIO(String i, String o) throws IOException {

             super(new FileWriter(o));

             stream = new FileInputStream(i);

         }


         // throws InputMismatchException() if previously detected end of file

         private int nextByte() {

             if (numChars == -1) throw new InputMismatchException();

             if (curChar >= numChars) {

                 curChar = 0;

                 try {

                     numChars = stream.read(buf);

                 } catch (IOException e) { throw new InputMismatchException(); }

                 if (numChars == -1) return -1;  // end of file

             }

             return buf[curChar++];

         }


         // to read in entire lines, replace c <= ' '

         // with a function that checks whether c is a line break

         public String next() {

             int c;

             do { c = nextByte(); } while (c <= ' ');

             StringBuilder res = new StringBuilder();

             do {

                 res.appendCodePoint(c);

                 c = nextByte();

             } while (c > ' ');

             return res.toString();

         }

         public int nextInt() {  // nextLong() would be implemented similarly

             int c;

             do { c = nextByte(); } while (c <= ' ');

             int sgn = 1;

             if (c == '-') {

                 sgn = -1;

                 c = nextByte();

             }

             int res = 0;

             do {

                 if (c < '0' || c > '9') throw new InputMismatchException();

                 res = 10 * res + c - '0';

                 c = nextByte();

             } while (c > ' ');

             return res * sgn;

         }

         public double nextDouble() { return Double.parseDouble(next()); }

     }
    public static void main(String[] args) throws IOException {
        FastIO io = new FastIO();
        N = io.nextInt();
        M = io.nextInt();
        Map<Integer, point> map=new HashMap<>();
        ArrayList<ArrayList<point>> adj=new ArrayList<>();
        for (int i = 0; i <=N ; i++) {
           adj.add(new ArrayList<>());
        }
        for (int i = 0; i <M ; i++) {

            int u =io.nextInt();
            int v = io.nextInt();
            long w =io.nextInt();
            adj.get(u).add(new point(v,w));
          //  adj.get(v).add(new point(u,w));
        }
        long [] dit = new long[N+1];
        int [] parent = new int[N+1];
        PriorityQueue<point> pq=new PriorityQueue<>((a,b)-> (int) ((a.y-b.y)/(double)Integer.MAX_VALUE-100));
        int x=0;
        for (int i = 0; i <N ; i++) {
            x = -1;
            for(int j=1;j<=N;j++){
                for (point p: adj.get(j)){
                    if(dit[p.x]>dit[j]+ p.y){
                        dit[p.x] = dit[j]+p.y;
                        parent[p.x] = j;
                        x = p.x;
                    }
                }
            }
        }
        if(x==-1){
            System.out.println("NO");
        }else {
            System.out.println("YES");
            for (int i = 0; i <N ; i++) {
                x= parent[x];
            }
            ArrayList<Integer> an=new ArrayList<>();
            for (int i = x;  ; i = parent[i]) {
                an.add(i);
                if(i==x && an.size()>1){
                    break;
                }


            }
          //  System.out.println(an.size());
            Collections.reverse(an);
            for (int j:an){
                System.out.print(j+" ");
            }
            System.out.println();
        }

    }

    // Whether or not the point is on the grid.
    public static boolean onGrid(int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < M);
    }

    public static class point {
        public int x;
        public long y;
      //  public int z;

        public point(int x, long y) {
            this.x = x;
            this.y = y;
           // this.z=z;
        }
    }
}