import java.util.*;
import java.io.*;
public class entry_3255581 {
  static int N; // number of players
  static int M; // numbers of games played  
  static boolean[][] house;

  public static void main(String[] args) throws IOException{    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine()); 
    N=Integer.parseInt(st.nextToken());     
    M=Integer.parseInt(st.nextToken()); 
  house= new boolean[N][M];
  for(int i=0;i<N;i++){
   String s=br.readLine();
   for(int j=0;j<M;j++){
    house[i][j]=(s.charAt(j)=='#');
   }
  }
  int ans=0;
  for(int i=0;i<N;i++){
   for(int j=0;j<M;j++){
    if (!house[i][j]){
     mark(i,j);
     ans++;
    }
   }
  }
  System.out.println(ans);

  }
  public static void mark(int x,int y){
    try{
   if (house[x][y]) return;
  }
  catch(Exception e){return;}
  house[x][y]=true;
  mark(x-1,y);
  mark(x+1,y);
  mark(x,y-1);
  mark(x,y+1);
  }
}
class Player{
 public ArrayList<Integer>children;
 public Player(){
  children=new ArrayList<Integer>();
 }
 public void add(int a){
  children.add(a);
 }
 public boolean isEmpty(){
  return children.isEmpty();
 }
}