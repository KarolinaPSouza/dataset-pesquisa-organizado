//package csesproblems;

import java.io.*;
import java.util.*;


public class entry_2168681 {
 static class Edge{
  int v;
  long w;
  Edge(int v,long w){
   this.v=v;
   this.w=w;
  }
 }

 static class Pair{
  int v;
  long w;
  int f;
  Pair(int v,long w,int f){
   this.v=v;
   this.w=w;
   this.f=f;
  }
 }

 public static void main(String[] args) throws IOException {
  BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
  String str=reader.readLine();
  String[] s=str.split(" ");
     int n=Integer.parseInt(s[0]);
     int m=Integer.parseInt(s[1]);
  ArrayList<Edge>graph[]=new ArrayList[n];
  for(int i=0;i<n;i++) {
   graph[i]=new ArrayList<>();
  }
  for(int i=0;i<m;i++) {
   String st=reader.readLine();
         String[] s1=st.split(" ");
         int v1=Integer.parseInt(s1[0])-1;
         int v2=Integer.parseInt(s1[1])-1;
         long w=Long.parseLong(s1[2]);
   graph[v1].add(new Edge(v2,w));
   //graph[v2].add(new Edge(v1,w));
  }
  long[][] dis=new long[n][2];
  boolean[][] vis=new boolean[n][2];
  for(int i=0;i<n;i++) {
   Arrays.fill(dis[i], Long.MAX_VALUE);
  }

  dis[0][0]=0;
  dis[0][1]=0;
  PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->Long.compare(a.w, b.w));
  pq.add(new Pair(0,0,0));
  while(!pq.isEmpty()) {
   Pair temp=pq.peek();
   pq.remove(pq.peek());
//   System.out.println(temp.v+" "+temp.w+" "+temp.f);
   if(vis[temp.v][temp.f]) {
    continue;
   }
   vis[temp.v][temp.f]=true;
   for(Edge i:graph[temp.v]) {
    if(temp.f==0) {
     if(dis[i.v][0]>temp.w+i.w) {
      dis[i.v][0]=temp.w+i.w;
      pq.add(new Pair(i.v,dis[i.v][0],0));
     }
     if(dis[i.v][1]>temp.w+i.w/2) {
      dis[i.v][1]=temp.w+i.w/2;
      pq.add(new Pair(i.v,dis[i.v][1],1));
     }
     if(dis[i.v][1]>temp.w+i.w) {
      dis[i.v][1]=temp.w+i.w;
      pq.add(new Pair(i.v,dis[i.v][1],1));
     }
    }else if(temp.f==1) {
     if(dis[i.v][1]>temp.w+i.w) {
      dis[i.v][1]=temp.w+i.w;
      pq.add(new Pair(i.v,dis[i.v][1],1));
     }
    }
   }
  }
//  for(int i=0;i<n;i++) {
//   System.out.print(dis[i][0]+" ");
//  }
//  System.out.println();
//  for(int i=0;i<n;i++) {
//   System.out.print(dis[i][1]+" ");
//  }
//  System.out.println();
  System.out.println(Math.min(dis[n-1][0],dis[n-1][1]));
 }
}