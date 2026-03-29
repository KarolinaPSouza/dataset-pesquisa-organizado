//package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class entry_5832109 {
    public static class Edge{
        int v;
        long w;
        Edge(int v, long w){
            this.v=v;
            this.w=w;
        }
    }
    static long[] val;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int edges= sc.nextInt();

        List<List<Edge>> adjList = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<edges;i++){
            int u=sc.nextInt();
            int v=sc.nextInt();
            int w= sc.nextInt();
            adjList.get(u).add(new Edge(v,w));
        }
        val=new long[adjList.size()];
        for(int i=0;i<adjList.size();i++){
            val[i]=Long.MAX_VALUE;
        }
        List<Integer> cycle=new ArrayList<>();
        int source=1;
        while(cycle.size()==0 && source<adjList.size()){

                if(val[source]==Long.MAX_VALUE){
                    cycle=bellmanFord(adjList,edges,source,n);
                }
                source++;

        }
        if(cycle.size()!=0) {
            System.out.println("YES");
            Collections.reverse(cycle);
            for(int t: cycle){
                System.out.print(t+" ");
            }
            System.out.print(cycle.get(0));
        }
        else {
            System.out.println("NO");
        }
    }

    public static List<Integer> bellmanFord(List<List<Edge>> adjList,int edges,int source,int nodes){

        for(int i=0;i<adjList.size();i++){
            val[i]=Long.MAX_VALUE;
        }
        val[source]=0;
        int parent[] = new int[adjList.size()];
        parent[source]=1;
        boolean relaxed=false;
        for(int i=0;i<nodes;i++){
            relaxed=false;
            for(int j=1;j<adjList.size();j++){
               for(int k=0;k<adjList.get(j).size();k++){
                   if(val[j]<Long.MAX_VALUE && val[adjList.get(j).get(k).v]> val[j]+adjList.get(j).get(k).w){
                       relaxed=true;
                       parent[adjList.get(j).get(k).v]=j;
                       if(i==nodes-1){
                           return traverseParent(parent,j);
                       }
                       val[adjList.get(j).get(k).v]=val[j]+adjList.get(j).get(k).w;
                   }
               }
           }
           if(!relaxed){
               break;
           }
        }
        return new ArrayList<>();
    }

     public static List<Integer> traverseParent(int[] parent, int v){
        List<Integer> ans = new ArrayList<>();
        int[] visited = new int[parent.length];
        int temp=v;
        while (visited[temp]==0){
            visited[temp]=1;
            temp=parent[temp];
        }
        int start=temp;
        ans.add(temp);
        while(parent[temp]!=start){
            temp=parent[temp];
            ans.add(temp);
        }
        return ans;
     }
}