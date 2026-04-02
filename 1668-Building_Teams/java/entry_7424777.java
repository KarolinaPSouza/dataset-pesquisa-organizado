//package com.cses.Graph;

import java.io.*;
import java.util.*;
public class entry_7424777 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer s = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(s.nextToken());
        int m=Integer.parseInt(s.nextToken());
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        for(int i=0;i<n;i++) list.add(new ArrayList<>());
        for(int i=0;i<m;i++) {
            StringTokenizer s1 = new StringTokenizer(br.readLine());
            int a=Integer.parseInt(s1.nextToken())-1;
            int b=Integer.parseInt(s1.nextToken())-1;
            list.get(a).add(b);
            list.get(b).add(a);
        }
        solve(list,n);
    }
    static void solve(ArrayList<ArrayList<Integer>> list,int n) {
        int[] arr=new int[n];
        boolean b=true;
        for(int i=0;i<n;i++) {
            if(arr[i]==0) {
                arr[i]=1;
                if(!func1(list,arr,i)) {
                    b=false;
                    break;
                }
            }
        }
        if(!b) System.out.println("IMPOSSIBLE");
        else {
            for(int i=0;i<n;i++) {
                if(arr[i]==0) arr[i]=1;
            }
            print(arr);
        }
    }
    static boolean func1(ArrayList<ArrayList<Integer>> list,int[] arr,int curr) {
        int a=arr[curr];
        ArrayList<Integer> internal=new ArrayList<>();
        internal=list.get(curr);
        for(int i=0;i<internal.size();i++) {
            int next=internal.get(i);
            int b=arr[next];
            if(b==0) {
                //arr[next]=(a==1)?2:1;
                if(a==1) {
                    arr[next]=2;
                }
                else arr[next]=1;
                if(!func1(list,arr,next)) {
                    return false;
                }
            }
            else if(a==b) {
                return false;
            }
        }
        return true;
    }

    static void print(int[] arr) {
        PrintWriter out=new PrintWriter(System.out);
        // Again iterating over very Big value
        for (int i = 0; i <arr.length; i++)
            out.print(arr[i] + " ");
        out.print("\n");
        // Flushing the content of the buffer to the
        // output stream using out.flush() methods
        out.flush();
    }
    static int hcf(int a, int b) {
        if(b==0) return a;
        return hcf(b,a%b);
    }
    static int lcm(int a,int b) {
        return (a*b)/hcf(a,b);
    }
    static void sort2dlist(ArrayList<ArrayList<Integer>> list) {
        Collections.sort(list, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                if(o1.get(0)!=o2.get(0))
                    return o1.get(0).compareTo(o2.get(0));
                else {
                    return o2.get(1).compareTo(o1.get(1));
                }
            }

        });
    }
    static void sort2darray(int[][] arr) {
        Arrays.sort(arr,(int[] a, int[] b)->{
            if(a[0]!=b[0])
                return a[0]-b[0];
            else return b[1]-a[1];

        });
    }
}
