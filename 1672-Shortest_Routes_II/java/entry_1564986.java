import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class entry_1564986  {
 static class E{
  int j;
  int w;
  E(int j, int w){
   this.j = j;
   this.w = w;
  }
 }
 static ArrayList[] aa;
 static final long INF = 0x3f3f3f3f3f3f3f3fL;

 static HashMap<Integer, List<int[]>> graph;
    public static void main(String[] args) throws IOException {
  _Scanner sc = new _Scanner(System.in);
  int mod = 1000000007;
  int n = sc.nextInt();
  int m = sc.nextInt();
  int q = sc.nextInt();
  long[][] graph = new long[n][n];
  //floyd warshall
  //all pair shortest path
  for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                graph[i][j] = INF;
            graph[i][i] = 0;
        }
        while (m-- > 0) {
            int i = sc.nextInt() - 1;
            int j = sc.nextInt() - 1;
   int w = sc.nextInt();
   if(graph[i][j] > w){
    graph[i][j] = w;
    graph[j][i] = w;
   }
  }
  for (int k = 0; k < n; k++){
   for (int i = 0; i < n; i++){
    for(int j = i+1; j < n; j++){
     long a = graph[i][k] + graph[k][j];
     if(graph[i][j] > a){
      graph[i][j] = a;
      graph[j][i] = a;
     }
     //graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
    }
   }
  }
  while(q-- > 0){
   int a = sc.nextInt() - 1;
   int b = sc.nextInt() - 1;
   if(graph[a][b] == INF){
    System.out.println(-1);
   }
   else{
    System.out.println(graph[a][b]);
   }
  }




 }


    public static void quickSort(int[] arr, int lo, int hi) {
  if (lo >= hi) {
   return;
  }
  int mid = (lo + hi) / 2;
  int pivot = arr[mid];
  int left = lo;
  int right = hi;
  while (left <= right) {
   while (arr[left] < pivot) {
    left++;
   }
   while (arr[right] > pivot) {
    right--;
   }
   if (left <= right) {
    int temp = arr[left];
    arr[left] = arr[right];
    arr[right] = temp;
    left++;
    right--;
   }
  }
  quickSort(arr, lo, right);
  quickSort(arr, left, hi);
 }
 static class _Scanner {
        InputStream is;
        _Scanner(InputStream is) {
            this.is = is;
        }
        byte[] bb = new byte[1 << 15];
        int k, l;
        byte getc() throws IOException {
            if (k >= l) {
                k = 0;
                l = is.read(bb);
                if (l < 0) return -1;
            }
            return bb[k++];
        }
        byte skip() throws IOException {
            byte b;
            while ((b = getc()) <= 32)
                ;
            return b;
        }
        int nextInt() throws IOException {
            int n = 0;
            for (byte b = skip(); b > 32; b = getc())
                n = n * 10 + b - '0';
            return n;
        }
    }


    static class FastScanner {
  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
  StringTokenizer st=new StringTokenizer("");
  String next() {
   while (!st.hasMoreTokens())
    try {
     st=new StringTokenizer(br.readLine());
    } catch (IOException e) {
     e.printStackTrace();
    }
   return st.nextToken();
  }

  int nextInt() {
   return Integer.parseInt(next());
  }
  int[] readArray(int n) {
   int[] a=new int[n];
   for (int i=0; i<n; i++) a[i]=nextInt();
   return a;
  }
  long nextLong() {
   return Long.parseLong(next());
  }

  HashMap<Integer, List<int[]>> buildGraph(int n){
   HashMap<Integer, List<int[]>> graph = new HashMap<>();
   for(int i = 0; i < n; i++){
    int a = nextInt() -1 ;
    int b = nextInt() - 1;
    int c = nextInt() ;
    if(!graph.containsKey(a)){
     graph.put(a, new ArrayList<int[]>());
    }
    graph.get(a).add(new int[]{b,c});
   }

   return graph;
  }
 }
}
