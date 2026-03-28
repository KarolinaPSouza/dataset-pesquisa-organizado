import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;


public class entry_1758461 {

 @SuppressWarnings("unchecked")

 static int[] maxChild;
 static List<Integer>[] adjList;
 static int farthest;
 static int fdist;

 @SuppressWarnings("unchecked")
 public static void main(String[] args) throws Exception{
  FastIO sc = new FastIO(System.in);
  int N = sc.nextInt();
  adjList = new ArrayList[N];
  maxChild = new int[N];
  for (int i = 0;i<N;i++) {
   adjList[i] = new ArrayList<Integer>();
  }
  for (int i = 0;i<N-1;i++) {
   int a = sc.nextInt()-1;
   int b = sc.nextInt()-1;
   adjList[a].add(b);
   adjList[b].add(a);
   //System.out.println(adjList[7]+" "+a+" "+b);
  }
  //System.out.println(adjList[7]);
  int[] dist = new int[N];
  Stack<Integer> st = new Stack<Integer>();
  st.add(0);
  Arrays.fill(dist, -1);
  dist[0] = 0;
  int A = 0;
  int maxValA = 0;
  while(!st.isEmpty()) {
   int p = st.pop();
   for (int edge : adjList[p]) {
    if (dist[edge]==-1) {
     dist[edge] = dist[p]+1;
     if (dist[edge]>maxValA) {
      maxValA = dist[edge];
      A = edge;
     }
     st.add(edge);
    }
   }
  }
  //System.out.println(A);
  //System.out.println(adjList[7]);
  int[] distA = new int[N];
  Arrays.fill(distA, -1);
  st = new Stack<Integer>();
  st.add(A);
  distA[A] = 0;
  int B = 0;
  int maxValB = 0;
  while(!st.isEmpty()) {
   int p = st.pop();
   for (int edge : adjList[p]) {
    //if (p==9)
    if (distA[edge]==-1) {
     distA[edge] = distA[p]+1;
     //System.out.println(edge+" "+p+" "+distA[edge]+" "+distA[p]);
     if (distA[edge]>maxValB) {
      maxValB = distA[edge];
      B = edge;
     }
     st.add(edge);
    }
   }
  }
  //System.out.println(Arrays.toString(distA));
  //System.out.println(A+" "+B);
  int[] distB = new int[N];
  Arrays.fill(distB, -1);
  st.clear();
  st.add(B);
  distB[B] = 0;
  while(!st.isEmpty()) {
   int p = st.pop();
   for (int edge : adjList[p]) {
    if (distB[edge]==-1) {
     distB[edge] = distB[p]+1;
     st.add(edge);
    }
   }
  }
  //System.out.println(Arrays.toString(distA));
  //System.out.println(Arrays.toString(distB));
  StringBuilder str = new StringBuilder();
  for (int i = 0;i<N;i++) {
   str.append(Math.max(distA[i],distB[i])+" ");
  }
  System.out.println(str);

 }


 static class FastIO {

        InputStream dis;
        byte[] buffer = new byte[1 << 17];
        int pointer = 0;

        public FastIO(String fileName) throws Exception {
            dis = new FileInputStream(fileName);
        }

        public FastIO(InputStream is) throws Exception {
            dis = is;
        }

        int nextInt() throws Exception {
            int ret = 0;

            byte b;
            do {
                b = nextByte();
            } while (b <= ' ');
            boolean negative = false;
            if (b == '-') {
                negative = true;
                b = nextByte();
            }
            while (b >= '0' && b <= '9') {
                ret = 10 * ret + b - '0';
                b = nextByte();
            }

            return (negative) ? -ret : ret;
        }

        long nextLong() throws Exception {
            long ret = 0;

            byte b;
            do {
                b = nextByte();
            } while (b <= ' ');
            boolean negative = false;
            if (b == '-') {
                negative = true;
                b = nextByte();
            }
            while (b >= '0' && b <= '9') {
                ret = 10 * ret + b - '0';
                b = nextByte();
            }

            return (negative) ? -ret : ret;
        }

        byte nextByte() throws Exception {
            if (pointer == buffer.length) {
                dis.read(buffer, 0, buffer.length);
                pointer = 0;
            }
            return buffer[pointer++];
        }

        String next() throws Exception {
            StringBuffer ret = new StringBuffer();

            byte b;
            do {
                b = nextByte();
            } while (b <= ' ');
            while (b > ' ') {
                ret.appendCodePoint(b);
                b = nextByte();
            }

            return ret.toString();
        }

    }


}