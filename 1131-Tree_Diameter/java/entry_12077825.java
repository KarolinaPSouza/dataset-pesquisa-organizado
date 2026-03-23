import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class entry_12077825 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
 public static void main(String[] args) throws IOException
 {
  ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
  int N = Integer.parseInt(reader.readLine());

  String[] line;

  for(int i = 0; i < N; i++)
      matrix.add(new ArrayList<Integer>());

  for(int i = 0; i < N-1; i++)
  {
      line = reader.readLine().split(" ");
      int n = Integer.parseInt(line[0])-1;
      int k = Integer.parseInt(line[1])-1;

      matrix.get(n).add(k);
      matrix.get(k).add(n);
  }

  int x = fartestNode(fartestNode(0, matrix)[0], matrix)[1];
  System.out.println(x);
 }


 public static int[] fartestNode(int start, ArrayList<ArrayList<Integer>> matrix)
 {
     int size = matrix.size();
     Queue<Integer> que = new LinkedList<>();
     int[] distancias = new int[size];

     for(int i = 0; i < size; i++)
         distancias[i] = -1;

     que.add(start);
     distancias[start] = 0;

     int fartIndex = start;
     int maxDist = 0;

     while(!que.isEmpty())
     {
         int currentNode = que.poll();

         for(int x: matrix.get(currentNode))
         {
             if(distancias[x] == -1)
             {
                 distancias[x] = 1 + distancias[currentNode];
                 que.add(x);

                 if(maxDist < distancias[x])
                 {
                     maxDist = distancias[x];
                     fartIndex = x;
                 }
             }
         }
     }


     return new int[]{fartIndex, maxDist};
 }
}