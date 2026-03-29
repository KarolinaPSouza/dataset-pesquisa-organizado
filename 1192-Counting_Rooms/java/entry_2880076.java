//package CodingRound;

import java.util.*;

public class entry_2880076 {
 static class Pair{
  int x;
  int y;

  Pair(int x , int y){
   this.x = x;
   this.y = y;
  }
 }
 public static void dfs(boolean visited[][] , char arr[][] , int i , int j) {

  if(i < 0 || j < 0 || i >= arr.length || j >= arr[0].length || visited[i][j] || arr[i][j] == '#') {
   return;
  }

  visited[i][j] = true;

  dfs(visited , arr , i+1 , j);
  dfs(visited , arr , i-1 , j);
  dfs(visited , arr , i , j+1);
  dfs(visited , arr , i , j-1);
 }

 public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);
  int n = sc.nextInt();
  int m = sc.nextInt();

  char arr[][] = new char[n][m];
  for(int i = 0 ; i < n ; i++) {
   String s = sc.next();
   for(int j = 0 ; j < m ; j++) {
    arr[i][j] = s.charAt(j);
   }
  }
  int cnt = 0;
  boolean visited[][] = new boolean [n][m];
  for(int i = 0 ; i < n ; i++) {
   for(int j = 0 ; j < m ; j++) {
    if(!visited[i][j] && arr[i][j] == '.') {
     dfs(visited , arr , i , j);
     cnt++;
    }
   }
  }
  System.out.println(cnt);
//  Queue<Pair> q= new LinkedList<>();
//  
//  int xCord[] = {1,-1,0,0};
//  int yCord[] = {0,0,-1,1};
//  boolean visited[][] = new boolean [n][m];
//  
//  for(int i = 0 ; i < n ; i++) {
//   for(int j = 0 ; j < m ; j++) {
//    if(arr[i][j] == '#') continue;
//    boolean ans = true;
//    for(int k = 0 ; k < 4 ; k++) {
//     int xC = xCord[k];
//     int yC = yCord[k];
//     if(i + xC >= 0 && j+ yC >= 0 && i + xC < n && j + yC < m) {
//       if(arr[i+xC][j+yC] == '.' && visited[i+xC][j+yC]) {
//       ans = false;
//       break;
//       }
//     }
//    }
//    if(ans) {
//     System.out.println(i + " " + j);
//     q.add(new Pair(i,j));
//     visited[i][j] = true;
//    }
//   }
//  }
//  int cnt = 0;
//  
//  while(!q.isEmpty()) {
//   Pair p = q.remove();
//   if(visited[p.x][p.y]) {
//    continue;
//   }
//   visited[p.x][p.y] = true;
//   int added = 0;
//   for(int k = 0 ; k < 4 ; k++) {
//    int xC = xCord[k];
//    int yC = yCord[k];
//    if(p.x + xC >= 0 && p.y + yC >= 0 && p.x + xC < n && p.y + yC < m) {
//      if(arr[p.x+xC][p.y+yC] == '.' && !visited[p.x+xC][p.y+yC]) {
//      q.add(new Pair(p.x+xC , p.y+yC));
//      added++;
//      }
//    }
//   }
//   if(added == 0) cnt++;
//  }
//  System.out.print(cnt);
 }

}