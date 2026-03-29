import java.util.*;
import java.io.*;
import java.text.*;
class comp
{
 static class FastReader 
 { 
  BufferedReader br; 
  StringTokenizer st; 

  public FastReader() throws Exception
  { 
   br = new BufferedReader(new
     InputStreamReader(System.in)); 
  } 

  String next() 
  { 
   while (st == null || !st.hasMoreElements()) 
   { 
    try
    { 
     st = new StringTokenizer(br.readLine()); 
    } 
    catch (IOException e) 
    { 
     e.printStackTrace(); 
    } 
   } 
   return st.nextToken(); 
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

  String nextLine() 
  { 
   String str = ""; 
   try
   { 
    str = br.readLine(); 
   } 
   catch (IOException e) 
   { 
    e.printStackTrace(); 
   } 
   return str; 
  } 
 }

 static class Node
 {
  int x,y;
  Node(int x, int y)
  {
   this.x=x;
   this.y=y;
  }

  @Override public boolean equals(Object x)
        {
            Node temp=(Node)x;
            return this.x==temp.x && this.y==temp.y;
        }

        @Override public int hashCode()
        {
            return 0;
        }

        @Override public String toString()
        {
         return "x=: "+x+" & y=: "+y;
        }
 }


 public static void main(String[] args) throws Exception {
  FastReader sc=new FastReader();
  PrintWriter out=new PrintWriter(new OutputStreamWriter(System.out));

  int t=1;
  int hh=0;

  while(hh++<t)
  {
   int n,m;
   n=sc.nextInt();
   m=sc.nextInt();

   int arr[][]=new int[n][m];

   int i,j;
   for(i=0; i<n; i++)
   {
    String str=sc.next();
    for(j=0; j<m; j++)
    {
     arr[i][j]=str.charAt(j);
    }
   }

   boolean marked[][]=new boolean[n][m];
   int count=0;

   for(i=0; i<n; i++)
   {
    for(j=0; j<m; j++)
    {
     if(arr[i][j]=='.' && !marked[i][j])
     {
      fillGrid(arr, marked, i, j);
      count++;
     } 
    }
   }
   out.println(count);

  }

  out.flush();


 }


 public static void fillGrid(int arr[][], boolean marked[][], int i, int j)
 {
  Stack<Node> st=new Stack<>();
  Node node = new Node(i,j);
  st.add(node);

  int xy[][]=new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};

  while(!st.isEmpty())
  {
   Node pop=st.pop();
   int x=pop.x;
   int y=pop.y;
   if(marked[x][y])
    continue;
   marked[x][y]=true;

   for(int v[]:xy)
   {
    int x1=x+v[0];
    int y1=y+v[1];

    if(x1<0 || x1>=arr.length || y1<0 || y1>=arr[0].length || arr[x1][y1]!='.')
     continue;

    Node val=new Node(x1,y1);

    if(marked[x1][y1])
     continue;
    st.add(val);
   }

  }

 }


}