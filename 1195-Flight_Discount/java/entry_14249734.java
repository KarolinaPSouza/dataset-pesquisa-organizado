//package com.ssfl.asynctesting.cses.graph;


//Your task is to find a minimum-price flight route from Syrjälä to Metsälä. You have one discount coupon,
// using which you can halve the price of any single flight during the route. However, you can only use the coupon once.
//When you use the discount coupon for a flight whose price is x, its price becomes \lfloor x/2 \rfloor (it is rounded
// down to an integer).
//Input
//The first input line has two integers n and m: the number of cities and flight connections. The cities are numbered
// 1,2,\ldots,n. City 1 is Syrjälä, and city n is Metsälä.
//After this there are m lines describing the flights. Each line has three integers a, b, and c:
// a flight begins at city a, ends at city b, and its price is c. Each flight is unidirectional.
//You can assume that it is always possible to get from Syrjälä to Metsälä.
//Output
//Print one integer: the price of the cheapest route from Syrjälä to Metsälä.
//Constraints
//
//2 \le n \le 10^5
//        1 \le m \le 2 \cdot 10^5
//        1 \le a,b \le n
//1 \le c \le 10^9
//
//Example
//Input:
//        3 4
//        1 2 3
//        2 3 1
//        1 3 7
//        2 1 5
//
//Output:
//        2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class entry_14249734 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st1=br.readLine().split(" ");
        int n=Integer.parseInt(st1[0]);
        int m=Integer.parseInt(st1[1]);
        ArrayList<ArrayList<long[]>> adjList = new ArrayList<>();

        for(int i=0;i<=n;i++) {
            adjList.add(new ArrayList<>());
        };

        for(int i=0;i<m;i++){
            String[] st2=br.readLine().split(" ");
            int a=Integer.parseInt(st2[0]);
            int b=Integer.parseInt(st2[1]);
            int c=Integer.parseInt(st2[2]);
            adjList.get(a).add(new long[]{b,c});
        }
        long[][] dist= new long[n+1][2]; //not used , used
        for(int i=0;i<=n;i++) Arrays.fill(dist[i],Long.MAX_VALUE);
        dist[1][0]=0;
        dist[1][1]=0;
        PriorityQueue<long[] > q = new PriorityQueue<>((a,b)-> Long.compare(a[1],b[1])); // {node,distance,used}   0 false 1 true
        q.add(new long[]{1,0,0});

        while(!q.isEmpty()){
            long[] curr=q.remove();
            int currNode = (int)curr[0];
            long currDis = curr[1];
            int used = (int)curr[2];
            if(dist[currNode][used]<currDis) continue;
            for(long[] neigh:adjList.get(currNode)){
                int neighNode = (int)neigh[0];
                long pathWight = neigh[1];

                if(dist[(int)neighNode][(int)used] > currDis+pathWight){
                    dist[(int)neighNode][used] = currDis+pathWight;
                    q.add(new long[]{neighNode,dist[neighNode][used],used});
                }
                // using the discount
                if(used==0){
                    if(dist[neighNode][1]>currDis+(pathWight/2)){
                        dist[neighNode][1]=currDis+(pathWight/2);
                        q.add(new long[]{neighNode,dist[neighNode][1],1});
                    }
                }
            }
        }
//        System.out.println("---------------");
//        for(int i=0;i<=n;i++){
//            System.out.println(dist[i][0]+"  "+dist[i][1]);
//        }
        System.out.println(Math.min(dist[n][0],dist[n][1]));
    }
}