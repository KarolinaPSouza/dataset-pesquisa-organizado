import java.util.*;
import java.lang.*;
public class entry_2270289 {
 public static void dfs(char [][] d,int i,int j,boolean[][] vis){
  if(i<0 || j<0||i>=d.length||j>=d[i].length || d[i][j]=='#'|| vis[i][j])
   return ;
  vis[i][j]=true;

    dfs(d,i-1,j,vis);


    dfs(d,i,j+1,vis);


    dfs(d,i,j-1,vis);


    dfs(d,i+1,j,vis);
 }

 public static void main(String aargs[]){
 Scanner s=new Scanner(System.in);
 int n=s.nextInt();
 int m=s.nextInt();
 char d[][]=new char[n][m];
 for(int i=0;i<n;i++){
  String s1=s.next();
  for(int j=0;j<m;j++){
   d[i][j]=s1.charAt(j);
  }
 }
 boolean vis[][]=new boolean[n][m];
 int c=0;
  for(int i=0;i<n;i++){
  for(int j=0;j<d[i].length;j++){
   if(d[i][j]=='.' && !vis[i][j]){
    dfs(d,i,j,vis);
   c++;
   }
  }
  }
  System.out.println(c);
}
}