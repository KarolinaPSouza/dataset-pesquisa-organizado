import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.PriorityQueue;

import javax.print.attribute.HashAttributeSet;


public class entry_3565253 {
    public static void main(String[] args) {
        FastScanner in  = new FastScanner(System.in);
        int cities = in.nextInt();
        int roads = in.nextInt();
        int queries = in.nextInt();

        long inf  = (long) Math.pow(10, 12);


        long[][] dist = new long[cities][cities];
        for (int j = 0; j < cities; j++) {
            for (int g = 0; g < cities; g++) {
                if (j == g) dist[j][g] = 0;
                else dist[j][g] = inf;
            }
        }
        for (int i = 0; i < roads; i++) {
            int start = in.nextInt() - 1;
            int dest = in.nextInt() - 1;
            int weight = in.nextInt();
            dist[start][dest] = Math.min(weight, dist[start][dest]);
            dist[dest][start] = Math.min(weight, dist[dest][start]);
        }

        for (int k = 0; k < cities; k++) {
            for (int v = 0; v < cities; v++) {
                for (int w = 0; w < cities; w++) {
                    dist[v][w] = Math.min(dist[v][k] + dist[k][w], dist[v][w]);
                }
            }
        }

        StringBuilder s = new StringBuilder("");
        for (int j = 0; j < queries; j++) {
            int start = in.nextInt() - 1;
            int end = in.nextInt() - 1;
            long pathLen = dist[start][end];
            if (pathLen >= inf) s.append(-1 + "\n");
            else s.append(pathLen + "\n");
        }
        System.out.println(s);
    }





    public static long dijkstra(ArrayList<No> graph, No start, No end) {
        PriorityQueue<No> q = new PriorityQueue<>();
        // reset visited values
        for (No n : graph) {
            n.visited = false;
            n.cost = Long.MAX_VALUE;
        }


        start.cost = 0;
        q.add(start);

        while (!q.isEmpty()) {
            // pop off q
            No curr = q.remove();
            if (curr.visited) continue;
            if (curr.equals(end)) return curr.cost; 
            curr.visited = true;
            // go through neighbors
            for (Edge e : curr.neighbors) {
                No next = e.dest;
                long newCost = curr.cost + e.weight;
                if (!next.visited && newCost < next.cost) {
                    // if (next.equals(end)) return newCost; // return early if found
                    next.cost = newCost;
                    q.add(next);
                }
            }
        }

       return Long.MAX_VALUE; // return inf if couldn't find a path
    }

}


class No implements Comparable<No>{
    int id;
    long cost;
    HashSet<Edge> neighbors;
    boolean visited;

    public No(int id) {
        this.id = id;
        cost = Long.MAX_VALUE;
        neighbors = new HashSet<>();
        visited = false;
    }
    public int compareTo(No other) {
        return Long.compare(this.cost, other.cost);
    }

}

class Edge {
    No dest;
    int weight;

    public Edge(No dest, int weight) {
        this.dest = dest;
        this.weight = weight;
    }

}





/* class created by Matt Fontaine */
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